package Menagerie;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args){
// Initialize all needed variables
        Scanner petReader = new Scanner(System.in);
        Random petBrain = new Random();
        int brain;
        int choice;
        String petType;
        String petStat;
        boolean notSeven = true;
        boolean doesWrite = true;
        boolean works=false;
        ArrayList<Pet> litter = new ArrayList<Pet>();
        String name;
        int age;
        double weight;
        String[] parts;
        String petFName;
        String litterName;
        int hour;

// Print Intro
        System.out.println("""
************************************************************
             Menagerie V1.0: The Pet Simulator
************************************************************

""");

// While for entire app experience
        while (notSeven){
            System.out.println("""
What would you like to do?
1. Add a new pet.
2. Print list of pets.
3. Save pets to a file.
4. Load pets from a file.
5. Simulate a day in the life of your pets.
6. Clear your list of pets.
7. Exit""");

            System.out.print("Enter the number of your choice: ");
            choice = petReader.nextInt();

            if(choice==1){
// Retrives data from user for what type of pet to make and all related data
                System.out.print("Enter d for dog, c for cat, or f for fish: ");
                petType=petReader.nextLine();
                petType=petReader.nextLine();
                System.out.print("Enter name, age, and weight: ");
                petStat = petReader.nextLine();
                parts=petStat.split(" ");
                
                name=parts[0];
                age=Integer.parseInt(parts[1]);
                weight=Double.parseDouble(parts[2]);
// Separates between type and adds to the ArrayList of pets(litter)
                if (petType.equals("d")){
                    Dog dog = new Dog(name,weight,age);
                    litter.add(dog);
                } else if(petType.equals("c")){
                    Cat cat = new Cat(name,weight,age);
                    litter.add(cat);
                } else if (petType.equals("f")){
                    Fish fish = new Fish(name,weight,age);
                    litter.add(fish);
                }

            }else if(choice==2){
// Prints pets to screen choice
                System.out.println("\nHere is your list of pets:");
                PetWriter.printPets(litter);
                System.out.println();
            }else if(choice==3){
// Choice for saving pets data to a file
                System.out.print("Enter name of file to save: ");
                petFName = petReader.nextLine();
                petFName = petReader.nextLine();
// while function in case of errors
                while(!works){
                    if (PetWriter.writePetsToComputer(litter, petFName)){
                        System.out.println("The pets were saved to the file");
                        works=true;
                    }else {
                        System.out.print("The pets were not saved to a file, please enter the file name again: ");
                        petFName = petReader.nextLine();
                    }
                }
            }else if(choice==4){
// Choice for loading pets into ArrayList from a file
                System.out.print("\nEnter the name of the file to load: ");
                litterName = petReader.nextLine();
                litterName = petReader.nextLine();
                litter = PetReader.petReader(litterName);
            }else if (choice==5){
// Choice for simulating a day in the life of the pets
                if(litter.size()==0){
                    System.out.println();
                }else{
                    System.out.println("Here is a simulation in a day of the life of your pet(s):");
                    for(hour=1;hour<25;hour++){
                        System.out.println("\nHOUR "+hour+"\n-------");
                        for (Pet p:litter){
                            for(brain=petBrain.nextInt(3);brain>-1;brain--){
                                System.out.println(p.act());
                            }
                        }
                    }
                }
                System.out.println();
            }else if (choice==6){
// Clears pets ArrayList
                litter.clear();
            }else if (choice==7){
// Quits
                notSeven=false;
            }
    }

    System.out.println("\nThank you for using Menagerie. We hope you had fun.");
    
}
}