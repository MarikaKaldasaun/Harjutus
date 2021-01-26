package ee.bcs.valiit.bankrepository2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository

public class BankRepository2 {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr) {
        String sql = "INSERT INTO account2 (account_number, balance) VALUES (:accountNumber, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal accountBalance( String accountNr) {
        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public BigDecimal depositMoney(String accountNr, BigDecimal amount) {
        // BigDecimal balance = accountMap.get(accountNr);
        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }
    public void updateBalance (String accountNr, BigDecimal amount) {
        // accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", amount);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public BigDecimal withdrawMoney(String accountNr, BigDecimal amount){
        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        }

    public void placeMoney(String accountNr, BigDecimal amount){
        //accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", amount);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public BigDecimal transferMoney( String fromAccount2, String toAccount2, BigDecimal amount) {
        String sql = "SELECT balance FROM account2 where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", fromAccount2);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }


        // accountMap.put(fromAccount, newFromAccountBalance);
        public void x ( String fromAccount2, String toAccount2, BigDecimal amount) {
            String sql2 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
            Map<String, Object> paramMap2 = new HashMap();
            paramMap2.put("accountNumber", fromAccount2);
            paramMap2.put("balance", amount);
            jdbcTemplate.update(sql2, paramMap2);
        }
        // BigDecimal toAccountBalance = accountMap.get(toAccount);
            public void y ( String fromAccount2, String toAccount2, BigDecimal amount) {
                String sql3 = "SELECT balance FROM account2 where account_number = :accountNumber";
                Map<String, Object> paramMap3 = new HashMap<>();
                paramMap3.put("accountNumber", toAccount2);
                jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);
            }


        // accountMap.put(toAccount, newToAccountBalance);
                public void z ( String fromAccount2, String toAccount2, BigDecimal amount){
        String sql4 = "UPDATE account2 SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap4 = new HashMap();
        paramMap4.put("accountNumber", toAccount2);
        paramMap4.put("balance", amount);
        jdbcTemplate.update(sql4, paramMap4);
    }

}
