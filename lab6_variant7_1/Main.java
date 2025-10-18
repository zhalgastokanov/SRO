package SRO.lab6_variant7_1;

import kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase;
import kz.ektu.zhalgas.tokanov.lab6_variant7_1.PurchaseService;
import kz.ektu.zhalgas.tokanov.lab6_variant7_1.PurchaseServiceImpl;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase> purchases = new ArrayList<>();

        purchases.add(new kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase("1", "Касым", "Ноутбук", 350000, 1, "Карта",
                LocalDate.of(2025, 5, 12), "Оплачено"));
        purchases.add(new kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase("2", "Тима", "Телефон", 280000, 1, "Наличные",
                LocalDate.of(2025, 6, 3), "Доставлено"));
        purchases.add(new kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase("3", "Аружан", "Наушники", 20000, 2, "Карта",
                LocalDate.of(2025, 7, 8), "Ожидает"));
        purchases.add(new kz.ektu.zhalgas.tokanov.lab6_variant7_1.Purchase("4", "Назерке", "Монитор", 120000, 1, "Перевод",
                LocalDate.of(2025, 7, 1), "Оплачено"));
        purchases.add(new Purchase("5", "Еркежан", "Принтер", 95000, 1, "Карта",
                LocalDate.of(2025, 5, 30), "Оплачено"));

        PurchaseService service = new PurchaseServiceImpl();

        System.out.println("Метод для поиска покупок по методу оплаты");
        service.findPurchasesByPaymentMethod(purchases, "Карта").forEach(System.out::println);

        System.out.println("\nМетод для поиска покупок по дате");
        service.findPurchasesByDate(purchases, LocalDate.of(2025, 6, 1), LocalDate.of(2025, 7, 31))
                .forEach(System.out::println);

        System.out.println("\nМетод для поиска покупок с высокой стоимостью");
        service.findHighValuePurchases(purchases, 100000).forEach(System.out::println);
    }
}