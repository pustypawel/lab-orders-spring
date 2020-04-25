package pl.edu.wszib.labordersspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class LabOrdersSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabOrdersSpringApplication.class, args);
    }

}
