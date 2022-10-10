package CellPhoneOrderingSystem;
import java.util.Scanner;

public class App {

    public static String intro(){
        String intro = """
**************************************************
       Corporate Cell Phone Ordering System
**************************************************

Welcome to the corporate cell phone ordering system.
Here you can order multiple phones of different kinds
with various addons for your employees.
                """;

        return intro;
    }
    public static void main(String[] args) {
        Scanner cellScanner = new Scanner(System.in);
        int phoneNum;
        double total = 0;
        double actualTotal = 0;
        String bigString = "";
        String brand;
        int size;
        int storage;
        String choice = "";

         System.out.println(intro());

        System.out.print("How many phones will you purchase? ");
        phoneNum = cellScanner.nextInt();
        
        for(int i = 1;i<=phoneNum;i++){
            System.out.println("\nLet's configure phone #" + i + " ...");
            System.out.print("Enter A for Android or I for IPhone: ");
            brand = cellScanner.nextLine();
            
            if (i == 1){
                brand = cellScanner.nextLine();
            }
            
            if (brand.equals("A")){
                total += 799;
                bigString += "Android ";
            } else if (brand.equals("I")){
                total += 849;
                bigString += "IPhone ";
            }

            System.out.print("What size screen? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
            size = cellScanner.nextInt();
            if (size==1){
                total+=0;
                bigString += "5.6\" ";
            } else if(size==2){
                total = total + .2*total;
                bigString += "6.2\" ";
            } else if(size==3){
                total = total + .4*total;
                bigString += "6.7\" ";
            }

            System.out.print("How much storage? Enter 64, 128, or 256: ");
            storage = cellScanner.nextInt();
            choice = cellScanner.nextLine();
            if (storage==64){
                total += 0;
                bigString += "64GB ";
            } else if (storage==128){
                total += 100;
                bigString += "128GB ";
            } else if (storage==256){
                total += 250;
                bigString += "256GB ";
            }

            while (!(choice.equals("F"))){
                System.out.println("""
        What add-ons do you want?
            [C]ase ($49)
            [S]creen protector ($15)
            [E]ar buds ($99)
            [W]ireless charger ($59)
            [F]inish order""");
                System.out.print("Enter the letter of your choice: ");
                choice = cellScanner.nextLine();
                if (choice.equals("C")){
                    total += 49;
                    bigString += "/ case ";
                } else if (choice.equals("S")){
                    total += 15;
                    bigString += "/ screen protector ";
                } else if (choice.equals("E")){
                    total += 99;
                    bigString += "/ ear buds ";
                } else if (choice.equals("W")){
                    total += 59;
                    bigString += "/ wireless charger ";
                }
            }
            bigString += " ($" + total + ")\n";
            actualTotal += total;
            total = 0;
                
        }

        System.out.println("\nHere is the summary of your order:\n" + bigString);
        System.out.printf("Your total cost is: $%.2f\n\nThank you for your order.", actualTotal);

        
    }
    
}
