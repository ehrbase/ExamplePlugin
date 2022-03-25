package org.ehrbase.example_plugin;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Stefan Spiska
 */
@ConfigurationProperties(prefix = "test.sub1")
public class TestProperty {

  private String property;

  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  @Override
  public String toString() {
    return "TestProperty{" + "property='" + property + '\'' + '}';
  }
}
