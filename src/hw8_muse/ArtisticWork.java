package hw8_muse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.io.Serializable;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.ObjectOutputStream;

@SuppressWarnings("unchecked")
public abstract class ArtisticWork implements Serializable{
    private String creator;
    private String date;
    private String title;
    private String description;
    private ArrayList<Comment> comments;

// getter and Setters for all artistic works
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

// Constructors for artistic works
    public ArtisticWork() {
        date = "1/1/1900";
        title = "title";
        creator = "anonymous";
        description = "description";
        comments = new ArrayList<Comment>();
    }
    public ArtisticWork(String creator, String date, String title, String description) {
        setCreator(creator);
        setDate(date);
        setTitle(title);
        setDescription(description);
        comments = new ArrayList<Comment>();
    }
    public ArtisticWork(LinkedHashMap<String,String> settings) {
        this(settings.get("creator"),settings.get("date"),settings.get("title"),settings.get("description"));
    }

// Abstract functions for child classes to write & toString function components
    public abstract String getType();
    public String getGeneralInfoString() {
        return String.format("%s, a %s by %s, posted on %s",title,getType(),creator,date);
    }
    public abstract String getSpecificInfoString();
    public String getCommentsAsString() {
        String result = "";
        for (Comment comment : comments) {
            result = result + comment + "\n";
        }
        if (result.isBlank()) {
            return "No comments";
        }
        return result;
    }

// toString function
    @Override
    public String toString() {
        return getGeneralInfoString() + "\n" + getSpecificInfoString() + "\nComments: \n" + getCommentsAsString();
    }

// function for adding comments to each work
    public void addComment(String postedBy, String date, String content) {
        Comment comment = new Comment(postedBy, date, content);
        comments.add(comment);
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public String getShortString() {
        return String.format("\"%s\", a %s by %s", title, getType(), creator);
    }

    public static boolean writeToBinary(ArrayList<ArtisticWork> works, String albumName){
        try {
            FileOutputStream streamer = new FileOutputStream(new File(albumName));
            ObjectOutputStream oStreamer = new ObjectOutputStream(streamer);
            oStreamer.writeObject(works);
            oStreamer.close();
            return true;
        } catch (Exception oops) {
            return false;
        }
    }
    public static Arraylist<ArtisticWork> readFromBinary(String albumName){
        try {
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(new File(albumName)));
            ArrayList<ArtisticWork> works = (Arraylist<ArtisticWork>)objectIn.readObject();
            objectIn.close();
            return works;
        } catch (Exception e) {
            return null;
        }
    }
    public static boolean writeToXML(ArrayList<ArtisticWork> works, String albumName){
        try {
            XMLEncoder expensivEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(albumName))));
            expensivEncoder.writeObject(works);
            expensivEncoder.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static ArrayList<ArtisticWork> readFromXML(String albumName){
        try {
            XMLDecoder expensivDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(new File(albumName))));
            ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)expensivDecoder.readObject();
            expensivDecoder.close();
            return works;
        } catch (Exception e) {
            return null;
        }
    }
}
