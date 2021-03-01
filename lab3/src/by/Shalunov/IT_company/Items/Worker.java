package by.Shalunov.IT_company.Items;

public class Worker extends Person {
    private String direction;
    private double salary;
    private int skill;

    public Worker() {
        super();
    }

    public Worker(String surname, String name, String direction, int skill, double salary) {
        super(name,surname);
        this.direction = direction;
        this.skill = skill;
        this.salary = salary;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
