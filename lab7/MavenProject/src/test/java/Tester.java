import org.junit.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tester {

    private static int a;
    private static int b;

    @BeforeClass
    public static void Init() {
        System.out.println("Инициализация переменных\n");
        a = 2;
        b = 4;
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Заверщение тестов");
        a = 0;
        b = 0;
    }

    @Test(timeout = 10000)
    public void Sum_AandB_Returned() {
        Assert.assertEquals(a+b, Calculator.Sum(a, b));
        System.out.printf(" Тест a = %s, b = %s\n  a + b \n\n", a, b);
    }

    @Test
    @Ignore
    public void Mul_AandB_Returned() throws InterruptedException {
        Assert.assertEquals(a*b, Calculator.Mul(a, b));
        System.out.printf(" Тест a = %s, b = %s\n  a * b \n\n", a, b);
    }

    @Test
    public void GroupAssert() {
        assertAll(() -> assertEquals(a+b, Calculator.Sum(a, b)),
                () -> assertEquals(a*b, Calculator.Mul(a, b)),
                () -> assertEquals(a-b, Calculator.Dif(a, b)));
        System.out.printf(" Групповое тестирование a = %s, b = %s\n  a + b\n  a * b\n  a - b\n\n", a, b);
    }
}
