package ee.bcs.valiit.tasks.Repository;

import ee.bcs.valiit.tasks.Controller.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
@Repository
public class BankRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(@RequestBody Bank account) {
        // accountMap.put(accountNr, BigDecimal.ZERO);
        String sql = "INSERT INTO account (account_nr, customer_id, balance) VALUES (:account_nrParameter," +
                " :customer_idParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", account.getAccount_nr());
        paramMap.put("customer_idParameter", account.getCustomer_id());
        paramMap.put("balanceParameter", account.getBalance());
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal accountBalance(@RequestParam("account_nr") String account_nr) {
        String sql = "Select balance from account where account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", account_nr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public void depositMoney(@RequestParam ("account_nr") String account_nr,
                            @RequestParam ("amount") BigDecimal amount ) {

        String sql = "SELECT balance FROM account WHERE account_nr = : accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", account_nr);
         jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

        public void updateMoney(@RequestParam ("account_nr") String account_nr,
                @RequestParam ("amount") BigDecimal amount ){
       // BigDecimal newBalance = balance.add(amount);

        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("accountNumber", account_nr);
        paramMap2.put("balance", newBalance);
       jdbcTemplate.update(sql2, paramMap2);
        //System.out.println("The amount " + amount + " was added to " + account_nr);
    }


    public void withdrawMoney(@RequestParam ("account_nr") String account_nr,
                              @RequestParam ("amount") BigDecimal amount){
        String sql = "SELECT balance FROM account WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", account_nr);
       // BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        //BigDecimal newBalance = balance.subtract(amount);

        }
    public void updateAccount(@RequestParam ("account_nr") String account_nr,
                              @RequestParam ("amount") BigDecimal amount){
        //accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE account SET balance = :balance WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("accountNumber", account_nr);
        paramMap2.put(sql2, paramMap2);
    }



}

