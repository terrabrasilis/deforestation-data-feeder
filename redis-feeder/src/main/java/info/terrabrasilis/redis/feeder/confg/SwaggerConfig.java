package info.terrabrasilis.redis.feeder.confg;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author jether
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2) 
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("info.terrabrasilis.redis.feeder.resources"))  
          .paths(regex("/api.*"))                     
          .build()
          .apiInfo(metaData());
    }

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Terrabrasilis dashboard REST API", "Terrabrasilis dashboard REST API", "1.0",
				"Terms of service",
				new Contact("Terrabrasilis", "http://terrabrasilis.info/", "dev.team@terrabrasilis.info"),
				"2018 © DataAPI.", "http://terrabrasilis.info/");
		return apiInfo;
	}

}