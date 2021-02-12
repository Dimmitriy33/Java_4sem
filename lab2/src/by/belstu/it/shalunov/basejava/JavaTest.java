/**
 * @author Dmitriy Shalunov POIT 2 - 5 - 1
 * @version 1.1
 * @since 1.0
 */

package by.belstu.it.shalunov.basejava;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.*;

/**
 * Класс использующийся для выполнения задания 3a
 */
public class JavaTest {

    final String MY_NAME1 = "Dima";
    /**public final*/
    public final String MY_NAME2 = "Dima";
    /**public static final*/
    public static final String MY_NAME3 = "Dima";

    /**
     * Точка входа в программу
     * @param args - аргументы командной строки
     * */
    public static void main(String[] args) {
        /** Создание переменных разных типов */
        char ch = 'x';
        String str = "x";
        int i = -100;
        double d = 21.2;
        byte b = 20;
        long l = -200;
        boolean bool = true; //1
        /** Выполнение различных заданий с переменными разных типов*/
        System.out.println("String + int -- " + (str+i));
        System.out.println("String + char -- " + (str+ch));
        System.out.println("String + double -- " + (str+d));
        b += i; // byte + int
        i += d+l; // double + long
        l += i + 2147483647;
        System.out.println("byte = byte + int -- " + (b));
        System.out.println("int = double + long -- " + (i));
        System.out.println("long = int + 2147483647 -- " + (l));

        //TODO static is not allowed
        /*static int sint;
        System.out.println("sint -- " + (sint));*/

        bool = bool && false;
        System.out.println("boolean && boolean -- " + (b));
        bool = bool ^ bool; // ^ - xor
        System.out.println("boolean && boolean -- " + (b));

        //TODO boolean + boolean - нельзя
        /*bool = bool + bool;*/

        l = 9223372036854775807L; // L - указывает, что тип long
        l = 0x7fff_ffff_fffL;

        char ch1 = 'a', ch2 = '\u0061', ch3 = 97;
        System.out.println("ch1 -- " + (ch1));
        System.out.println("ch2 -- " + (ch2));
        System.out.println("ch3 -- " + (ch3));
        System.out.println("ch1 + ch2 + ch3 -- " + (ch1+ch2+ch3));

        System.out.println("3.45 % 2.4 -- " + (3.45 % 2.4));
        System.out.println("1.0 % 0.0 -- " + (1.0 % 0.0));
        System.out.println("0.0 % 0.0 -- " + (0.0 % 0.0));
        System.out.println("log(-345) -- " + (log(-345)));
        System.out.println("Float.intBitsToFloat(0x7F800000) -- " + (Float.intBitsToFloat(0x7F800000)));
        System.out.println("Float.intBitsToFloat(0xFF800000 -- " + (Float.intBitsToFloat(0xFF800000)));

        //Системы счисления - Двоичная, Восьмеричная, Десятичная, Шестнадцатеричная

        /**
         * Я изменил тип данных для более наглядной демонстрации
         * @see JavaTest
         * @value my Name
         * */
        String name;
        //name = MY_NAME1; /* MY_NAME1  not public and not static(main -- static)*/
        //name = MY_NAME2; /* MY_NAME2  not static(main -- static)*/
        name = MY_NAME3; // all good

        System.out.println("PI -- " + PI);
        System.out.println("E -- " + E);
        System.out.println("round PI -- " + round(PI));
        System.out.println("round E -- " + round(E));
        System.out.println("min(PI,E) -- " + min(PI,E));
        System.out.println("random[0,1) -- " + random());

        Boolean BOOL;
        Integer I = i;
        Character CH = ch;
        Byte B = b;
        Short SH;
        Long L = l;
        Double D = d;

        I &= 1;
        L = l >>> 2; // сдвинутые значения заполняются нулями
        SH = ~(short)20; // дополнение(инвертирование бит + 1)
        D *= 2.1;

        System.out.println("Long MIN_VALUE -- " + Long.MIN_VALUE);
        System.out.println("Double MIN_VALUE -- " + Double.MIN_VALUE);
        System.out.println("Long MAX_VALUE -- " + Long.MAX_VALUE);
        System.out.println("Double MAX_VALUE -- " + Long.MAX_VALUE);

        I = 1; // boxing
        i = new Integer(10);
        B = 10;
        b = new Byte((byte)10);

        System.out.println("parseInt(\"10\") -- " + Integer.parseInt("10"));
        System.out.println("toHesString(10) -- "+Integer.toHexString(i));
        System.out.println("compare(random()+4,random()+4) -- "+Integer.compare((int)(random() + 3), (int)(random() + 4)));
        System.out.println("bitCount(10) -- "+Integer.bitCount(10));
        System.out.println("isNaN(0/0) -- " + Float.isNaN(0.0f/0.0f));

        String s34 = "2345";
        int s34i = new Integer(s34); // с помощью конструктора
        s34i = Integer.valueOf(s34); // c помощтю valueOf
        s34i = Integer.parseInt(s34); // c помощтю parseInt

        byte[] byteArray = s34.getBytes();
        System.out.println("Строку в массив байт : " + Arrays.toString(byteArray));
        // конвертируем байты в строку
        String byteStr = new String(byteArray);
        System.out.println("байты в строку : " + byteStr);
        //равны ли наши строки
        System.out.println("s34 == byteStr : " + (s34 == byteStr));
        System.out.println("s34.equals(byteStr) : " + (s34.equals(byteStr)));

        String str1 = "Hello!", str2 = "Hello!";
        System.out.println("str1 == \"Hello!\", str2 == \"Hello!\" -->  ");
        System.out.println("str1 == str2 : " + (str1 == str2)); // == проверяет ссылки
        System.out.println("str1.equals(str2) : " + (str1.equals(str2))); // equals проверяет значения
        System.out.println("str1.compareTo(str2) : " + (str1.compareTo(str2)));

        str2 = null;
        System.out.println("str1 == \"Hello!\", str2 == null -->  ");
        System.out.println("str1 == str2 : " + (str1 == str2));
        System.out.println("str1.equals(str2) : " + (str1.equals(str2)));
        /*System.out.println("str1.compareTo(str2) : " + (str1.compareTo(str2)));*/
        /*Cannot read field "value" because "anotherString" is null*/

        str1 = "2day is a good Day";
        System.out.println("split --> ");
        for (String str1Ex : str1.split(" ")) {
            System.out.println(str1Ex);
        }
        System.out.println("contains(2) -- " + str1.contains("2"));
        System.out.println("hashcode -- " + str1.hashCode());
        System.out.println("indexOf(H) -- " + str1.indexOf('D'));
        System.out.println("length -- " + str1.length());
        System.out.println("replace(D,d) -- " + str1.replace('D','d'));

        char[][] c1 = new char[3][];
        char[] c2[] = new char[][] {
                {'q','w','e'},
                {'a','s','d'},
                {}
                };
        char c3[][] = new char[][]  {
                {'q','w','e'},
                {'a','s','d'},
                {}
        };
        System.out.println("c1.length -- " + c1.length);
        /*System.out.println("c1[0].length -- " + c1[0].length);*/ //Cannot read the array length because "c1[0]" is null
        bool = c2 == c3;
        System.out.println("c2 == c3 -- " + bool);
        c2 = c3;
        bool = c2 == c3;
        System.out.println("c2 == c3 -- " + bool);

        for (char[] chEx : c2) {
            for (char ch2Ex : chEx) {
                System.out.print(ch2Ex + " ");
            }
            System.out.println();
        }

        class WrapperString {
            private String string;

            public WrapperString(String string) {
                this.string = string;
            }

            public WrapperString() {
                string = "unknown";
            }

            public String getString() {
                return string;
            }

            public void setString(String string) {
                this.string = string;
            }

            @Override
            public String toString() {
                return "WrapperString{" +
                        "string='" + string + '\'' +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                WrapperString that = (WrapperString) o;
                return Objects.equals(string, that.string);
            }

            @Override
            public int hashCode() {
                return Objects.hash(string);
            }

            public void replace (char oldchar, char newchar)
            {
                string.replace(oldchar, newchar);
            }
        }

        WrapperString ws = new WrapperString();
        ws.replace('u','U');
        WrapperString ws2 = new WrapperString()
        {
            @Override
            public void replace(char oldchar, char newchar) {
                super.replace(oldchar, 'q'); // super бращается к родительскому классу
            }

            public void delete(char newchar)
            {
                this.delete(newchar);
            }
        };


    }
}
