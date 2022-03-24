package org.ehrbase.example_web_plugin;

import org.ehrbase.plugin.WebMvcEhrBasePlugin;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Stefan Spiska
 */
public class ExampleWebPlugin extends WebMvcEhrBasePlugin {

  public ExampleWebPlugin(PluginWrapper wrapper) {
    super(wrapper);
  }

  @Override
  protected DispatcherServlet buildDispatcherServlet() {

      ApplicationContext parentContext =
          ((SpringPluginManager) getWrapper().getPluginManager()).getApplicationContext();

      AnnotationConfigWebApplicationContext applicationContext =
          new AnnotationConfigWebApplicationContext();
      applicationContext.setParent(parentContext);
      applicationContext.setClassLoader(getWrapper().getPluginClassLoader());

      applicationContext.register(SpringConfiguration.class);

    // The ApplicationContext will be automatically refreshed when the DispatcherServlet will be
    // initialized.
    return new DispatcherServlet(applicationContext);
  }


  @Override
  public String getContextPath() {
    return "/example-web-plugin";
  }

}
