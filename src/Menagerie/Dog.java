package Menagerie;
import java.util.Random;

public class Dog extends Pet {
    Random petBrain = new Random();
    private int brain;

    public Dog(){
        super("Un-named", 1, 5);
    }
    public Dog(String n, double w, int a){
        super(n,w,a);
    }

    public String getType(){
        return "Dog";
    }

    @Override
    public String toString(){
        return super.toString();
    }

// Act function for dogs
    public String act(){
        brain = petBrain.nextInt(10);
        if (brain<2){
            return "The dog, "+super.getPetName()+", was sleepy and took a nap.";
        }else if(brain<4){
            return "The dog, "+super.getPetName()+", was hungry and ate some food.";
        }else if(brain<10){
            brain = petBrain.nextInt(10);
            if (brain<2){
                return "The dog, "+super.getPetName()+", played with a ball.";
            }else if(brain<4){
                return "The dog, "+super.getPetName()+", chatted with some other dogs";
            }else if(brain<6){
                return "The dog, "+super.getPetName()+", chewed up some toys and was a little silly.";
            }else if(brain<8){
                return "The dog, "+super.getPetName()+", was incredibly photogenic.";
            }else if(brain<10){
                return "The dog, "+super.getPetName()+", wanted to go for a walk.";
            }
        }
        return "";
    }
}
