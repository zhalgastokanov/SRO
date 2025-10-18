package SRO.lab6_variant7_1;

import java.time.LocalDate;

public class Purchase {
    private String purchaseId;
    private String customerName;
    private String productName;
    private double price;
    private int quantity;
    private String paymentMethod;
    private LocalDate purchaseDate;
    private String status;

    public Purchase(String purchaseId, String customerName, String productName,
                    double price, int quantity, String paymentMethod,
                    LocalDate purchaseDate, String status) {
        this.purchaseId = purchaseId;
        this.customerName = customerName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public String getPurchaseId() { return purchaseId; }
    public String getCustomerName() { return customerName; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getPaymentMethod() { return paymentMethod; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public double getTotalAmount() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return purchaseId + " | " + customerName + " | " + productName +
                " | " + paymentMethod + " | " + getTotalAmount() +
                " | " + purchaseDate + " | " + status;
    }
}
