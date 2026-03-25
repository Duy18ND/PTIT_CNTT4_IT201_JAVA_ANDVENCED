package SESSION14.KiemTra;

public interface AccountDAO {
    boolean findById(String id);
    boolean transfer(String fromAccountId, String toAccountId, double amount);
}
