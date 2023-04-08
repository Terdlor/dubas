package com.terdev.dubas.jpa

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import java.util.*
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories("com.terdev.dubas.jpa")
@EntityScan("com.terdev.dubas.jpa")
class JpaConfig {

    @Bean
    fun entityManagerFactory(dataSource: DataSource?): LocalContainerEntityManagerFactoryBean? {
        val emf = LocalContainerEntityManagerFactoryBean()
        emf.dataSource = dataSource!!
        emf.setPackagesToScan("com.terdev.dubas.jpa")
        val vendorAdapter: JpaVendorAdapter = HibernateJpaVendorAdapter()
        emf.jpaVendorAdapter = vendorAdapter
        val properties = Properties()
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
        properties.setProperty("hibernate.show_sql", "true")
        emf.setJpaProperties(properties)
        return emf
    }

    @Bean
    fun transactionManager(emf: EntityManagerFactory?): PlatformTransactionManager? {
        return JpaTransactionManager(emf!!)
    }

    @Bean
    fun dataSource(): HikariDataSource? {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:postgresql://localhost:5438/postgres"
        config.username = "postgres"
        config.password = "1284"
        config.maximumPoolSize = 20
        config.minimumIdle = 10
        config.connectionTimeout = 5000
        config.idleTimeout = 600000
        config.maxLifetime = 1800000
        return HikariDataSource(config)
    }

}