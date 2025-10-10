package SRO.SRO11_10_1;

public class Employee extends Person {
    private String role;
    private double salary;

    public Employee(int id, String name, String role, double salary) {
        super(id, name);
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + role + ", Зарплата: " + salary + ")";
    }
}
