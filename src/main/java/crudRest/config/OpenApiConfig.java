package crudRest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Miguel Castro
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api() {

        return new OpenAPI()
                .info(new Info()
                        .title("REST API")
                        .version("v1")
                        .description("CRUD REST API with content negotiation, HATEOAS and swagger"));
        //http://localhost:8080/swagger-ui/index.html
    }
}
