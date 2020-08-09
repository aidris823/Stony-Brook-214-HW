//Stores all SongRecords in a particular playlist

public class Playlist {
    private SongRecord[] files;

    public Playlist() {
        int MAX_SONGS = 50;
        files = new SongRecord[MAX_SONGS];
    }

    public Object clone() throws CloneNotSupportedException {
        Playlist pl = (Playlist) super.clone();
        return pl;
    }

    //Checks if this class is the same as another Playlist
    public boolean equals(Object obj) {
        if (!(obj instanceof Playlist)) {
            return false;
        }
        SongRecord[] compFiles = ((Playlist) obj).getFiles();
        for (int i = 0; i < 50; i++) {
            if (!getFiles()[i].equals(compFiles[i])){
                return false;
            }
        }
        return true;
    }

    public SongRecord[] getFiles(){
        return files;
    }
    //Returns number of non-empty song entries are in the playlist.
    public int size(){
        int ans = 0;
        for (int i = 0; i < files.length; i++){
            if (!files[i].isEmpty()){
                ans++;
            }
        }
        return ans;
    }

    //Adds/replaces a song between position 1 and 51
    public void addSong(SongRecord song, int position) throws IllegalArgumentException, FullPlaylistException {
        if (position < 1 || position > 51 || position > size() + 1){
            throw new IllegalArgumentException("Invalid position to place song");
        }
        if (getFiles().length > 50){
            throw new FullPlaylistException("Song Playlist Full");
        }
        if (position - 1 > size()) {
            throw new IllegalArgumentException("Value placed ahead of valid spot.");
        }
        int size = size();
        for (int i = position - 1; i < size; i++) {
            files[i+1] = files[i];
        }
        files[position] = song;
    }


    //Removes a song at a particular position
    public void removeSong(int position) throws IllegalArgumentException{
        if (position < 1 || position > 51 || position - 1 >= size()){
            throw new IllegalArgumentException("Invalid position to remove song");
        }
        int size = size();
        for (int i = position - 1; i < size; i++){
            files[i] = files[i+1];
        }
    }
    //Gives you a song at a certain position
    public String getSong(int position) throws IllegalArgumentException{
        if (position < 1 || position > 51){
            throw new IllegalArgumentException("Invalid position to remove song");
        }
        return files[position - 1].toString();
    }
    //Returns all songs in the playlist
    public void printAllSongs(){
        int size = size();
        for (int i = 0; i < size;i++){
            System.out.println("Entry Number: " + i);
            System.out.println("Title: " + files[i].getTitle());
            System.out.println("Artist: " + files[i].getArtist());
            System.out.println("Minutes: " + files[i].getMins());
            System.out.println("Seconds: " + files[i].getSecs());
            System.out.println("\n ----------------------------- \n");
        }
    }
    //Returns all song by an artist

    public Playlist getSongsByArtist(Playlist originalList, String artist) throws IllegalArgumentException, FullPlaylistException{
        Playlist newList = new Playlist();
        SongRecord[] allSongs = originalList.getFiles();
        int j = 0;
        int size = originalList.size();
        for (int i = 0; i < size; i++) {
            if (allSongs[i].getArtist().equals(artist)) {
                newList.addSong(allSongs[i], j);
                j++;
            }
        }
        if (newList.size() == 0) {
            return null;
        }
        return newList;
    }
    /*
     */

    //Returns all SongRecords for this Playlist
    public String toString() {
        String ans = "";
        int size = size();
        for (int i = 0; i < size; i++){
            ans += files[i].toString();
            ans += "\n";
        }
        return ans;
    }

    //

}
