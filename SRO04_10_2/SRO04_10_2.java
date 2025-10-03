package SRO.SRO04_10_2;
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
interface Reportable {
    void generateReport();
}
interface Trainable {
    void attendTraining();
}
class Developer extends Employee implements Trainable {
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
        System.out.println("Я разработчик " + name + ", зарплата " + salary);
    }
    @Override
    public void attendTraining() {
        System.out.println(name +" проходит обучение ");
    }
}
class Manager extends Employee implements Reportable {
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
        System.out.println("Я менеджер " + name + ", зарплата " + salary);
    }
    @Override
    public void generateReport() {
        System.out.println(name + " составляет отчёт для команды ");
    }
}
public class SRO04_10_2 {
    public static void main(String[] args) {
        Developer dev = new Developer("Жалгас", 500000, "Java");
        Manager man = new Manager("Жалгас", 800000, 10);
        dev.introduce();
        dev.work();
        dev.attendTraining();
        System.out.println();
        man.introduce();
        man.work();
        man.generateReport();
    }
}
