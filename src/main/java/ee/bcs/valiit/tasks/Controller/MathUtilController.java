package ee.bcs.valiit.tasks.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ee.bcs.valiit.tasks.solution.SolutionLesson1MathUtil;
import org.springframework.web.bind.annotation.*;

@RequestMapping ("vastus")
@RestController
public class MathUtilController {
    //http://localhost:8080/vastus/min/7/3
    @GetMapping("min")
    public int min(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable) {
        return SolutionLesson1MathUtil.min(aVariable, bVariable);
    }
    //http://localhost:8080/vastus/max/7/3
    @GetMapping("max/{a}/{b}")
    public int max(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable) {
        return SolutionLesson1MathUtil.max(aVariable, bVariable);
    }
    //http://localhost:8080/vastus/abs/5
    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int aVariable) {
        return SolutionLesson1MathUtil.abs(aVariable);
    }
    //http://localhost:8080/vastus/isEven/5
    @GetMapping("isEven/{a}")
    public static boolean isEven(@PathVariable("a") int aVariable) {
        return SolutionLesson1MathUtil.isEven(aVariable);
    }
    //http://localhost:8080/vastus/min/5/3/7
    @GetMapping("min/{a}/{b}/{c}")
    public static int min(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable, @PathVariable("c") int cVariable) {
        return SolutionLesson1MathUtil.min(aVariable, bVariable, cVariable);
    }
    //http://localhost:8080/vastus/max/5/3/8
    @GetMapping("max/{a}/{b}/{c}")
    public static int max(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable, @PathVariable("c") int cVariable) {
        return SolutionLesson1MathUtil.max(aVariable, bVariable, cVariable);
    }
}
