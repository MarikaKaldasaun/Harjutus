package ee.bcs.valiit.tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.security.auth.login.AccountException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("employee")
@RestController

public class EmployeeController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping ("name")
    public void test (@RequestBody Test test ){
        String sql = "INSERT INTO test (name, account) VALUES (:nameParameter, :accountParameter)";
        Map<String, Object>paramMap = new HashMap<>();
        paramMap.put("nameParameter", test.getName());
        paramMap.put("accountParameter", test.getAccount());
        jdbcTemplate.update(sql, paramMap);

    }

    List<Test> testList = new ArrayList<>();




    @GetMapping( "test")
//http://localhost:8080/employee/test/?name
            public Test Test(@RequestParam("name") String name) {
                Test test= new Test();
                test.setName ( "Kalle");
                test.setAge (34);
                test.setId("536");
                return test;

    }
    @PostMapping ("test")
    public void test2 (@RequestBody Test test){
        System.out.println(test.getName());
    }
    @PostMapping("lisa")
    public void addTest (@RequestBody Test newTest){
        testList.add (newTest);
    }
    @GetMapping("nimi")
    public List<Test> showTest(){
        return testList;
    }
    @GetMapping("isik/{id}")
    public Test id (@PathVariable ("id")  int idVariable){
        return testList.get(idVariable);
    }
    @PutMapping ("asenda/{id}")
    public void replaceTest (@RequestBody Test newTest, @PathVariable ("id") int idVariable){
        testList.set ( idVariable, newTest);
    }
    @DeleteMapping ("kustuta/{id}")
    public void deleteTest (@PathVariable ("id") int idVariable) {
        testList.remove( idVariable);
    }




}
