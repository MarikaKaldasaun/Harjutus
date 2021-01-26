package ee.bcs.valiit.Service;

import ee.bcs.valiit.bankrepository2.BankRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BankService2 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private BankRepository2 bankRepository2;

    public void createAccount(String accountNr) {
        bankRepository2.createAccount (accountNr);

    }

    public void createCustomer ( BigDecimal customerId, String name, String accountNr ){
        bankRepository2.createCustomer(customerId, name, accountNr);
    }

        public BigDecimal accountBalance( String accountNr) {
        return bankRepository2.accountBalance(accountNr);

        }

    public void depositMoney(String accountNr, BigDecimal amount) {
         BigDecimal balance = bankRepository2.depositMoney(accountNr, amount);
        BigDecimal newBalance = balance.add(amount);
        bankRepository2.updateBalance (accountNr, newBalance);

    }

    public void withdrawMoney(String accountNr, BigDecimal amount){

        BigDecimal balance = bankRepository2.withdrawMoney(accountNr, amount);
        BigDecimal newBalance = balance.subtract(amount);
        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Not enough money");
        }
        bankRepository2.updateBalance(accountNr, newBalance);
    }

    public void transferMoney( String fromAccount2, String toAccount2, BigDecimal amount){
        BigDecimal fromAccountBalance = bankRepository2.withdrawMoney(fromAccount2, amount);
        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if(newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Not enough money");
        }
       bankRepository2.updateBalance(fromAccount2, newFromAccountBalance);


        bankRepository2.updateBalance(toAccount2, newFromAccountBalance);


            BigDecimal toAccountBalance = bankRepository2.depositMoney( toAccount2, amount);
            BigDecimal newToAccountBalance = toAccountBalance.add(amount);
        bankRepository2.updateBalance(toAccount2, newToAccountBalance);
    }


}
