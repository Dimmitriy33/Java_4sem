package by.belstu.it.shalunov;
public class Main {

    public static void main(String[] args) {
	// write your code here
        // TODO New comment
        RenamedTextFunction TestObj = new RenamedTextFunction();
        System.out.println(TestObj.GetValue());

        for (int count = 0; count < 5; count++ )
        {
            int num = (int) (1 + Math.random() * 9);
            System.out.println("Current number: " + num);
        }
    }
}
