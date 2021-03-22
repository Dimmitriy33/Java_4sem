package Main;
import Road.Car;
        import Road.road;
        import Shower.Shower;
        import Shower.Users.Female;
        import Shower.Users.Male;

        import java.util.Random;
        import java.util.concurrent.locks.ReentrantLock;
public class Main {
    public static void main(String[] args) {

        Shower shower = new Shower(2);
        Male m1 = new Male(1, shower);
        Male m2 = new Male(2, shower);
        Male m3 = new Male(3, shower);
        Male m4 = new Male(4, shower);
        Female f1 = new Female(1, shower);
        Female f2 = new Female(2, shower);
        Female f3 = new Female(3, shower);
        Female f4 = new Female(4, shower);
        f1.start();
        f2.start();
        m1.start();
        m2.start();
        m3.start();
        f3.start();
        m4.start();
        f4.start();

        //2
        /*ReentrantLock locker = new ReentrantLock();
        road Road = new road(3,locker, 'l');
        Car car1 = new Car(1,'l',Road);
        Car car2 = new Car(2,'l',Road);
        Car car3 = new Car(3,'l',Road);
        Car car4 = new Car(4,'l',Road);
        Car car5 = new Car(5,'l',Road);
        Car car6 = new Car(6,'r',Road);
        Car car7 = new Car(7,'r',Road);
        Car car8 = new Car(8,'r',Road);
        Car car9 = new Car(9,'r',Road);
        Car car10 = new Car(10,'r',Road);
        car1.start();
        car6.start();
        car2.start();
        car3.start();
        car7.start();
        car8.start();
        car9.start();
        car4.start();
        car5.start();
        car10.start();*/

    }

}
