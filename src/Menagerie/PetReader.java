package Menagerie;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class PetReader {

// Function to read a tab delimitted Pet file into menagerie
    public static ArrayList<Pet> petReader(String litterName){
        String line;
        String fName;
        String lines[];
        ArrayList<Pet> litter = new ArrayList<Pet>();
        boolean works=false;
        Scanner fScanner = new Scanner(System.in);

        while(!works){
            try{
                File litterFile = new File("c:\\temp\\"+litterName);
                Scanner furballScanner = new Scanner(litterFile);
                while(furballScanner.hasNextLine()){
                    lines = furballScanner.nextLine().split("\t");
                    if(lines[0].equals("Dog")){
                        Dog dog = new Dog(lines[1], Double.parseDouble(lines[2]), Integer.parseInt(lines[3]));
                        litter.add(dog);
                    }else if(lines[0].equals("Cat")){
                        Cat cat = new Cat(lines[1], Double.parseDouble(lines[2]), Integer.parseInt(lines[3]));
                        litter.add(cat);
                    }else if(lines[0].equals("Fish")){
                        Fish fish = new Fish(lines[1], Double.parseDouble(lines[2]), Integer.parseInt(lines[3]));
                        litter.add(fish);
                    }
                }
                furballScanner.close();
            } catch(Exception oops){
                System.out.print("An error occurred reading the file, try again: ");
                fName = fScanner.nextLine();
                litterName=fName;
            }
        }

        return litter;
    } 
}
