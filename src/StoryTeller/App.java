package StoryTeller;
import java.util.Scanner;

import javax.xml.validation.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

// Function for the introduction
public class App {
    public static String intro(){
        String intro = """
****************************************************
                STORYTELLER V1.0
****************************************************

Welcome to StoryTeller, a sophisticated electronic
author. This program reads from a list of words of
various parts of speech and creates a story from
them. You can tune the richness of the writing by
changing how frequently adjectives, adverbs, and
prepositions should be included.
                
""";
        return intro;
    }
// Function for reading the file into memory and generating an array list withh all words
    public static ArrayList<String> WordFileReader(String bookName, Scanner authorReader,ArrayList<String> words){
        boolean works = false;
        
        while(!works){
            try{
                File book = new File("/Users/joob/LewisUniversity/OOP/hw_repo/src/StoryTeller/"+bookName);
                Scanner fBallScanner = new Scanner(book);
                while(fBallScanner.hasNextLine()){
                    words.add(fBallScanner.nextLine());
                }
                fBallScanner.close();
                works = true;
            } catch(Exception oops){
                System.out.print("An error occurred reading the file, try again: ");
                bookName = authorReader.nextLine();
            }
        }
        
        return words;
        
    }

// Function for writing each line for the story
    public static String Author(ArrayList<String> n,ArrayList<String> v,ArrayList<String> adj,ArrayList<String> adv,ArrayList<String> prep, int LineNum, int adjNum, int advNum, int prepNum, String theStory){
        Random actualAuthor = new Random();
        int x;
        for(int i=1;i<=LineNum;i++){
            theStory += "The ";

            x = actualAuthor.nextInt(10)+1;
            if (x>=1 && x<=adjNum){
                x=actualAuthor.nextInt(adj.size());
                if(x==adj.size()){
                    x--;
                }
                theStory += adj.get(x)+" ";
            }
            System.out.println("yo");

            x = actualAuthor.nextInt(n.size());
            if(x==n.size()){
                x--;
            }
            theStory += n.get(x)+" ";
            System.out.println("yp");

            x = actualAuthor.nextInt(v.size());
            if(x==v.size()){
                x--;
            }
            theStory += v.get(x)+" ";
            System.out.println("yc");

            x = actualAuthor.nextInt(10)+1;
            if (x>=1 && x<=advNum){
                x=actualAuthor.nextInt(adv.size());
                if(x==adv.size()){
                    x--;
                }
                theStory += adv.get(x)+" ";
            }
            System.out.println("yv");

            x = actualAuthor.nextInt(10)+1;
            if (x>=1 && x<=prepNum){
                x=actualAuthor.nextInt(adj.size()-2);
                if(x==adj.size()){
                    x--;
                }
                theStory += prep.get(x)+" the ";
                System.out.println("yb");

                x = actualAuthor.nextInt(n.size());
                if(x==adj.size()){
                    x--;
                }
                theStory += n.get(x)+" ";
                System.out.println("ym");
            }
            theStory+="\n";

        }
        
        return theStory;
    }
    public static void main(String[] args){
        Scanner authorReader = new Scanner(System.in);
        String bookName;
        String input = "y";
        int lineNum;
        int adjNum;
        int advNum;
        int prepNum;
        String theStory = "";
        ArrayList <String> n = new ArrayList<String>();
        ArrayList <String> v = new ArrayList<String>();
        ArrayList <String> adj = new ArrayList<String>();
        ArrayList <String> adv = new ArrayList<String>();
        ArrayList <String> prep = new ArrayList<String>();
        ArrayList <String> words = new ArrayList<String>(); 

        System.out.print(intro());
        System.out.print("Enter the name of the wordfile: ");
        bookName = authorReader.nextLine();
        boolean works = false;

        while (!works){
                words = WordFileReader(bookName,authorReader,words);
                works=true;
        }

// Separating words list into lists for nouns, prepositions, verbs, adverbs, and adjectives
        String[] parts;
        for(String word:words){
            parts = word.split(" ");
            
            if (parts[1].equals("n")){
                n.add(parts[0]);
            } else if(parts[1].equals("v")){
                v.add(parts[0]);
            }else if(parts[1].equals("adj")){
                adj.add(parts[0]);
            }else if(parts[1].equals("adv")){
                adv.add(parts[0]);
            }else if(parts[1].equals("prep")){
                prep.add(parts[0]);
            }
        }        

// Receive user input on what the user wants for the story
        while (input.equals("y")){
            System.out.print("\nHow many sentences would you like in your story: ");
            lineNum = authorReader.nextInt();
            System.out.println("On a scale of 0 to 10 ...");
            System.out.print("\tHow frequently should adjectives be used? ");
            adjNum = authorReader.nextInt();
            System.out.print("\tHow frequently should adverbs be used? ");
            advNum = authorReader.nextInt();
            System.out.print("\tHow frequently should prepositions be used? ");
            prepNum = authorReader.nextInt();

            theStory = Author(n, v, adj, adv, prep, lineNum, adjNum, advNum, prepNum, theStory);
            System.out.println("Here it is:");
            System.out.println(theStory);
            System.out.print("Would you like another story (y or n)? ");
            input = authorReader.nextLine();

// Asks if user wants another story
            works = false;
            while(!works){
                input = authorReader.nextLine();
                if (!(input.equals("n") || input.equals("y"))){
                    System.out.println("That wasn't a y or n. Would you like another story: ");
                    input = authorReader.nextLine();
                }else {
                    works = true;
                }
            }

            System.out.println("Thanks for using Storyteller!");

        }


    }
    
    
}
