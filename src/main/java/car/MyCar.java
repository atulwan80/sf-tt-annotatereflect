package car;

import myannot.RunMe;

//@RunMe
public class MyCar {
//    @RunMe
    private String color;
    private int speed;

    public MyCar() {
        this("Grey", 0);
    }

    @RunMe(color = "Red")
    public void showMyself() {
        System.out.println("Look at me: " + toString());
    }

    @RunMe(value = 8, color = "Green")
    public void bragABit() {
        System.out.println("I'm going fast! " + speed);
    }

    public MyCar(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @RunMe(9)
    private void revEngine() {
        System.out.println("Vrooom vroom!");
    }

    @Override
    public String toString() {
        return "car.MyCar{" +
                "color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }
}
