package config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Itau Bank")
                        .version("0.0.1")
                        .description("Desafio da criação de uma conta digital do itau para a vaga de Jr")
                        .termsOfService("http://www.termsofservice.url")
                        .contact(descriptionContact())
                        .license(descriptionLicense())
                );
    }

    private Contact descriptionContact() {
        return new Contact()
                .name("Mateus Araújo")
                .email("mateusaraujo996@gmail.com")
                .url("https://www.linkedin.com/in/mateusaraujobarros/");
    }

    private License descriptionLicense() {
        return new License()
                .name("License")
                .url("#");
    }
}
