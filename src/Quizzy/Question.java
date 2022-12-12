package Quizzy;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Question {
    private String question;
    private String theAnswer;
    private ArrayList<String> answers = new ArrayList<String>();
    private static ArrayList<Question> quiz = new ArrayList<Question>();
    
    public void setQuestion(String q){
        question = q;

    }
    public void setAnswers(ArrayList<String> a){
        answers = a;
    }
    public void setRightAnswer(String r){
        theAnswer = r;
    }

    public String getQuestion(){
        return question;
    }
    public ArrayList<String> getAnswers(){
        return answers;
    }
    public String getTheAnswer(){
        return theAnswer;
    }

    public Question(){
        setQuestion("");
        setAnswers(new ArrayList<String>());
        setRightAnswer("");
    }
    public Question(String q, ArrayList<String> choices, String rightOne){
        setQuestion(q);
        setAnswers(choices);
        setRightAnswer(rightOne);
    }

    @Override
    public String toString(){
        return "";
    }

    public static ArrayList<Question> importQuiz(File teacher){
        Scanner scantron = new Scanner(System.in);
        String line;
        String[] parts;
        ArrayList<String> tempChoices = new ArrayList<String>();

        try {
            while(scantron.hasNextLine()){
                line = scantron.nextLine().trim();
                parts=line.split("\t");
                for(int i=1;i<length(parts)-1;i++){
                    if(i==1){
                        tempChoices.add("A.\t"+parts[i]);
                    }else if (i==2){
                        tempChoices.add("B.\t"+parts[i]);
                    }else if (i==3){
                        tempChoices.add("C.\t"+parts[i]);
                    }else if (i==4){
                        tempChoices.add("D.\t"+parts[i]);
                    }
                }
                Question question = new Question(parts[0],tempChoices,parts[length(parts)-1]);
                quiz.add(question);
                tempChoices.clear();
            }
            scantron.close();
            return quiz;
        } catch (Exception wrong) {
            return null;
        }
    }
    private static int length(String[] parts) {
        return 0;
    }
}
