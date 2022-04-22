package org.ehrbase.example_web_plugin;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Stefan Spiska
 */
// Read from ${plugin-config-dir}\${plugin.id}\test.json and
// Read from ${plugin-config-dir}\${plugin.id}\test.xml
@ConfigurationProperties(prefix = "test")
public class TestProperty {

  private Sub sub1 = new Sub();
  private Sub sub2 = new Sub();

  public Sub getSub1() {
    return sub1;
  }

  public void setSub1(Sub sub1) {
    this.sub1 = sub1;
  }

  public Sub getSub2() {
    return sub2;
  }

  public void setSub2(Sub sub2) {
    this.sub2 = sub2;
  }

  public static class Sub {
    private String property;

    public String getProperty() {
      return property;
    }

    public void setProperty(String property) {
      this.property = property;
    }

    @Override
    public String toString() {
      return "Sub{" + "property='" + property + '\'' + '}';
    }
  }

  @Override
  public String toString() {
    return "TestProperty{" + "sub1=" + sub1 + ", sub2=" + sub2 + '}';
  }
}
