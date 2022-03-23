package org.ehrbase.example_web_plugin;

import org.ehrbase.plugin.WebMvcEhrBasePlugin;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Stefan Spiska
 */
public class ExampleWebPlugin extends WebMvcEhrBasePlugin {

  public ExampleWebPlugin(PluginWrapper wrapper) {
    super(wrapper);
  }

  DispatcherServlet dispatcherServlet;

  @Override
  public DispatcherServlet getDispatcherServlet() {

    if (dispatcherServlet == null) {

      ApplicationContext parentContext =
          ((SpringPluginManager) getWrapper().getPluginManager()).getApplicationContext();

      AnnotationConfigWebApplicationContext applicationContext =
          new AnnotationConfigWebApplicationContext();
      applicationContext.setParent(parentContext);
      applicationContext.setClassLoader(getWrapper().getPluginClassLoader());

      applicationContext.register(SpringConfiguration.class);

      applicationContext
          .getEnvironment()
          .getPropertySources()
          .addLast(new PropertySource<Object>() {});
      // The ApplicationContext will be automatically refresh when the DispatcherServlet will be
      // initialized.
      dispatcherServlet = new DispatcherServlet(applicationContext);
    }

    return dispatcherServlet;
  }

  @Override
  public String getContextPath() {
    return "/example-web-plugin";
  }
}
