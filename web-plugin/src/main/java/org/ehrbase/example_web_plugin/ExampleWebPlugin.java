package org.ehrbase.example_web_plugin;

import org.ehrbase.plugin.EhrBasePlugin;

import org.ehrbase.plugin.dto.CompositionWithEhrId;
import org.ehrbase.plugin.extensionpoints.AbstractCompositionExtensionPoint;
import org.pf4j.Extension;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.UUID;

/**
 * @author Stefan Spiska
 */
public class ExampleWebPlugin extends EhrBasePlugin {

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

      // The ApplicationContext will be automatically refresh when the DispatcherServlet will be initialized.
      dispatcherServlet = new DispatcherServlet(applicationContext);

    }

    return  dispatcherServlet;
  }

  @Override
  public String getContextPath() {
    return "/example-web-plugin";
  }

}
