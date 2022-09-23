package WebPageBuilder;
import java.util.Scanner;

public class WebPageBuilder {

    public static int computeAgeInMonths(int age){
        return age*12;
    }

    public static double computeQuotient(double x, double y){
        return x/y;
    }

    public static void main(String[] args){
        Scanner  ScanMan = new Scanner(System.in);

        System.out.println("""
*---------------------------------*
|         Web Builder V1.0        |
*---------------------------------*
This applications helps you build a 
basic static web page by asking you
a series of simple questions. We'll
generate your site using each 
response.
                """);

        System.out.println("What is your name?");
        String name = ScanMan.nextLine();
        System.out.println("How old are you?");
        int age = ScanMan.nextInt();
        System.out.println("Where do you live?");
        String home = ScanMan.nextLine();
        home = ScanMan.nextLine();
        System.out.print("When you grow, you want to be... ");
        String job = ScanMan.nextLine(); 
        System.out.println("What are your 2 favorite integers?(Enter them separated with a space)");
        double num1 = ScanMan.nextDouble();
        double num2 = ScanMan.nextDouble();          

        double quotient = computeQuotient(num1,num2);
        int ageInMonths = computeAgeInMonths(age);

        System.out.println("\n<html>");
        System.out.printf("<head><title>%s's Web Page</title></head>\n", name);
        System.out.println("<body>");
        System.out.printf("<h1>Welcome to %s's Web Page</h1>\n", name);
        System.out.printf("<p>I am %d(%d months old!) old and I live in %s.</p>\n", age,ageInMonths,home);
        System.out.printf("<p>When I grow up I want to be %s</p>\n",job);
        System.out.printf("<p>My two favorite numbers are %d and %d. Their quotient is %.3f</p>\n", (int)num1, (int)num2, quotient);
        System.out.println("<p>Thanks for visiting my page, have dandy day!</p>");
        System.out.println("</body>");
        System.out.println("</html>");
    }
}
