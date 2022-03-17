package org.ehrbase.example_plugin;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Stefan Spiska
 */
@Configuration
@ComponentScan(basePackages = {"org.ehrbase.example_plugin"})
public class SpringConfiguration {



}
