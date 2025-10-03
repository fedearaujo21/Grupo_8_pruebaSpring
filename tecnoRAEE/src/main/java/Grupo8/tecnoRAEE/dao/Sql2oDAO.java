package grupo8.tecnoRAEE.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class Sql2oDAO {
    private Sql2o sql2o;

    @Bean
    public Sql2o Sql2o() {
            return new Sql2o("jdbc:mysql://localhost:3306/tecno_raee_db", "root", "");
    }

}

