package by.belstu.it.shalunov;

import java.util.Objects;

public class RenamedTextFunction {

    private int tmp1;

    public int getTmp1() {
        return tmp1;
    }

    public void setTmp1(int tmp1) {
        this.tmp1 = tmp1;
    }

    private String tmp2;

    public void setTmp2(String tmp2) {
        this.tmp2 = tmp2;
    }

    public String getTmp2() {
        return tmp2;
    }

    public String GetValue()
    {
        String str = "empty";
        str = IsEmptyStr(str);
        return str;
    }

    public RenamedTextFunction() {

    }

    private String IsEmptyStr(String str) {
        if (Objects.equals(str, "empty")) //with the help of Inspection ALT+Shift+I
            str = "Hello from my first project";
        return str;
    }
}
