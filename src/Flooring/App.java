package Flooring;

public class App {
    public static void main(String[] args){
        int bigBoxArea = 25*7;
        int smallBoxArea = 8*8;
        int triangleArea = (8*9)/2;
        int plankArea = 1;

        int  totalArea = bigBoxArea + smallBoxArea + triangleArea;
        double planksNeeded = (Math.ceil(totalArea+((double)totalArea*.25)))/plankArea;
        double boxesNeeded = Math.ceil(planksNeeded/8);
        double price = 24.99 * boxesNeeded;

        System.out.printf("Number of packages needed to fill the floor: %d", (int)boxesNeeded);
        System.out.println();
        System.out.printf("Total Cost: $%.2f", price);

        

    }
    
}
