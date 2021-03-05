package Shower;

import Shower.Users.Female;
import Shower.Users.IUser;
import Shower.Users.Male;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Shower extends Semaphore {
    volatile int Come; // volatile обеспечивает неделимость значения и не записывает его в кэш, исключая копии

    public void setGenderInShower(char genderInShower) {
        this.genderInShower = genderInShower;
    }

    volatile char genderInShower;
    public Shower(int permits) {
        super(permits);
    }

    public boolean shower_status(char gender) {
        if(this.Come == 0) {
            this.genderInShower = gender;
            return true;
        }
        else {
            return switch (gender) {
                case 'f' -> this.genderInShower == 'f' && this.Come != 0;
                case 'm' -> this.genderInShower == 'm';
                default -> false;
            };
        }
    }

    public void acquire(Male male) throws InterruptedException { // получение у семафора разрешения
        Random randNum = new Random();
        Object obj1 = new Object();
        Object obj2 = new Object();
        synchronized (obj1) {
            System.out.println(String.format("%s guest %d goes in", male.getGender(), male.getIdent()));
        }
        male.sleep(randNum.nextInt(1000) + 500);
        synchronized (obj2) {
            System.out.println(String.format("m guest %d goes out", male.getIdent()));
        }
    }

    public  void acquire(Female female) throws InterruptedException {
        Random randNum = new Random();
        Object obj1 = new Object();
        Object obj2 = new Object();
        synchronized (obj1) {System.out.printf("%s female %d goes in%n", female.getGender(), female.getIdent()); }
        female.sleep(randNum.nextInt(1000) + 1000);
        synchronized (obj2) {System.out.printf("f female %d goes out%n", female.getIdent());}
    }

    public  void acquire(IUser user) throws InterruptedException {
        super.acquire();
        this.Come++;
        if(String.valueOf(user.getGender()).equals("f")) {
            this.acquire((Female)user);
        } else {
            this.acquire((Male)user);
        }
        this.Come--;
    }
}
