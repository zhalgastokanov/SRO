package SRO.SRO11_10_1;

public class Passenger extends Person implements Comparable<Passenger> {
    private String passportNumber;
    private int loyaltyPoints;

    public Passenger(int id, String name, String passportNumber, int loyaltyPoints) {
        super(id, name);
        this.passportNumber = passportNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addPoints(int points) {
        this.loyaltyPoints += points;
    }

    @Override
    public String toString() {
        return name + " (Паспорт: " + passportNumber + ", Баллы: " + loyaltyPoints + ")";
    }

    @Override
    public int compareTo(Passenger other) {
        return Integer.compare(other.loyaltyPoints, this.loyaltyPoints); // сортировка по убыванию баллов
    }
}
