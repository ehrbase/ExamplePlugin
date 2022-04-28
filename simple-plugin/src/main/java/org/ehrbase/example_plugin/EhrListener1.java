package org.ehrbase.example_plugin;

import com.nedap.archie.rm.changecontrol.OriginalVersion;
import com.nedap.archie.rm.ehr.EhrStatus;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.ehrbase.plugin.dto.EhrStatusVersionRequestParameters;
import org.ehrbase.plugin.dto.EhrStatusWithEhrId;
import org.ehrbase.plugin.extensionpoints.AbstractEhrExtensionPoint;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Stefan Spiska
 */
@Extension
public class EhrListener1 extends AbstractEhrExtensionPoint {
    private static final Logger log = LoggerFactory.getLogger(EhrListener1.class);

    @Override
    public EhrStatusWithEhrId beforeCreation(EhrStatusWithEhrId input) {
        log.info("Before Creation EhrListener1");
        return input;
    }

    @Override
    public UUID afterCreation(UUID output) {
        log.info("After Creation EhrListener1");
        return super.afterCreation(output);
    }

    @Override
    public UUID aroundCreation(EhrStatusWithEhrId input, Function<EhrStatusWithEhrId, UUID> chain) {
        log.info("Around Creation start EhrListener1");
        UUID uuid = super.aroundCreation(input, chain);
        log.info("Around Creation end EhrListener1");
        return uuid;
    }

    @Override
    public EhrStatusWithEhrId beforeUpdate(EhrStatusWithEhrId input) {
        log.info("Before Update EhrListener1");
        return super.beforeUpdate(input);
    }

    @Override
    public UUID afterUpdate(UUID output) {
        log.info("After Update EhrListener1");
        return super.afterUpdate(output);
    }

    @Override
    public UUID aroundUpdate(EhrStatusWithEhrId input,
                             Function<EhrStatusWithEhrId, UUID> chain) {
        log.info("Around Update start EhrListener1");
        UUID uuid = super.aroundUpdate(input, chain);
        log.info("Around Update end EhrListener1");
        return uuid;
    }


    @Override
    public EhrStatusVersionRequestParameters beforeRetrieveAtVersion(EhrStatusVersionRequestParameters input) {
        log.info("Before Retrieve EhrListener1");
        return super.beforeRetrieveAtVersion(input);
    }

    @Override
    public Optional<OriginalVersion<EhrStatus>> afterRetrieveAtVersion(Optional<OriginalVersion<EhrStatus>> output) {
        log.info("After Retrieve EhrListener1");
        return super.afterRetrieveAtVersion(output);
    }

    @Override
    public Optional<OriginalVersion<EhrStatus>> aroundRetrieveAtVersion(EhrStatusVersionRequestParameters input,
                                                                        Function<EhrStatusVersionRequestParameters,
                                                                            Optional<OriginalVersion<EhrStatus>>> chain) {
        log.info("Around Retrieve start EhrListener1");
        Optional<OriginalVersion<EhrStatus>> ehrStatusVersion = super.aroundRetrieveAtVersion(input, chain);
        log.info("Around Retrieve end EhrListener1");
        return ehrStatusVersion;
    }
}
