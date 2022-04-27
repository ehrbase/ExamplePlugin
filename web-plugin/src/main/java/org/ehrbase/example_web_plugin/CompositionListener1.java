package org.ehrbase.example_web_plugin;

import java.util.UUID;
import org.ehrbase.plugin.dto.CompositionWithEhrId;
import org.ehrbase.plugin.extensionpoints.AbstractCompositionExtensionPoint;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

/**
 * @author Stefan Spiska
 */
@Extension
@Order(1)
public class CompositionListener1 extends AbstractCompositionExtensionPoint {
    private static final Logger log = LoggerFactory.getLogger(CompositionListener1.class);

    private ExampleService exampleService;

    @Autowired
    public CompositionListener1(ExampleService exampleService) {

        this.exampleService = exampleService;
    }

    @Override
    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        log.info("Before Creation CompositionListener1");
        exampleService.add(
            input.getComposition());
        return input;
    }

    @Override
    public UUID afterCreation(UUID output) {
        log.info("After Creation CompositionListener1");
        return super.afterCreation(output);
    }
}
