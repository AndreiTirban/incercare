package ro.fortech.whiteboard.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearer-jwt",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER).name("Authorization")))
                .info(new Info()
                        .title("Whiteboard Tool API")
                        .description("<h2> Whiteboard Tool supports teams to collaborate visually over distance in real-time. </h2>" +
                                "<h4> **Note**: This API requires an `API KEY` which can be obtained from an API client (`Postman`)" +
                                " after login. </h4> " +
                                "<h4> Before trying out the endpoints, the `Authorize` button must be clicked and the key pasted there. </h4>"))
                .addSecurityItem(
                        new SecurityRequirement().addList("bearer-jwt", Arrays.asList("read", "write")));
    }
}
