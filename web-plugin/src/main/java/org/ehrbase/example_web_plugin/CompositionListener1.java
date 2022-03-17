package org.ehrbase.example_web_plugin;

import org.ehrbase.plugin.dto.CompositionWithEhrId;
import org.ehrbase.plugin.extensionpoints.AbstractCompositionExtensionPoint;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.util.UUID;

/**
 * @author Stefan Spiska
 */
@Extension
@Order(1)
public class CompositionListener1 extends AbstractCompositionExtensionPoint {

    private ExampleService exampleService;

    @Autowired
    public CompositionListener1(ExampleService exampleService) {

        this.exampleService = exampleService;
    }

    @Override
    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        System.out.println("Before Creation CompositionListener1");
        exampleService.add(
                input.getComposition());
        return input;
    }

    @Override
    public UUID afterCreation(UUID output) {
        System.out.println("After Creation CompositionListener1");
        return super.afterCreation(output);
    }
}
