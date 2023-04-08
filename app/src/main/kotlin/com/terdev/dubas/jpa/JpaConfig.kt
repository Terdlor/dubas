package com.terdev.dubas.jpa

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories("com.terdev.dubas.jpa")
@EntityScan("com.terdev.dubas.jpa")
class JpaConfig {


    @Bean
    fun entityManagerFactory(): LocalEntityManagerFactoryBean {
        val emf = LocalEntityManagerFactoryBean()
        //emf.persistenceUnitName = "myDatabase"
        return emf
    }

    @Bean
    fun transactionManager(): JpaTransactionManager? {
        val tm = JpaTransactionManager()
        tm.entityManagerFactory = entityManagerFactory().getObject()
        tm.dataSource = dataSource()
        return tm
    }

    @Bean
    fun dataSource(): DataSource? {
        val ds = DriverManagerDataSource()
        ds.setDriverClassName("org.postgresql.Driver")
        ds.url = "jdbc:postgresql://localhost:5438/dubas"
        ds.username = "postgres"
        ds.password = "1284"
        return ds
    }

}