package ee.bcs.valiit.tasks.Controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping
public class MathUtilController {
    @GetMapping ("test/{name}")
    public String getHelloWorld(@PathVariable("name") String userName){
        return "Hello World" + userName;
}
