package SRO.SRO11_10_2;

public class Magazine extends Item {
    private int issueNumber;

    public Magazine(String id, String title, int year, int issueNumber) {
        super(id, title, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "Журнал: " + title + " (" + year + "), выпуск №" + issueNumber;
    }
}
