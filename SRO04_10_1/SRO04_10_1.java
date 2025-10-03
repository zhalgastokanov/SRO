package SRO.SRO04_10_1;
abstract class Employee {
    protected String name;
    protected double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public abstract void work();
    public abstract void introduce();
}
class Developer extends Employee {
    private String programmingLanguage;
    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public void work() {
        System.out.println(name + " пишет код на " + programmingLanguage);
    }
    @Override
    public void introduce() {
        System.out.println("Я разработчик " + name + ", зарплата " + salary + ", язык программирования: " + programmingLanguage);
    }
}
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }
    @Override
    public void work() {
        System.out.println(name + " управляет командой из " + teamSize + " человек");
    }
    @Override
    public void introduce() {
        System.out.println("Я менеджер " + name + ", зарплата " + salary + ", размер команды: " + teamSize);
    }
}
public class SRO04_10_1 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Developer("Жалгас", 500000, "Java"),
                new Manager("Жалгас", 800000, 10)
        };
        for (Employee employee : employees) {
            employee.work();
            employee.introduce();
            System.out.println();
        }
    }
}