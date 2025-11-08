package grupo8.tecnoRAEE.dao;

import grupo8.tecnoRAEE.model.Tabla;
import lombok.AllArgsConstructor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.lang.reflect.Field;


public abstract class InsertDAO {

    public InsertDAO(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    private final Sql2o sql2o;


    public <T> Long insertar(T model) throws Exception {
        Class<?> clase = model.getClass();

        Field[] campos = clase.getFields();

        StringBuilder columnas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        //Obtenemos la anotacion
        String nombreTabla = clase.getAnnotation(Tabla.class).nombre();


        for (Field f : campos) {
            f.setAccessible(true);
            Object valor = f.get(model);
            if (valor != null) {
                if (!columnas.isEmpty()) {
                    columnas.append(", ");
                    valores.append(", ");
                }
                columnas.append(f.getName());
                valores.append(":").append(f.getName());
            }
        }


        String sql = "INSERT INTO " + nombreTabla + " (" + columnas + ") VALUES (" + valores + ")";

        try (Connection con = sql2o.open()) {
            var query = con.createQuery(sql, true); // true → devuelve la clave generada

            // Agregamos los parámetros dinámicamente
            for (Field f : campos) {
                f.setAccessible(true);
                Object valor = f.get(model);
                if (valor != null) {
                    query.addParameter(f.getName(), valor);
                }
            }
            // Ejecutamos y devolvemos la clave generada
            return query.executeUpdate().getKey(Long.class);
        } catch (Exception e) {
            throw new Exception("Error guardando " + nombreTabla, e);
        }
    }
}

