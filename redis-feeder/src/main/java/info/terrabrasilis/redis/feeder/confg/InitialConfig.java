package info.terrabrasilis.redis.feeder.confg;

import java.io.Serializable;

import javax.sql.DataSource;

import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

/**
 * 
 * @author jether
 *
 */
@Configuration
public class InitialConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1606126622021267670L;

	@Autowired
	private DataSource dataSource;
	 
	@Bean
	public DataSourceConnectionProvider connectionProvider() {
	    return new DataSourceConnectionProvider
	      (new TransactionAwareDataSourceProxy(dataSource));
	}
	
	@Bean
	public DefaultDSLContext dsl() {
	    return new DefaultDSLContext(configuration());
	}
	
	public DefaultConfiguration configuration() {
	    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
	    jooqConfiguration.set(connectionProvider());
	    
	    return jooqConfiguration;
	}	
}
