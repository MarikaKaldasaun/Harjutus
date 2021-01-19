package ee.bcs.valiit.tasks.Controller;
import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RequestMapping("vastus")
@RestController

public class Lesson3HardController {

    //http://localhost:8080/vastus/fibo/?x=34
    @GetMapping("fibo")
    public static int evenFibonacci(@RequestParam("x") int xVariable) {
        return Lesson3Hard.evenFibonacci(xVariable);
    }
}
