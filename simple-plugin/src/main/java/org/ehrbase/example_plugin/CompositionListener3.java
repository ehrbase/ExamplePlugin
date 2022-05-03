package org.ehrbase.example_plugin;

import com.nedap.archie.rm.composition.Composition;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.ehrbase.plugin.dto.CompositionIdWithVersionAndEhrId;
import org.ehrbase.plugin.dto.CompositionVersionIdWithEhrId;
import org.ehrbase.plugin.dto.CompositionWithEhrId;
import org.ehrbase.plugin.dto.CompositionWithEhrIdAndPreviousVersion;
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
@Order(0)
@Extension
public class CompositionListener3 implements CompositionExtensionPoint {
    private static final Logger log = LoggerFactory.getLogger(CompositionListener3.class);

    private ExampleComponent ExampleComponent;

    @Autowired
    public CompositionListener3(ExampleComponent ExampleComponent) {

        this.ExampleComponent = ExampleComponent;
    }

    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        log.info("Before Creation CompositionListener3");
        ExampleComponent.add(
            input.getComposition());
        return input;
    }

    public UUID afterCreation(UUID output) {
        log.info("After Creation CompositionListener3");
        return output;
    }

    @Override
    public UUID aroundCreation(CompositionWithEhrId input, Function<CompositionWithEhrId, UUID> chain) {
        log.info("Around Creation start CompositionListener3");
        UUID uuid = ExtensionPointHelper.beforeAndAfter(input, chain, this::beforeCreation, this::afterCreation);
        log.info("Around Creation end CompositionListener3");
        return uuid;
    }

    public CompositionWithEhrIdAndPreviousVersion beforeUpdate(CompositionWithEhrIdAndPreviousVersion input) {
        log.info("Before Update CompositionListener3");
        return input;
    }

    public UUID afterUpdate(UUID output) {
        log.info("After Update CompositionListener3");
        return output;
    }

    @Override
    public UUID aroundUpdate(CompositionWithEhrIdAndPreviousVersion input,
                             Function<CompositionWithEhrIdAndPreviousVersion, UUID> chain) {
        log.info("Around Update start CompositionListener3");
        UUID uuid = ExtensionPointHelper.beforeAndAfter(input, chain, this::beforeUpdate, this::afterUpdate);
        log.info("Around Update end CompositionListener3");
        return uuid;
    }

    public CompositionVersionIdWithEhrId beforeDelete(CompositionVersionIdWithEhrId input) {
        log.info("Before Delete CompositionListener3");
        return input;
    }

    public Void afterDelete(Void v) {
        log.info("After Delete CompositionListener3");
        return v;
    }

    @Override
    public Void aroundDelete(CompositionVersionIdWithEhrId input, Function<CompositionVersionIdWithEhrId, Void> chain) {
        log.info("Around Delete start CompositionListener3");
        Void unused = ExtensionPointHelper.beforeAndAfter(input, chain, this::beforeDelete, this::afterDelete);
        log.info("Around Delete end CompositionListener3");
        return unused;
    }

    public CompositionIdWithVersionAndEhrId beforeRetrieve(CompositionIdWithVersionAndEhrId input) {
        log.info("Before Retrieve CompositionListener3");
        return input;
    }

    public Optional<Composition> afterRetrieve(Optional<Composition> output) {
        log.info("After Retrieve CompositionListener3");
        return output;
    }

    @Override
    public Optional<Composition> aroundRetrieve(CompositionIdWithVersionAndEhrId input,
                                                Function<CompositionIdWithVersionAndEhrId, Optional<Composition>> chain) {
        log.info("Around Retrieve start CompositionListener3");
        Optional<Composition> composition =
            ExtensionPointHelper.beforeAndAfter(input, chain, this::beforeRetrieve, this::afterRetrieve);
        log.info("Around Retrieve end CompositionListener3");
        return composition;
    }
}
