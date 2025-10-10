package SRO.SRO11_10_2;

public abstract class Item {
    protected String id;
    protected String title;
    protected int year;

    public Item(String id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}
