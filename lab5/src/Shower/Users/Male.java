package Shower.Users;

import Shower.Shower;

import java.util.Random;

public class Male extends Thread implements IUser {

    private int id;
    Shower shower;
    public Male(int id, Shower shower) {
        this.id = id;
        this.shower = shower;
    }

    @Override
    public int getIdent() {
        return this.id;
    }

    @Override
    public char getGender() {
        return 'm';
    }

    @Override
    public void run() {
        Random randNum = new Random();
        try {
            if(!shower.shower_status(this.getGender())) {
                do {
                    this.sleep(1000);
                } while (!shower.shower_status(this.getGender()));

            }
            shower.setGenderInShower('m');
            shower.acquire((IUser) this);
            shower.release();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
