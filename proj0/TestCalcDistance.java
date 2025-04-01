
/**
 *  Tests calcDistance
 */
public class TestCalcDistance {

    /**
     *  Tests calcDistance.
     */
    public static void main(String[] args) {
        //main函数，测试框架封装好放在main里面等待执行
        checkCalcDistance();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    //列举参数,这前面就是一个decorator,说明了一下函数里的参数都是干啥的
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Checks the Planet class to make sure calcDistance works.
     */
    private static void checkCalcDistance() {
        System.out.println("Checking calcDistance...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

        checkEquals(p1.calcDistance(p2), 1.0, "calcDistance()", 0.01);
        checkEquals(p1.calcDistance(p3), 5.0, "calcDistance()", 0.01);
    }
}
