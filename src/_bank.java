import java.io.Serializable;

public class _bank implements Serializable {
    private int balance;
    private String id;

    _bank(int balance, String id) {
        this.balance = balance;
        this.id = id;
    }
    public void showData() {
        System.out.println("Balance: " + this.balance);
        System.out.println("id: " + this.id);
    }
}
