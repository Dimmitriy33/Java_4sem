package by.Shalunov.IT_company.Recruitment;

public class DirectionPlan
{
    private String direction;
    private int count;

    public DirectionPlan() {
    }

    public DirectionPlan(String direction, int count) {
        this.direction = direction;
        this.count = count;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
