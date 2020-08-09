/* SongRecord is a record for a single audio file.
Maintains:
1. Title
2. Artist
3. Minutes of song
4. Seconds of song

Get and Set functions ofc
Constructor is just default

Throws exception if mins of song is negative or if seconds of song is negative or > 59
 */
public class SongRecord {
    //Internal variables
    private String title;
    private String artist;
    private int mins;
    private int secs;

    //Constructor
    public SongRecord(){
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public void setMins(int mins) throws Exception {
        if (mins < 0){
            throw new Exception("Minutes cannot be negative");
        }
        this.mins = mins;
    }
    public void setSecs(int secs) throws Exception{
        if (secs < 0 || secs > 59){
            throw new Exception("Seconds must be between 0 and 59");
        }
        this.secs = secs;
    }

    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public int getMins(){
        return mins;
    }
    public int getSecs(){
        return secs;
    }

    //Checks if this SongRecord is equal to another SongRecord
    //Returns true if the argument is a SongRecord and all its variables match.
    public boolean equals(Object obj){
        if (!(obj instanceof SongRecord)){
            return false;
        }
        SongRecord compObj = (SongRecord) obj;
        if (isEmpty() && compObj.isEmpty()){
            return true;
        }
        return (getArtist().equals(compObj.getArtist())
        && getTitle().equals(compObj.getTitle())
        && getMins() == compObj.mins
        && getSecs() == compObj.secs);
    }
    public String toString(){
        String output = "Title: "+ title + "\n Artist: "
                + artist + "\n Minutes: " +
                String.valueOf(mins) + "\n Seconds: " +
                String.valueOf(secs);
        return output;
    }
    //Returns if this SongRecord does not have a song associated with it.
    public boolean isEmpty(){
        return title == null && artist == null && mins == 0 && secs == 0;
    }


}
