package org.ehrbase.example_web_plugin;

import java.util.UUID;
import java.util.function.Function;
import org.ehrbase.plugin.dto.CompositionWithEhrId;
import org.ehrbase.plugin.extensionpoints.CompositionExtensionPoint;
import org.ehrbase.plugin.extensionpoints.ExtensionPointHelper;
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
public class CompositionListener1 implements CompositionExtensionPoint {
    private static final Logger log = LoggerFactory.getLogger(CompositionListener1.class);

    private ExampleService exampleService;

    @Autowired
    public CompositionListener1(ExampleService exampleService) {

        this.exampleService = exampleService;
    }

    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        log.info("Before Creation CompositionListener1");
        exampleService.add(
            input.getComposition());
        return input;
    }

    public UUID afterCreation(UUID output) {
        log.info("After Creation CompositionListener1");
        return output;
    }

    @Override
    public UUID aroundCreation(CompositionWithEhrId input, Function<CompositionWithEhrId, UUID> chain) {
        return ExtensionPointHelper.beforeAndAfter(input, chain, this::beforeCreation, this::afterCreation);
    }
}
