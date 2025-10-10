package SRO.SRO11_10_2;

public class Book extends Item implements Borrowable {
    private String author;
    private String genre;
    private boolean available = true;
    private String borrowedBy;

    public Book(String id, String title, int year, String author, String genre) {
        super(id, title, year);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public boolean borrow(String userId) {
        if (!available) {
            System.out.println("Книга \"" + title + "\" уже занята.");
            return false;
        }
        available = false;
        borrowedBy = userId;
        System.out.println(userId + " взял книгу \"" + title + "\".");
        return true;
    }

    @Override
    public void returnItem() {
        available = true;
        borrowedBy = null;
        System.out.println("Книга \"" + title + "\" возвращена в библиотеку.");
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Книга: " + title + " (" + year + "), автор: " + author + ", жанр: " + genre;
    }
}
