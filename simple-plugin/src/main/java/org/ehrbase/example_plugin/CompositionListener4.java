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
import org.springframework.core.PriorityOrdered;

/**
 * @author Stefan Spiska
 */

@Extension
public class CompositionListener4 implements CompositionExtensionPoint, PriorityOrdered {
    private static final Logger log = LoggerFactory.getLogger(CompositionListener4.class);

    @Override
    public int getOrder() {
        return 0;
    }

    public CompositionWithEhrId beforeCreation(CompositionWithEhrId input) {
        log.info("Before Creation CompositionListener4");
        return input;
    }

    @Override
    public UUID aroundCreation(CompositionWithEhrId input, Function<CompositionWithEhrId, UUID> chain) {
        log.info("Around Creation start CompositionListener4");
        UUID uuid = ExtensionPointHelper.before(input, chain, this::beforeCreation);
        log.info("Around Creation end CompositionListener4");
        return uuid;
    }

    public UUID afterUpdate(UUID output) {
        log.info("After Update CompositionListener4");
        return output;
    }

    @Override
    public UUID aroundUpdate(CompositionWithEhrIdAndPreviousVersion input,
                             Function<CompositionWithEhrIdAndPreviousVersion, UUID> chain) {
        log.info("Around Update start CompositionListener4");
        UUID uuid = ExtensionPointHelper.after(input, chain, this::afterUpdate);
        log.info("Around Update end CompositionListener4");
        return uuid;
    }

    public CompositionVersionIdWithEhrId beforeDelete(CompositionVersionIdWithEhrId input) {
        log.info("Before Delete CompositionListener4");
        return input;
    }

    public Void afterDelete(Void v) {
        log.info("After Delete CompositionListener4");
        return v;
    }

    @Override
    public Void aroundDelete(CompositionVersionIdWithEhrId input, Function<CompositionVersionIdWithEhrId, Void> chain) {
        log.info("Around Delete start CompositionListener4");
        Void unused = ExtensionPointHelper.beforeAndAfter(input, chain, this::beforeDelete, this::afterDelete);
        log.info("Around Delete end CompositionListener4");
        return unused;
    }

    public CompositionIdWithVersionAndEhrId beforeRetrieve(CompositionIdWithVersionAndEhrId input) {
        log.info("Before Retrieve CompositionListener4");
        return input;
    }

    public Optional<Composition> afterRetrieve(Optional<Composition> output) {
        log.info("After Retrieve CompositionListener4");
        return output;
    }

    @Override
    public Optional<Composition> aroundRetrieve(CompositionIdWithVersionAndEhrId input,
                                                Function<CompositionIdWithVersionAndEhrId, Optional<Composition>> chain) {
        log.info("Around Retrieve start CompositionListener4");
        Optional<Composition> composition =
            ExtensionPointHelper.beforeAndAfter(input, chain, this::beforeRetrieve, this::afterRetrieve);
        log.info("Around Retrieve end CompositionListener4");
        return composition;
    }
}
