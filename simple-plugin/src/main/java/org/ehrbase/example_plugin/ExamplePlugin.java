package org.ehrbase.example_plugin;

import org.ehrbase.plugin.EhrBasePluginManagerInterface;
import org.ehrbase.plugin.NonWebMvcEhrBasePlugin;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author Stefan Spiska
 */
public class ExamplePlugin extends NonWebMvcEhrBasePlugin {

  public ExamplePlugin(PluginWrapper wrapper) {
    super(wrapper);
  }

  @Override
  protected ApplicationContext buildApplicationContext() {

    EhrBasePluginManagerInterface pluginManager =
        (EhrBasePluginManagerInterface) getWrapper().getPluginManager();
    ApplicationContext parentContext = pluginManager.getApplicationContext();

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

    applicationContext.setParent(parentContext);
    applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
    applicationContext.register(SpringConfiguration.class);

    return applicationContext;
  }

  @Override
  public List<String> getConfigFileNames() {
    return List.of("test.properties");
  }
}
