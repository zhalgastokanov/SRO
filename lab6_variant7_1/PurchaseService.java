package SRO.lab6_variant7_1;

import kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseService {
    // Метод для поиска покупок по методу оплаты
    List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> findPurchasesByPaymentMethod(List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> purchases, String paymentMethod);
    // Метод для поиска покупок по дате
    List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> findPurchasesByDate(List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> purchases, LocalDate fromDate, LocalDate toDate);
    // Метод для поиска покупок с высокой стоимостью
    List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> findHighValuePurchases(List<Purchase> purchases, double minAmount);
}