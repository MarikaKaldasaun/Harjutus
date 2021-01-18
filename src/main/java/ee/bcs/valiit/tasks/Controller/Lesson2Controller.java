package ee.bcs.valiit.tasks.Controller;

import ee.bcs.valiit.tasks.solution.SolutionLesson1MathUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.bcs.valiit.tasks.solution.SolutionLesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("vastus")
@RestController
public class Lesson2Controller {

    @GetMapping("exercise1")
    public int testArray(@RequestParam("array") int[] array) {
        return array.length;
    }

    //http://localhost:8080/vastus/fib/2
    @GetMapping("fib/{n}")
    public static int fib(@PathVariable("n") int nVariable) {
        return SolutionLesson2.exercise4(nVariable);
    }

    //http://localhost:8080/vastus/jada/8
    @GetMapping("jada/{n}")
    public static int jada(@PathVariable("n") int nVariable) {
        return SolutionLesson2.seqLength(nVariable);
    }
//http://localhost:8080/vastus/cycle/5/10
    @GetMapping("cycle/{x}/{y}")
    public static String cycle(@PathVariable("x") int xVariable, @PathVariable("y")
            int yVariable) {

        return SolutionLesson2.exercise5( 5, 10);
    }
}

