package ee.bcs.valiit.tasks;

import ee.bcs.valiit.Service.BankService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank2")
@RestController
@Transactional
public class BankController2 {
    @Autowired
    private BankService2 bankService2;


    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/bank2/createAccount?accountNr=EE123
    //http://localhost:8080/bank2/createAccount?accountNr=EE124
   // http://localhost:8080/bank2/createAccount?accountNr=EE125
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr){
        bankService2.createAccount(accountNr);
    }

     // http://localhost:8080/bank2/customer?customerId=1&name=HeleVari&accountNr=EE423
    @GetMapping("customer")
    public void createCustomer (@RequestParam ("customerId") BigDecimal customerId, @RequestParam ("name") String name,
                                @RequestParam ("accountNr") String accountNr){
        bankService2.createCustomer(customerId, name, accountNr);
    }

    // http://localhost:8080/bank2/accountBalance?accountNum=EE123
    //http://localhost:8080/bank2/accountBalance?accountNr=EE125
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNum") String accountNr){
        return bankService2.accountBalance(accountNr);

        // return accountMap.get(accountNr);
    }

    // http://localhost:8080/bank2/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNo") String accountNr, @RequestParam("summa") BigDecimal amount){
        bankService2.depositMoney(accountNr, amount);
    }

    // http://localhost:8080/bank2/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount){
        //BigDecimal balance = accountMap.get(accountNr);
       bankService2.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8080/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&sum=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount2,
                              @RequestParam("toAccount") String toAccount2,
                              @RequestParam("sum") BigDecimal amount) {
        // BigDecimal fromAccountBalance = accountMap.get(fromAccount);
        bankService2.transferMoney(fromAccount2, toAccount2, amount);
    }
  //  @GetMapping("transactionHistory")
  //  public void transactionHistory (@RequestParam("accountNo") String accountNr, @RequestParam("summa") BigDecimal amount){
    //    bankService2.transactionHistory(accountNr, amount);
    //}

}
