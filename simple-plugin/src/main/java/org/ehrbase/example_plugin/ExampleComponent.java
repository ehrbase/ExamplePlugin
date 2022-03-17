package org.ehrbase.example_plugin;

import com.nedap.archie.rm.composition.Composition;
import com.nedap.archie.rm.generic.PartyIdentified;
import org.ehrbase.service.KnowledgeCacheService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stefan Spiska
 */
@Component
public class ExampleComponent {



    private final KnowledgeCacheService knowledgeCacheService;

    public ExampleComponent(KnowledgeCacheService knowledgeCacheService) {

        this.knowledgeCacheService = knowledgeCacheService;
    }



    public void add(Composition composition){

    System.out.println(knowledgeCacheService.getQueryOptMetaData(composition.getArchetypeDetails().getTemplateId().getValue()).getLanguages());
    }

    @PostConstruct
    public void init(){
    System.out.println(this.getClass().getName());
    }
}
