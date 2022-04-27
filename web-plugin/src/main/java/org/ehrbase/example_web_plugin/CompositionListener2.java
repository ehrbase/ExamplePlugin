package org.ehrbase.example_web_plugin;

import java.util.UUID;
import org.ehrbase.plugin.dto.CompositionWithEhrId;
import org.ehrbase.plugin.extensionpoints.AbstractCompositionExtensionPoint;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * @author Stefan Spiska
 */
@Extension
@Order(2)
public class CompositionListener2 extends AbstractCompositionExtensionPoint {
    private static final Logger log = LoggerFactory.getLogger(CompositionListener2.class);

    @Override
    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        log.info("Before Creation CompositionListener2");
        return input;
    }

    @Override
    public UUID afterCreation(UUID output) {
        log.info("After Creation CompositionListener2");
        return super.afterCreation(output);
    }
}
