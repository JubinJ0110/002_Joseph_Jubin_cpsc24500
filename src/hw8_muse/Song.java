package hw8_muse;
import java.util.LinkedHashMap;
public class Song extends RecordedArtisticWork {
    private int bpm;  // beats per minute
    private String key;
    public int getBPM() {
        return bpm;
    }
    public void setBPM(int bpm) {
        if (bpm < 0) {
            this.bpm = 0;
        } else {
            this.bpm = bpm;
        }
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;   // could add checking for valid key
    }
    public Song() {
        key = "Cmaj";
        bpm = 120;
    }
    public Song(String creator, String date, String title, String description,
            int duration, String fileName, double fileSize, int bpm, String key) {
        super(creator,date,title,description,duration,fileName,fileSize);
        setBPM(bpm);
        setKey(key);
    }
    public Song(LinkedHashMap<String,String> settings) {
        super(settings);
        setBPM(Integer.parseInt(settings.get("bpm")));
        setKey(settings.get("key"));
    }
    @Override
    public String getType() {
        return "song";
    }
    @Override
    public String getSpecificInfoString() {
        return String.format("%d bpm, key of %s", bpm,key);
    }
}
