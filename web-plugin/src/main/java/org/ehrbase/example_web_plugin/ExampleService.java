package org.ehrbase.example_web_plugin;

import com.nedap.archie.rm.composition.Composition;
import com.nedap.archie.rm.generic.PartyIdentified;
import org.ehrbase.service.KnowledgeCacheService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stefan Spiska
 */
@Service
public class ExampleService {

    private final Map<String,String> createdMap = new HashMap<>();

    private final KnowledgeCacheService knowledgeCacheService;

  private final TestProperty testProperty;

  public ExampleService(KnowledgeCacheService knowledgeCacheService, TestProperty testProperty) {

        this.knowledgeCacheService = knowledgeCacheService;
    this.testProperty = testProperty;
    }

    public Map<String, String> getCreatedMap() {
        return createdMap;
    }

    public void add(Composition composition){

    try {
        createdMap.put(((PartyIdentified)composition.getComposer()).getName(),knowledgeCacheService.getQueryOptMetaData(composition.getArchetypeDetails().getTemplateId().getValue()).getTree().getName());
    System.out.println(createdMap);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    }

    @PostConstruct
    public void init(){
    System.out.println(this.getClass().getName());
    System.out.println("env:");
    System.out.println(testProperty);
    Assert.notNull(knowledgeCacheService, "Injection of knowledgeCacheService failed");
    }
}
