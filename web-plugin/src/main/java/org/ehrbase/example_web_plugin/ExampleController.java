package org.ehrbase.example_web_plugin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author Stefan Spiska
 */
@RestController
@RequestMapping("/plugin-mvc-controller")
public class ExampleController {

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;

    }

    private  final ExampleService exampleService;


    @GetMapping
    public ResponseEntity<Map> greetMVC(){

        return ResponseEntity.ok().body(exampleService.getCreatedMap());
    }

    @PostConstruct
    public void init(){
        System.out.println(this.getClass().getName());
    }
}
