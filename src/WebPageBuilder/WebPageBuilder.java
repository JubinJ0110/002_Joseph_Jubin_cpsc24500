package WebPageBuilder;
import java.util.Scanner;

public class WebPageBuilder {

    public int computeAgeInMonths(int age){
        return age*12;
    }

    public double computeQuotient(double x, double y){
        return x/y;
    }

    public static void main(String[] args){
        Scanner  bill = new Scanner(System.in);

        try{
            System.out.println("What is your name?");
            bill.next();
            System.out.println("How old are you?");
            int age = bill.nextInt();
            System.out.println("Where do you live?");
            String home = bill.next();
            System.out.println("When you grow, you want to be...?");
            String job = bill.next(); 
            System.out.println("What are your 2 favorite integers?(Enter them separated with a space)");
        } finally{
            bill.close();
        }
    }
}
