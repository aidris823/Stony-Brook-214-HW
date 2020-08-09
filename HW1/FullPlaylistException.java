public class FullPlaylistException extends Exception{
    private String message;
    public FullPlaylistException(String message){
        this.message = message;
    }
    public String toString(){
        return message;
    }

}
