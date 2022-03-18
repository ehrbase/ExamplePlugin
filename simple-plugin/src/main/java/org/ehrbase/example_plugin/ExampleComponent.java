package org.ehrbase.example_plugin;

import com.nedap.archie.rm.composition.Composition;
import org.ehrbase.service.KnowledgeCacheService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

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

    try {
    System.out.println(knowledgeCacheService.getQueryOptMetaData(composition.getArchetypeDetails().getTemplateId().getValue()).getLanguages());
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    }

    @PostConstruct
    public void init(){
    System.out.println(this.getClass().getName());

    Assert.notNull(knowledgeCacheService, "Injection of knowledgeCacheService failed");
    }
}
