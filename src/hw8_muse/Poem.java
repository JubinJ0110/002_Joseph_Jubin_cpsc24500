package hw8_muse;

import java.util.LinkedHashMap;

public class Poem extends WrittenArtisticWork {
    private String meter;
    public String getMeter() {
        return meter;
    }
    public void setMeter(String meter) {
        this.meter = meter;
    }
    public Poem() {
        meter = "N/A";
    }
    public Poem(String creator, String date, String title, String description,
            String language, String text, String meter) {
        super(creator,date,title,description,language,text);
        setMeter(meter);
    }
    public Poem(LinkedHashMap<String,String> settings) {
        super(settings);
        setMeter(settings.get("meter"));
    }
    @Override
    public String getType() {
        return "poem";
    }
    @Override
    public String getSpecificInfoString() {
        return String.format("Meter: %s\n%s", meter, super.getSpecificInfoString());
    }
}
