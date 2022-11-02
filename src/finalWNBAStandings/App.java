package finalWNBAStandings;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class App {
    
    public static String intro(){
        return """
***************************************************
               2022 WNBA STANDINGS
***************************************************
           
""";
    }

    public static void main(String[] arge){
        Scanner inputScanner = new Scanner(System.in);
        String fName;
        String line;

        System.out.println(intro());
        System.out.print("Enter the standings filename: ");
        
        fName = inputScanner.nextLine();
        System.out.println(fName);
        boolean works = false;

        while (!works){
            try{
                File book = new File("/Users/joob/LewisUniversity/OOP/hw_repo/src/finalWNBAStandings/"+fName);
                System.out.println("ho");
                Scanner fBallScanner = new Scanner(book);
                System.out.println("jo");
                while(fBallScanner.hasNextLine()){
                    System.out.println(fBallScanner.nextLine());
                }
                fBallScanner.close();
                works = true;
            } catch (Exception oops){
                System.out.println("An error occurred reading the file, try again: ");
                fName = inputScanner.nextLine();
            }
        }
        
        
        

    }
}
