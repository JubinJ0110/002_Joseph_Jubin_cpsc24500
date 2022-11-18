package Menagerie;
import java.util.Random;

public class Fish extends Pet {
    Random petBrain = new Random();
    private int brain;
    
    public Fish(){
        super("Un-named", 1, 1);
    }
    public Fish(String n, double w, int a){
        super(n,w,a);
    }

    public String getType(){
        return "Fish";
    }

    @Override
    public String toString(){
        return super.toString();
    }

// Act function for fishes
    public String act(){
        brain = petBrain.nextInt(10);
        if (brain<2){
            return "The fish, "+super.getPetName()+", was sleepy and tooke a nap.";
        }else if(brain<3){
            return "The fish, "+super.getPetName()+", was hungry and ate some food.";
        }else if(brain<10){
            brain = petBrain.nextInt(10);
            if (brain<2){
                return "The fish, "+super.getPetName()+", swam around.";
            }else if(brain<4){
                return "The fish, "+super.getPetName()+", made some bubbles.";
            }else if(brain<6){
                return "The fish, "+super.getPetName()+", played with the pebbles in the tank.";
            }else if(brain<8){
                return "The fish, "+super.getPetName()+", swan around the plants.";
            }else if(brain<10){
                return "The fish, "+super.getPetName()+", puts their on the glass.";
            }
        }
        return "";
    }
}
