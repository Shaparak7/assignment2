import java.awt.*;
public abstract class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    // Task 2
    private double x; // The X  coordinates
    private double y; // The Y coordinates
    private String facingDirection;


    //Constructors - Vehicle properties
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;

        //Task 2
        this.x = 0;
        this.y = 0;
        this.facingDirection = "North";
    }
        //Methods
        public int getNrDoors(){
            return nrDoors;
        }

        public double getEnginePower() {
            return enginePower;
        }

        public double getCurrentSpeed() {
        return currentSpeed;
    }

        public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }
    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }


    //Task 2
    public void turnLeft(){
        if (facingDirection.equals("East")) {
            facingDirection = "North";
        }
        else if(facingDirection.equals("West")){
            facingDirection = "South";
        }
        else if(facingDirection.equals("North")){
            facingDirection = "West";
        }
        else if (facingDirection.equals("South")){
            facingDirection = "East";
        }
    }

    public void turnRight(){
        if(facingDirection.equals("East")){
            facingDirection = "South";
        }
        else if(facingDirection.equals("West")){
            facingDirection = "North";
        }
        else if(facingDirection.equals("North")){
            facingDirection="East";
        }
        else if(facingDirection.equals("South")){
            facingDirection ="West";
        }

    }
    public void move(){
        if(facingDirection.equals("North")){
            y += getCurrentSpeed();
        }
        else if (facingDirection.equals("South")){
            y -= getCurrentSpeed();
        }
        else if (facingDirection.equals("East")){
            x += getCurrentSpeed();
        }
        else if (facingDirection.equals("West")){
            x -= getCurrentSpeed();
        }
    }

    public String getDirection(){
        return facingDirection;
    }

    public double getY(){
        return y;
    }
    public double getX(){
        return x;
    }

    //Task 4
    public void gas(double amount) {
        checkAmount(amount);
        if (getCurrentSpeed() + speedFactor() * amount > enginePower) {
            currentSpeed = enginePower;
        }
        else {
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        checkAmount(amount);
        if (getCurrentSpeed() - speedFactor() * amount < 0) {
            currentSpeed = 0;
        }
        else{
            decrementSpeed(amount);
        }
    }
    private static void checkAmount(double amount) {
        if (!(amount >= 0 && amount <=1))  {
            throw new IllegalArgumentException();
        }
    }}


