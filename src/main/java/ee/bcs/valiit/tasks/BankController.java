package ee.bcs.valiit.tasks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("bank")
@RestController
public class BankController {
    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/bank/createAccount?accountNr=EE123
    @GetMapping("createAccount")
    public void createAccount(@RequestParam ("accountNr") String accountNr){
    accountMap.put(accountNr, BigDecimal.ZERO);
    }

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
