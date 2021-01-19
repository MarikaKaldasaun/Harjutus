package ee.bcs.valiit.tasks.Controller;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RequestMapping("vastus")
@RestController

public class Lesson3Controller {

    @GetMapping("sum1/{x}")
    public static int sum(@PathVariable("x") int xVariable) {
            return Lesson3.sum( 4);
            }


}
