package com.newland.bootdata;

import com.newland.bootdata.custom.CustomJpaRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = {"com.newland.bootdata"},
        repositoryImplementationPostfix = "Impl",
        repositoryFactoryBeanClass= CustomJpaRepositoryFactoryBean.class, //class
        entityManagerFactoryRef="entityManagerFactory",
        transactionManagerRef="transactionManager"
)
public class BootSpringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSpringdataApplication.class, args);
    }

}
