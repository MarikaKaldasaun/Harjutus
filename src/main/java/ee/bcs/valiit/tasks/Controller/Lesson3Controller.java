package ee.bcs.valiit.tasks.Controller;

import ee.bcs.valiit.tasks.Lesson3;
import ee.bcs.valiit.tasks.solution.SolutionLesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RequestMapping("vastus")
@RestController

public class Lesson3Controller {
   // http://localhost:8080/vastus/sum1/?x=1,2,3
    @GetMapping("sum1")
    public static int sum(@RequestParam("x") int[] xVariable) {
            return Lesson3.sum( xVariable);
            }
    //http://localhost:8080/vastus/fact/5
    @GetMapping("fact/{x}")
    public static int factorial(@PathVariable("x") int xVariable) {
        return Lesson3.factorial(5);
    }
    //http://localhost:8080/vastus/sordi/?a=5,2,3
    @GetMapping("sordi")
    public static int [] sort(@RequestParam("a") int[] aVariable) {
        return Lesson3.sort( aVariable);

    }
    //http://localhost:8080/vastus/nimi/?a=p,a,i
    @GetMapping("nimi")
    public static String reverseString111(@RequestParam ("a") String aVariable) {
        return Lesson3.reverseString111(aVariable);
    }
    //http://localhost:8080/vastus/x/?x=15
    @GetMapping("x")
    public static boolean isPrime(@RequestParam("x") int xVariable) {
        boolean prime = Lesson3.isPrime(xVariable);
        return prime;
    }
}
