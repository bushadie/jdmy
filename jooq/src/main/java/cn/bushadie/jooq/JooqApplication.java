package cn.bushadie.jooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class JooqApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooqApplication.class,args);
    }

}
