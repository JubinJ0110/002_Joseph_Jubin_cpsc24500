package Menagerie;

public abstract class Pet {
    private String petName;
    private double weight;
    private int age;

// Make getters and setters
    public String getPetName(){
        return petName;
    }
    public double getWeight(){
        return weight;
    }
    public int getAge(){
        return age;
    }

    public void setPetName(String p){
        petName = p;
    }
    public void setWeight(double w){
        weight = w;
    }
    public void setAge(int a){
        age = a;
    }

// Main constructor for all inheriting classes
    public Pet(){
        setPetName("Un-named");
        setAge(1);
        setWeight(5.0);
    }
    public Pet(String n, double w, int a){
        setPetName(n);
        if(a>0)
            setAge(a);
        else{
            setAge(1);
        }
        
        if(w>0){
            setWeight(w);
        }else{
            setWeight(5.0);
        }
    }

// Abstract functions for inheriting pet classes to make
    public abstract String getType();
    public abstract String act();
    

// toString function for all Pet classes
    @Override
    public String toString(){
        return String.format("%s\t%s\t%d\t%.2f", getType(),getPetName(), getAge(), getWeight());
    }

}
