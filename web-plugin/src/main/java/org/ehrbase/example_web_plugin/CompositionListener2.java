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
@Order(2)
public class CompositionListener2 extends AbstractCompositionExtensionPoint {




    @Override
    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        System.out.println("Before Creation CompositionListener2");

        return input;
    }

    @Override
    public UUID afterCreation(UUID output) {
        System.out.println("After Creation CompositionListener2");
        return super.afterCreation(output);
    }
}
