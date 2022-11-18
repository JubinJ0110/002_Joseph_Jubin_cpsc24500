package Menagerie;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PetWriter {

// Function to print pets to screen/terminal window
    public static void printPets(ArrayList<Pet> litter){
        for (Pet p:litter){
            System.out.println(p);
        }
    }

// Function to write pets to a file on the users computer
    public static boolean writePetsToComputer(ArrayList<Pet> litter, String fFname){
        try {
            PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(new File("c:\\temp\\"+fFname))));
            for (Pet p:litter){
                printer.println(p);
            }
            printer.close();
            return true;
        } catch (Exception e) {
            
            return false;
        }
    }
}