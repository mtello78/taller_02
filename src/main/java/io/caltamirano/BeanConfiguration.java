package io.caltamirano;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .tags(
        		new Tag("Empresa", "Servicio para gestionar empresas")
          );
    }
	
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("REST API", "Servicio para el aplicativo Facturación Electrónica", "1.0", "CopyLeft", new Contact("Carlos Altamirano", "www.carlosaltamirano.dev", "alt.carlos@gmail.com"), "License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }

}
