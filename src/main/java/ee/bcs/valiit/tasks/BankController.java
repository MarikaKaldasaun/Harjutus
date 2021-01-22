package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.Controller.Bank;
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
    private NamedParameterJdbcTemplate jdbcTemplate;

    HashMap<String, BigDecimal> accountMap = new HashMap<>();


    @PostMapping ("createAccount")
    public void createAccount(@RequestBody Bank account){
   // accountMap.put(accountNr, BigDecimal.ZERO);
        String sql = "INSERT INTO account (account_nr, customer_id, balance) VALUES (:account_nrParameter," +
                " :customer_idParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", account.getAccount_nr());
        paramMap.put("customer_idParameter", account.getCustomer_id());
        paramMap.put("balanceParameter", account.getBalance());
        jdbcTemplate.update(sql, paramMap);
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
    public BigDecimal accountBalance(@RequestParam ("accountNr") String accountNr)
    {
        return accountMap.get(accountNr);
    }

    // http://localhost:8080/bank/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam ("accountNr") String accountNr, @RequestParam ("amount") BigDecimal amount ){
    BigDecimal balance = accountMap.get(accountNr);
    BigDecimal newBalance = balance.add(amount);
    accountMap.put(accountNr, newBalance);
    }

    // http://localhost:8080/bank/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam ("accountNr") String accountNr, @RequestParam ("amount") BigDecimal amount){
        BigDecimal balance = accountMap.get(accountNr);
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        accountMap.put(accountNr, newBalance);
    }

    // http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount, @RequestParam ("toAccount")
                              String toAccount, @RequestParam ("amount") BigDecimal amount){
        BigDecimal fromAccountBalance = accountMap.get(fromAccount);
        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Not enough money");
        }
        accountMap.put(fromAccount, newFromAccountBalance);
        BigDecimal toAccountBalance = accountMap.get(toAccount);
        BigDecimal newToAccountBalance = toAccountBalance.add(amount);
        accountMap.put(toAccount, newToAccountBalance);


    }
}
