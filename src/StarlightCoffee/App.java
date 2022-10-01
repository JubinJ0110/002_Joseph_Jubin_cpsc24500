package StarlightCoffee;
import java.util.Scanner;

public class App {

// Intro function
    public static String intro(){
        String intro = ("""
*-----------------------------------*
Starlight Coffee Point-of_Sale System
*-----------------------------------*
                """);
        return intro;
    }

// Return bill function
    public static String starlightBill(double coffPrice, String StarMem, double tipPrice, double totalPrice, String name){
        System.out.println("Here's your bill, " + name + ":");
        if (StarMem.equals("n")){
            double taxes = coffPrice*.0875;
            System.out.printf("Beverage:   $%5.2f\n",coffPrice);
            System.out.printf("Tip Amount: $%5.2f\n",tipPrice);
            System.out.printf("Taxes:      $%5.2f\n",taxes);
            totalPrice += coffPrice+tipPrice+taxes;
            System.out.printf("Total:      $%5.2f\n\n",totalPrice);
            System.out.println("Thanks for coming to Starlight Coffee, enjoy the brew!");


        } else if (StarMem.equals("y")){
            double taxes = (coffPrice-(coffPrice*.1))*.0875;
            System.out.printf("Beverage:        $%5.2f\n",coffPrice);
            System.out.printf("Club Discount:   $%5.2f\n", coffPrice*.1);
            System.out.printf("Tip Amount:      $%5.2f\n",tipPrice);
            System.out.printf("Taxes:           $%5.2f\n",taxes);
            totalPrice += coffPrice+tipPrice-(coffPrice*.1)+taxes;
            System.out.printf("Total:           $%5.2f\n\n",totalPrice);
            System.out.println("Thanks for coming to Starlight Coffee, enjoy the brew!");
        }
        
        return "";
    }

    public static void main(String[] args){
        
        Scanner StarScanner = new Scanner(System.in);
        double totalPrice = 0;

        System.out.println(intro());
        System.out.println("What is your name?");
        String name = StarScanner.nextLine();

// Code for printing and receiving input for coffee order
        System.out.println();
        System.out.println("""
What kind of coffee do you want?
1. Americano:  $2.25
2. Italiano:   $2.75
3. Espresso:   $3.50
4. Cappuccino: $3.75""");
        System.out.print("Please type the number of your choice:");
        int coff = StarScanner.nextInt();
        System.out.println();
        double coffp = 0;

// Assign cost to drink number
        if (coff == 1){
            coffp = 2.25;
        } else if(coff == 2){
            coffp = 2.75;
        } else if(coff == 3){
            coffp = 3.50;
        } else if(coff == 4){
            coffp =3.75;
        } else{
            System.out.println("That is not a valid input");
        }

// What size drink does the user want
        int size;

        System.out.print("""
What size do you want?
1. Tall    ---
2. Grande  +20%
3. Venti   +40%
Enter the number of your choice:  """);
        size = StarScanner.nextInt();
        System.out.println();

// Calc additional price if any for that size
        if (size == 1){
            coffp = coffp+0;
        } else if(size == 2){
            coffp = coffp + coffp*.2;
        } else if(size == 3){
            coffp = coffp + coffp*.4;
        } else{
            System.out.println("That is not a valid input");
        }

// How many expresso shots would the user like, get price of all shots
        int expressoc = 0;
        System.out.print("How many shots of expresso would ya like(Each one is 50 cents)? ");
        expressoc = StarScanner.nextInt();
        System.out.println();
        double expressop = (double)expressoc*.5;

// Is the user a Starlight star member
        String StarMem = "";
        System.out.print("Are you a Starlights Stars member(Answer y or n)? ");
        StarMem = StarScanner.nextLine();
        StarMem = StarScanner.nextLine();    
        System.out.println();    

// Get desired tip amount
        int tip = 0;
        System.out.print("""
What size tip would you like to leave?
1. Good service - 10%
2. Great service - 15%
3. Outstanding service - 20%
Enter the number of your choice:""");
        tip = StarScanner.nextInt();
        System.out.println();
        coffp = coffp + expressop;

// Calc tip amount relative to the cost of the drink
        double tipp = 0;
        if (tip == 1){
            tipp = coffp*.1;
        } else if(tip == 2){
            tipp = coffp*.15;
        } else if(tip == 3){
            tipp = coffp*.2;
        } else{
            System.out.println("That is not a valid input");
        }
        
// Call bill function and end program
        starlightBill(coffp,StarMem,tipp,totalPrice,name);

    }  

}
