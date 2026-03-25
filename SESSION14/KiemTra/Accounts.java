package SESSION14.KiemTra;

public class Accounts {
    private String Accounts;
    private String FullName;
    private Double Balance;

    public Accounts() {
    }

    public Accounts(String accounts, String fullName, Double balance) {
        Accounts = accounts;
        FullName = fullName;
        Balance = balance;
    }

    public String getAccounts() {
        return Accounts;
    }

    public void setAccounts(String accounts) {
        Accounts = accounts;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }
}
