package org.ehrbase.example_plugin;

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
public class CompositionListener3 extends AbstractCompositionExtensionPoint {

    private ExampleComponent ExampleComponent;

    @Autowired
    public CompositionListener3(ExampleComponent ExampleComponent) {

        this.ExampleComponent = ExampleComponent;
    }

    @Override
    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        System.out.println("Before Creation CompositionListener3");
        ExampleComponent.add(
                input.getComposition());
        return input;
    }

    @Override
    public UUID afterCreation(UUID output) {
        System.out.println("After Creation CompositionListener3");
        return super.afterCreation(output);
    }
}
