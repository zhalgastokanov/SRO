package SRO.lab6_variant7_1;

import kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase;
import kz.ektu.zhalgas.tokanov.lab6_variant7_1.PurchaseService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PurchaseServiceImpl implements PurchaseService {

    @Override
    public List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> findPurchasesByPaymentMethod(List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> purchases, String paymentMethod) {
        if (purchases == null || paymentMethod == null) return Collections.emptyList();

        return purchases.stream()
                .filter(p -> paymentMethod.equalsIgnoreCase(p.getPaymentMethod()))
                .collect(Collectors.toList());
    }

    @Override
    public List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> findPurchasesByDate(List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> purchases, LocalDate fromDate, LocalDate toDate) {
        if (purchases == null || fromDate == null || toDate == null) return Collections.emptyList();

        return purchases.stream()
                .filter(p -> !p.getPurchaseDate().isBefore(fromDate) && !p.getPurchaseDate().isAfter(toDate))
                .sorted(Comparator.comparing(kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase::getPurchaseDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> findHighValuePurchases(List<Purchase> purchases, double minAmount) {
        if (purchases == null) return Collections.emptyList();

        return purchases.stream()
                .filter(p -> p.getTotalAmount() >= minAmount)
                .collect(Collectors.toList());
    }
}