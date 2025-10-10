package SRO.SRO11_10_2;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private Map<String, Item> items = new HashMap<>();
    private Map<String, List<Item>> borrowedItems = new HashMap<>();
    private Set<String> users = new HashSet<>();

    public void addItem(Item item) {
        items.put(item.getId(), item);
    }

    public void removeItem(String id) {
        items.remove(id);
    }

    public List<Item> searchByTitle(String keyword) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void addUser(String userId) {
        if (users.add(userId)) {
            System.out.println("Пользователь " + userId + " зарегистрирован.");
        } else {
            System.out.println("Пользователь с таким ID уже существует.");
        }
    }

    public void borrowItem(String itemId, String userId) {
        Item item = items.get(itemId);
        if (item == null) {
            System.out.println("Элемент не найден.");
            return;
        }

        if (!users.contains(userId)) {
            System.out.println("Пользователь не зарегистрирован.");
            return;
        }

        if (item instanceof Borrowable book) {
            List<Item> userBooks = borrowedItems.getOrDefault(userId, new ArrayList<>());
            if (userBooks.size() >= 3) {
                System.out.println("Пользователь не может взять больше 3 книг одновременно.");
                return;
            }

            if (book.borrow(userId)) {
                userBooks.add(item);
                borrowedItems.put(userId, userBooks);
            }
        } else {
            System.out.println("Этот предмет нельзя брать домой (например, журнал).");
        }
    }

    public void returnItem(String itemId, String userId) {
        List<Item> userBooks = borrowedItems.get(userId);
        if (userBooks == null) {
            System.out.println("У пользователя нет взятых предметов.");
            return;
        }

        Item item = items.get(itemId);
        if (item instanceof Borrowable book && userBooks.remove(item)) {
            book.returnItem();
        } else {
            System.out.println("Этот предмет не найден среди взятых.");
        }
    }

    public void printAllItems() {
        System.out.println("\nВсе предметы в библиотеке:");
        for (Item i : items.values()) {
            System.out.println(i);
        }
    }

    public void printSortedBooksByYear() {
        TreeSet<Item> sorted = new TreeSet<>(Comparator.comparingInt(Item::getYear));
        for (Item i : items.values()) {
            if (i instanceof Book) sorted.add(i);
        }
        System.out.println("\nКниги, отсортированные по году:");
        for (Item b : sorted) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();

        // Регистрация пользователей
        lib.addUser("user1");
        lib.addUser("user2");
        lib.addUser("user1"); // дубликат

        // Добавление предметов
        lib.addItem(new Book("B1", "Война и мир", 1869, "Толстой", "Роман"));
        lib.addItem(new Book("B2", "Преступление и наказание", 1866, "Достоевский", "Роман"));
        lib.addItem(new Book("B3", "1984", 1949, "Оруэлл", "Антиутопия"));
        lib.addItem(new Magazine("M1", "National Geographic", 2024, 7));

        lib.printAllItems();

        // Поиск по названию
        System.out.println("\nПоиск по слову 'и':");
        for (Item i : lib.searchByTitle("и")) {
            System.out.println(i);
        }

        // Бронирование
        lib.borrowItem("B1", "user1");
        lib.borrowItem("B2", "user1");
        lib.borrowItem("B3", "user1");
        lib.borrowItem("M1", "user1"); // нельзя
        lib.borrowItem("B2", "user2"); // книга уже занята
        lib.borrowItem("B3", "user1"); // превышение лимита

        // Возврат
        lib.returnItem("B1", "user1");

        // Сортировка
        lib.printSortedBooksByYear();
    }
}
