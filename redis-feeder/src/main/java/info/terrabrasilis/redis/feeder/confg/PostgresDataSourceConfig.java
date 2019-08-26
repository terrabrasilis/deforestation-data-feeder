package info.terrabrasilis.redis.feeder.confg;
//package info.terrabrasilis.data.api.confg;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.*;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import static java.util.Collections.singletonMap;
//
//@Configuration
//@PropertySource({ "classpath:application.properties" })
//@EnableJpaRepositories(
//    basePackages = "info.terrabrasilis.data.api.repository", 
//    entityManagerFactoryRef = "postgresEntityManager", 
//    transactionManagerRef = "postgresTransactionManager"
//)
//public class PostgresDataSourceConfig {
//	
//	@Primary
//    @Bean(name = "postgresEntityManagerFactory")
//	@SuppressWarnings("static-method")
//    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
//    		final EntityManagerFactoryBuilder builder
//    		, final @Qualifier("postgres-db") DataSource dataSource) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.marcosbarbero.wd.pcf.multidatasources.first.domain")
//                .persistenceUnit("firstDb")
//                .properties(singletonMap("hibernate.hbm2ddl.auto", "create-drop"))
//                .build();
//    }
//
//    @Primary
//    @Bean(name = "postgresTransactionManager")
//    @SuppressWarnings("static-method")
//    public PlatformTransactionManager postgresTransactionManager(
//    		@Qualifier("firstEntityManagerFactory") EntityManagerFactory postgresEntityManagerFactory) {
//        return new JpaTransactionManager(postgresEntityManagerFactory);
//    }
//}
