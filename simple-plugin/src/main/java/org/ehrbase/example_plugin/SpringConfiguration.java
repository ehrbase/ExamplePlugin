package org.ehrbase.example_plugin;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Stefan Spiska
 */
@Configuration
@ComponentScan(basePackages = {"org.ehrbase.example_plugin"})
@EnableConfigurationProperties(TestProperty.class)
public class SpringConfiguration {}
