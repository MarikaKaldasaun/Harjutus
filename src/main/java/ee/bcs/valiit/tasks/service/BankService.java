package ee.bcs.valiit.tasks.service;

import ee.bcs.valiit.tasks.Controller.Bank;
import ee.bcs.valiit.tasks.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createAccount(Bank account) {

        bankRepository.createAccount(account);
    }

    public BigDecimal accountBalance(String account_nr) {
        return bankRepository.accountBalance(account_nr);
    }

    public void depositMoney(String account_nr, BigDecimal amount) {
        BigDecimal balance = bankRepository.accountBalance(account_nr);
       bankRepository.depositMoney(account_nr, amount);
    }

    //public void x (String account_nr, BigDecimal newbalance ) {

    //  bankRepository.updateMoney(account_nr, newbalance);
    //System.out.println("The amount " + amount + " was added to " + account_nr);
    //}

    public void withdrawMoney(String account_nr, BigDecimal amount) {
        //  BigDecimal balance = accountRepository.getAccountBalance(account_nr);


        // if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
        throw new RuntimeException("Not enough money");
    }


    //   public void updateAccount(String account_nr, BigDecimal amount){

    //    return bankRepository.withdrawMoney(account_nr, amount);
}


//  public void withdrawMoney(String account_nr, BigDecimal amount){

//if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
//  throw new RuntimeException("Not enough money")}
//bankRepository.withdrawMoney(account_nr, amount);
//}



