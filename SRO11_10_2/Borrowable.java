package SRO.SRO11_10_2;

public interface Borrowable {
    boolean borrow(String userId);
    void returnItem();
    boolean isAvailable();
}
