package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.Controller.Bank;
import ee.bcs.valiit.tasks.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("bank")
@RestController
public class BankController {
    @Autowired
    private BankService bankService;

    HashMap<String, BigDecimal> accountMap = new HashMap<>();

   // http://localhost:8080/bank/createAccount
    @PostMapping ("createAccount")
    public void createAccount(@RequestBody Bank account){
   // accountMap.put(accountNr, BigDecimal.ZERO);
     bankService.createAccount(account);
    }
        //List<Bank> accountList = new ArrayList<>();


       // @GetMapping( "account")

       // public Bank Bank(@RequestParam("account_Nr") String account_Nr) {
       // Bank account= new Bank();
       // account.setAccount_Nr();
       // account.setCustomer_ID();
      //  account.setBalance();
       // return account;

    //}


    // http://localhost:8080/bank/accountBalance?accountNr=EE123
    @GetMapping ("accountBalance")
    public BigDecimal accountBalance(@RequestParam ("account_nr") String account_nr) {
        return bankService.accountBalance(account_nr);
    }


       // return accountMap.get(accountNr);


    // http://localhost:8080/bank/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam ("account_nr") String account_nr,
                             @RequestParam ("amount") BigDecimal amount ){
        bankService.depositMoney(account_nr, amount);

    }

    // http://localhost:8080/bank/withdrawMoney?accountNr=EE123&amount=12
    @PutMapping ("withdrawMoney")
    public void withdrawMoney(@RequestParam ("account_nr") String account_nr,
                              @RequestParam ("amount") BigDecimal amount) {
        bankService.withdrawMoney(account_nr, amount);
    }

    // http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam ("toAccount")
                              String toAccount,
                              @RequestParam ("amount") BigDecimal amount){
        /*
        String sql = "SELECT balance FROM account where account_nr = :accountNumber";
        Map<String, Object>paramMap = new HashMap<>();
        paramMap.put("accountNumber", fromAccount);
       // BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

       // BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
      //  if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Not enough money");
        }
        //accountMap.put(fromAccount, newFromAccountBalance);


        //BigDecimal toAccountBalance = accountMap.get(toAccount);
        String sql2 = "UPDATE account SET balance WHERE account_nr = :accountNumber";
        Map<String, Object>paramMap2 = new HashMap<>();
     //   paramMap2.put("accountNumber", fromAccount);
        paramMap2.put("balance", newFromAccountBalance);
       //jdbcTemplate.update(sql2, paramMap2);

        String sql3 = "SELECT balance FROM account WHERE account_nr = :accountNumber";
        Map<String, Object>paramMap3 = new HashMap<>();
        paramMap3.put("accountNumber", toAccount);
      //  BigDecimal toAccountBalance = jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);

        BigDecimal newToAccountBalance = toAccountBalance.add(amount);

        String sql4 = "UPDATE account SET balance WHERE account_nr = :accountNumber";
        Map<String, Object>paramMap4 = new HashMap<>();
        paramMap4.put("accountNumber", toAccount);
        paramMap4.put("balance", newToAccountBalance);
        jdbcTemplate.update(sql4, paramMap4);*/


    }
}
