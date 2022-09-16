package CircleCalc;
import java.util.Random;

public class App {
   public static void main(String[] args){
        Random randomNum = new Random();
        int randInt = randomNum.nextInt();
        randInt = Math.abs(randInt);
        double area = Math.pow(randInt,2)*Math.PI;
        double circum = Math.PI*2*randInt;

        System.out.printf("Radius of the Circle: %10d", randInt);
        System.out.println();
        System.out.printf("Area of the Circle: %10.2f", area);
        System.out.println();
        System.out.printf("Circumference of the Circle: %10.2f", circum);
   } 
}
