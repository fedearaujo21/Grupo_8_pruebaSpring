package grupo8.tecnoRAEE.model;

import org.sql2o.Sql2o;


public class Sql2oDAO {
    private static Sql2o sql2o;

    public static Sql2o getSql2o() {
        if (sql2o == null) {
            sql2o = new Sql2o("jdbc:mysql://localhost:3306", "", "");
        }
        return sql2o;
    }
    
}

