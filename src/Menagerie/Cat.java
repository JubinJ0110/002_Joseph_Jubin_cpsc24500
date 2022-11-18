package Menagerie;
import java.util.Random;

public class Cat extends Pet {
    Random petBrain = new Random();
    private int brain;
    
    public Cat(){
        super("Un-named", 1, 5);
    }
    public Cat(String n, double w, int a){
        super(n,w,a);
    }

    public String getType(){
        return "Cat";
    }

    @Override
    public String toString(){
        return super.toString();
    }

// Act function for cats
    public String act(){
        brain = petBrain.nextInt(10);
        if (brain<3){
            return "The cat, "+super.getPetName()+", was sleepy and tooke a nap.";
        }else if(brain<5){
            return "The cat, "+super.getPetName()+", was hungry and ate some food.";
        }else if(brain<10){
            brain = petBrain.nextInt(10);
            if (brain<2){
                return "The cat, "+super.getPetName()+", played with some yarn.";
            }else if(brain<4){
                return "The cat, "+super.getPetName()+", left";
            }else if(brain<6){
                return "The cat, "+super.getPetName()+", scratched up a scratch post, or your couch.";
            }else if(brain<8){
                return "The cat, "+super.getPetName()+", layed on your lap.";
            }else if(brain<10){
                return "The cat, "+super.getPetName()+", caused trouble.";
            }
        }
        return "";
    }
}
