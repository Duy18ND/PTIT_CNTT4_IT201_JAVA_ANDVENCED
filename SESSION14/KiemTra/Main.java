package SESSION14.KiemTra;

public class Main {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOImpl();
        String fromAccountId = "ACC01";
        String toAccountId = "ACC02";
        double amountToTransfer = 1000;
        Accounts accounts = new Accounts();
        System.out.println("================== TRẠNG THÁI BAN ĐẦU ==================");
        System.out.println("Số dư tài khoản " + fromAccountId + ": " + accounts.getBalance());
        System.out.println("Số dư tài khoản " + toAccountId + ": " + accounts.getBalance());
        System.out.println("========================================================");

        System.out.println("\nĐang thực hiện chuyển " + amountToTransfer + " từ " + fromAccountId + " sang " + toAccountId + "...");
        boolean transferSuccess = accountDAO.transfer(fromAccountId, toAccountId, amountToTransfer);

        if (transferSuccess) {
            System.out.println("CHUYỂN TIỀN THÀNH CÔNG!");
        } else {
            System.out.println("CHUYỂN TIỀN THẤT BẠI!");
        }

        System.out.println("\n================== TRẠNG THÁI SAU GIAO DỊCH =================");
        System.out.println("Số dư mới của tài khoản " + fromAccountId + ": " + accounts.getBalance());
        System.out.println("Số dư mới của tài khoản " + toAccountId + ": " + accounts.getBalance());
        System.out.println("========================================================");
    }
}