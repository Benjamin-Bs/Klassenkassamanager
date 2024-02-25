package at.htlhl.klassenkassamanagerweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // TODO expand the url to every host (not only localhost)
                .allowedMethods("GET", "POST", "PATCH", "DELETE")
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept");
    }
}
