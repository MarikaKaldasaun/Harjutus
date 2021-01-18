package ee.bcs.valiit.tasks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Generated;

@RestController
public class TestController {
    @GetMapping ("test/{name}")
    public String getHelloWorld(@PathVariable("name") String userName){
        return "Hello World" + userName;
    }

}
