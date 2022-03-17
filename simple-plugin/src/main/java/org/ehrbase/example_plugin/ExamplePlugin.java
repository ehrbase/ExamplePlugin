package org.ehrbase.example_plugin;

import org.ehrbase.plugin.EhrBasePlugin;

import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Stefan Spiska
 */
public class ExamplePlugin extends SpringPlugin {

  public ExamplePlugin(PluginWrapper wrapper) {
    super(wrapper);
  }

  @Override
  protected ApplicationContext createApplicationContext() {

    ApplicationContext parentContext =
            ((SpringPluginManager) getWrapper().getPluginManager()).getApplicationContext();

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

    applicationContext.setParent(parentContext);
    applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
    applicationContext.register(SpringConfiguration.class);

    // Plugins wich do not implement EhrBasePlugin need to be refreshed manually
    applicationContext.refresh();


    return applicationContext;
  }


}
