package org.ehrbase.example_web_plugin;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Stefan Spiska
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.ehrbase.example_web_plugin"})
@EnableConfigurationProperties(TestProperty.class)
public class SpringConfiguration {}
