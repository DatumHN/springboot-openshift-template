package dev.snowdrop.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * HISTORIAL DE CAMBIOS
 * Fecha                    Autor                  Descripción
 * 03/09/2024               Melvin Cruz  		       Clase que será la encargada de renderizar el detalle Swagger de los servicios implementados en el proyecto.
 **/

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Value("${paquete.servicios}")
	String paqueteApis;
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.OAS_30)  
        .select()                                       
        .apis(RequestHandlerSelectors.basePackage(paqueteApis))
        .paths(PathSelectors.any())                     
        .build().apiInfo(apiInfo());                                        
    }
	
	 public ApiInfo apiInfo() { 
	        return new ApiInfoBuilder()
	            .title("Ejemplo API")
	            .description(
	                "API que funciona como plantilla base para futuros proyectos de backend creado con Spring Framework y que se desplegarán en la nube utilizando OpenShift.")
	            .version("1.0.0")
	            .build();                                        
	    }
}
