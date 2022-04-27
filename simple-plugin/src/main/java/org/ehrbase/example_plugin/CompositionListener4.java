package org.ehrbase.example_plugin;

import com.nedap.archie.rm.composition.Composition;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.ehrbase.plugin.dto.CompositionIdWithVersionAndEhrId;
import org.ehrbase.plugin.dto.CompositionVersionIdWithEhrId;
import org.ehrbase.plugin.dto.CompositionWithEhrId;
import org.ehrbase.plugin.dto.CompositionWithEhrIdAndPreviousVersion;
import org.ehrbase.plugin.extensionpoints.AbstractCompositionExtensionPoint;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.PriorityOrdered;

/**
 * @author Stefan Spiska
 */

@Extension
public class CompositionListener4 extends AbstractCompositionExtensionPoint implements PriorityOrdered {
    private static final Logger log = LoggerFactory.getLogger(CompositionListener4.class);

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        log.info("Before Creation CompositionListener4");
        return input;
    }

    @Override
    public UUID afterCreation(UUID output) {
        log.info("After Creation CompositionListener4");
        return super.afterCreation(output);
    }

    @Override
    public UUID aroundCreation(CompositionWithEhrId input, Function<CompositionWithEhrId, UUID> chain) {
        log.info("Around Creation start CompositionListener4");
        UUID uuid = super.aroundCreation(input, chain);
        log.info("Around Creation end CompositionListener4");
        return uuid;
    }

    @Override
    public CompositionWithEhrIdAndPreviousVersion beforeUpdate(CompositionWithEhrIdAndPreviousVersion input) {
        log.info("Before Update CompositionListener4");
        return super.beforeUpdate(input);
    }

    @Override
    public UUID afterUpdate(UUID output) {
        log.info("After Update CompositionListener4");
        return super.afterUpdate(output);
    }

    @Override
    public UUID aroundUpdate(CompositionWithEhrIdAndPreviousVersion input,
                             Function<CompositionWithEhrIdAndPreviousVersion, UUID> chain) {
        log.info("Around Update start CompositionListener4");
        UUID uuid = super.aroundUpdate(input, chain);
        log.info("Around Update end CompositionListener4");
        return uuid;
    }

    @Override
    public CompositionVersionIdWithEhrId beforeDelete(CompositionVersionIdWithEhrId input) {
        log.info("Before Delete CompositionListener4");
        return super.beforeDelete(input);
    }

    @Override
    public Void afterDelete(Void v) {
        log.info("After Delete CompositionListener4");
        return super.afterDelete(v);
    }

    @Override
    public Void aroundDelete(CompositionVersionIdWithEhrId input, Function<CompositionVersionIdWithEhrId, Void> chain) {
        log.info("Around Delete start CompositionListener4");
        Void unused = super.aroundDelete(input, chain);
        log.info("Around Delete end CompositionListener4");
        return unused;
    }

    @Override
    public CompositionIdWithVersionAndEhrId beforeRetrieve(CompositionIdWithVersionAndEhrId input) {
        log.info("Before Retrieve CompositionListener4");
        return super.beforeRetrieve(input);
    }

    @Override
    public Optional<Composition> afterRetrieve(Optional<Composition> output) {
        log.info("After Retrieve CompositionListener4");
        return super.afterRetrieve(output);
    }

    @Override
    public Optional<Composition> aroundRetrieve(CompositionIdWithVersionAndEhrId input,
                                                Function<CompositionIdWithVersionAndEhrId, Optional<Composition>> chain) {
        log.info("Around Retrieve start CompositionListener4");
        Optional<Composition> composition = super.aroundRetrieve(input, chain);
        log.info("Around Retrieve end CompositionListener4");
        return composition;
    }
}
