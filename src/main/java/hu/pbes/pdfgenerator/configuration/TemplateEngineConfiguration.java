package hu.pbes.pdfgenerator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@Configuration
public class TemplateEngineConfiguration {

    @Bean
    public TemplateEngine templateEngine() {
        final var engine = new TemplateEngine();
        final var stringResolver = new StringTemplateResolver();
        stringResolver.setTemplateMode(TemplateMode.HTML);
        engine.setTemplateResolver(stringResolver);
        return engine;
    }

}
