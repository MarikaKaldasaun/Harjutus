package ee.bcs.valiit.tasks.Controller;

public class Bank {

    public String account_nr;
    private int account_id;
    private String customer_id;
    private String balance;


    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }



    public String getAccount_nr() {
        return account_nr;
    }

    public void setAccount_nr(String account_nr) {
        this.account_nr = account_nr;
    }
}
