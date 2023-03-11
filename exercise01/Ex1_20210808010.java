import java.util.Arrays;
import java.util.Scanner;
public class Ex1_20210808010 {
    public static void main(String[] args) {
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.previousClosingPrice = 34.5;
        stock.currentPrice = 34.35;
        System.out.println(stock.getChangePercent());


        //Challenge part main method
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of Fans: ");
        int numberOfFans = scanner.nextInt();
        Fan[] fans = new Fan[numberOfFans];
        int j = 5; // counter
        for (int i = 0; i < numberOfFans; i++) {
            fans[i] = new Fan();
            if (i % 2 != 0){
                fans[i].setRadius(j++);

            }
        }
        System.out.println(Arrays.toString(fans));
        thirdFan(fans);

    }
    //Method for third fans in challenge part
    public static void thirdFan(Fan[] fans){
        for (int i = 2; i < fans.length ; i+=3) {
            Fan fan = fans[i];
            if (fan.isOn()){
                int speed = fan.getSpeed();
                if (speed == fan.SLOW){
                    fan.setSpeed(fan.MEDIUM);
                } else if (speed == fan.MEDIUM) {
                    fan.setSpeed(fan.FAST);

                } else if (speed == fan.FAST) {
                    fan.setSpeed(fan.SLOW);
                }
            }
        }
    }



}
class Stock{

    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    public Stock(String symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }

    public double getChangePercent(){
        double percentage = ((currentPrice - previousClosingPrice)/previousClosingPrice)*100;
        return percentage;
    }


}

class Fan{
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Fan(){

    }
    public Fan(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public String toString() {
        if(on == true){
            String message = "Fan is " + color + " with radius " + radius + " and speed " + speed;
            return message;
        }
        else{
            String message2 = "Fan is " + color + " with radius " + radius + " and fan is off";
            return message2;
        }
    }
}




