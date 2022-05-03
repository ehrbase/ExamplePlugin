package org.ehrbase.example_web_plugin;

import java.util.UUID;
import java.util.function.Function;
import org.ehrbase.plugin.dto.CompositionWithEhrId;
import org.ehrbase.plugin.extensionpoints.CompositionExtensionPoint;
import org.ehrbase.plugin.extensionpoints.ExtensionPointHelper;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * @author Stefan Spiska
 */
@Extension
@Order(2)
public class CompositionListener2 implements CompositionExtensionPoint {
    private static final Logger log = LoggerFactory.getLogger(CompositionListener2.class);

    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        log.info("Before Creation CompositionListener2");
        return input;
    }

    public UUID afterCreation(UUID output) {
        log.info("After Creation CompositionListener2");
        return output;
    }

    @Override
    public UUID aroundCreation(CompositionWithEhrId input, Function<CompositionWithEhrId, UUID> chain) {
        return ExtensionPointHelper.beforeAndAfter(input, chain, this::beforeCreation, this::afterCreation);
    }
}
