package Road;

import java.util.Random;

public class Car extends Thread{
    private int id;
    private char course; // r - right, l - left
    road Road;
    public Car(int id, char course, road Road) {
        this.id = id;
        this.course = course;
        this.Road = Road;
    }

    public int getIdent() {
        return this.id;
    }

    public char getCourse() {
        return course;
    }

    @Override
    public void run() {
        try {
            switch(Road.getCurCourse()) {
                case 'r': if(this.course != 'r') {
                                this.sleep(1000);
                            } while (Road.getCurCourse() != 'r');
                break;
                case 'l': if(this.course != 'l') {
                                this.sleep(1000);
                            } while (Road.getCurCourse() != 'l');
                    break;
                default:
                    break;
            }
            Road.setCarsleft(Road.getCarsleft() + 1);
            if(Road.getCarsleft() >= 3) {
                if (Road.getCurCourse() == 'l')
                    Road.setCurCourse('r');
                else
                    Road.setCurCourse('l');
                Road.setCarsleft(0);
            }
            Road.acquire(this);
            Road.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
