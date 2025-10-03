package grupo8.tecnoRAEE.dto;

import java.util.List;

import grupo8.tecnoRAEE.dao.*;
import grupo8.tecnoRAEE.model.*;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Configuration
@AllArgsConstructor
public class ResiduoImp implements ResiduoDao {

    private final Sql2o sql2o;

    @Bean
    public ResiduoImp Residuo(Sql2o sql2o){
        return new ResiduoImp(sql2o);
    }

    @Override
    public List<Residuo> getResiduos() {

        return null;
    }

    @Override
    public List<Residuo> listarValidos(){
        List<Residuo> res;
        String sql = "Select * from residuos where es_valido=1;";
        try (Connection con = sql2o.open()) {
            res = con
                    .createQuery(sql)
                    .executeAndFetch(Residuo.class);
            return res;
        }
    }
}
