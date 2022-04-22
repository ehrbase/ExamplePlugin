package org.ehrbase.example_web_plugin;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Label;
import com.indvd00m.ascii.render.elements.Rectangle;
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

    IRender render = new Render();
    IContextBuilder builder = render.newBuilder();
    builder.width(80).height(10);
    builder.element(new Rectangle());
    builder.element(
        new Label("com.indvd00m.ascii.render:ascii-render included in plugin jar", 1, 4, 80));
    ICanvas canvas = render.render(builder.build());
    String s = canvas.getText();
    System.out.println(s);
    }
}
