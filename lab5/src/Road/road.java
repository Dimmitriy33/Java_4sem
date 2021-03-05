package Road;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class road extends Semaphore {
    ReentrantLock locker;

    private char curCourse;
    private int curCars;

    public int getCarsleft() {
        return carsleft;
    }

    public void setCarsleft(int carsleft) {
        this.carsleft = carsleft;
    }

    private int carsleft = 0;

    public road(int permits) {
        super(permits);
    }

    public road(int permits, ReentrantLock locker, char course) {
        super(permits);
        this.locker = locker;
        this.curCourse = course;
    }

    public char getCurCourse() {
        return curCourse;
    }

    public void setCurCourse(char curCourse) {
        this.curCourse = curCourse;
    }

    public int getCurCars() {
        return curCars;
    }

    public void setCurCars(int curCars) {
        this.curCars = curCars;
    }

    public void acquire(Car car) throws InterruptedException {

        super.acquire();
        Random rand = new Random();
        this.locker.lock();
        System.out.println(String.format("%s car %d goes in ",
                car.getCourse(),
                car.getIdent()));
        this.locker.unlock();
        car.sleep(500 + rand.nextInt(1000));
        ++this.carsleft;
        this.locker.lock();
        System.out.println(String.format("%s car %d goes out",
                car.getCourse(),
                car.getIdent()));
        this.locker.unlock();

    }
}
