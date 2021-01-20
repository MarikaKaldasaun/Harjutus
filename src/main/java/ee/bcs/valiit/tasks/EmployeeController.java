package ee.bcs.valiit.tasks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@RequestMapping("employee")
@RestController

public class EmployeeController {
    @GetMapping( "test")
//http://localhost:8080/employee/test/?name
            public Test Test(@RequestParam("name") String name) {
                Test test= new Test();
                test.setName ( "Kalle");
                test.setAddress ("Karja");
                test.setAge (34);
                return test;

    }
}
