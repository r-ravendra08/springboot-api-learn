package com.springboot.configuration;
import java.util.ArrayList;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import springfox.documentation.service.ApiInfo;  
import springfox.documentation.service.Contact;  
import springfox.documentation.service.VendorExtension;  
import springfox.documentation.spi.DocumentationType;  
import springfox.documentation.spring.web.plugins.Docket;  
import springfox.documentation.swagger2.annotations.EnableSwagger2;  
//Configuration  
@Configuration  
//Enable Swagger  
@EnableSwagger2  
public class SwaggerConfig   
{  
//configuring the contact detail  
public static final Contact DEFAULT_CONTACT = new Contact("Ravendra Kumar", "https://r-ravendra08.github.io/", "kumarravenddra055@gmail.com");  
//configuring DEFAULT_API_INFO  
public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Springboot rest api implement swagger", "created springboot rest api.Here api add employee, get employee, update employee,and delete employee.", "1.0", "https://www.termsandcondiitionssample.com/",DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

//creating bean  
    @Bean
    Docket api()
    {
        ApiInfo apiInfo;
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
    }  
}  