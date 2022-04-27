package org.ehrbase.example_plugin;

import java.util.function.Function;
import org.ehrbase.plugin.extensionpoints.AbstractTemplateExtensionPoint;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension
public class TemplateListener1 extends AbstractTemplateExtensionPoint {
  private static final Logger log = LoggerFactory.getLogger(TemplateListener1.class);

  @Override
  public OPERATIONALTEMPLATE beforeCreation(OPERATIONALTEMPLATE input) {
    log.info("Before Template Creation TemplateListener1");
    return super.beforeCreation(input);
  }

  @Override
  public String afterCreation(String output) {
    log.info("After Template Creation TemplateListener1");
    return super.afterCreation(output);
  }

  @Override
  public String aroundCreation(OPERATIONALTEMPLATE input, Function<OPERATIONALTEMPLATE, String> chain) {
    log.info("Around Template Creation start TemplateListener1");
    String s = super.aroundCreation(input, chain);
    log.info("Around Template Creation end TemplateListener1");
    return s;
  }
}
