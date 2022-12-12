package hw8_muse;

public class Comment {
    private String postedBy;
    private String dateTime;
    private String content;

// getters and setters for comment data
    public String getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

// comment constructors
    public Comment() {
        postedBy = "";
        dateTime = "";
        content = "";
    }
    public Comment(String postedBy, String dateTime, String content) {
        setPostedBy(postedBy);
        setDateTime(dateTime);
        setContent(content);
    }
    @Override
    public String toString() {
        return String.format("On %s, %s commented ...\n\t\"%s\"", dateTime, postedBy, content);
    }
}
