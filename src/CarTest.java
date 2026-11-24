public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    private static void testMove() {
        Saab95 fastSaab = new Saab95();
        Saab95 slowSaab = new Saab95();
        fastSaab.startEngine();
        slowSaab.startEngine();
        slowSaab.turnLeft();
        fastSaab.setTurboOn();
        fastSaab.move();
        slowSaab.move();
       boolean result = fastSaab.getY() == 0.1 && slowSaab.getX() == -0.1;
       reportResult("Car Moves",result);

    }
    private static void testStopEngine(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.stopEngine();
        boolean result = volvo.getCurrentSpeed() == 0;
        reportResult("Car starts and stops", result);
    }

    private static void testBrake(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine(); // 0.1
        volvo.gas(0.5); //0.725
        double speed = volvo.getCurrentSpeed();
        volvo.brake(0.1); //0.6
        boolean result = volvo.getCurrentSpeed() == 0.6;
        reportResult("Car slows down when break is initiated.", result);

    }
    private static void testGas()
    {
        Saab95 fastSaab = new Saab95();
        Saab95 slowSaab = new Saab95();
        fastSaab.setTurboOn();
        fastSaab.startEngine();
        slowSaab.startEngine();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = fastSaab.getCurrentSpeed() > slowSaab.getCurrentSpeed();
        reportResult("Fast Saab accelerates faster", result);
    }

    private static void testTurn() {
        Saab95 Saab1 = new Saab95();
        Saab95 Saab2 = new Saab95();
        Saab1.startEngine();
        Saab2.startEngine();
        Saab2.move();

        Saab1.turnLeft();
        Saab1.move();
        boolean result = (Saab2.getX() != Saab1.getX() || Saab2.getY() != Saab1.getY());
        reportResult("Turn works", result);
    }

    static void main() {
        testTurbo();
        testMove();
        testStopEngine();
        testBrake();
        testGas();
        testTurn();
        //TODO: add and run more tests
    }
}
