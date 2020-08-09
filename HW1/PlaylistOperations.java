import java.util.Scanner;
public class PlaylistOperations {
    public PlaylistOperations(){
    }
    //Checks if input is valid
    public static String printTokens(String command){
        String[] tokens = command.split(" ");
        String ans = "[";
        for (int i = 0; i < tokens.length; i++){
            ans += tokens[i] + " ";
        }
        ans += "]";
        return ans;
    }
    public static boolean isValid(String input){
        String[] tokens = input.split(" ");
        switch(tokens[0]) {
            case "A":
                return tokens.length == 6;
            case "G":
                return tokens.length == 2;
            case "R":
                return tokens.length == 2;
            case "P":
                return tokens.length == 1;
            case "B":
                return tokens.length == 2;
        }
        return false;
        }
    public static void main(String[] arguments) throws Exception{
        Scanner scanned = new Scanner(System.in);
        System.out.println("For music stuff, please use the following commands:"
                + "\n Add Song: A <Title> <Artist> <Minutes> <Seconds> <Position>" +
                "\n Get Song: G <Position>" +
                "\n Remove Song: R <Position>" +
                "\n Print All Songs: P" +
                "\n Print All Songs By a Particular Artist: B <Artist>" +
                "\n Enter your input: ");
        String input = scanned.nextLine();
        System.out.println("Your input was: " + input);
        System.out.println("Tokens: " + printTokens(input));
        Playlist puyol = new Playlist();
        if(!isValid(input)){
            System.out.println("Invalid input.  Check again");
        }

       String[] tokens = input.split(" ");
        //Actually does the thing:
        switch(tokens[0]) {
            case ("A"):
                SongRecord song = new SongRecord();
                song.setTitle(tokens[1]);
                song.setArtist(tokens[2]);
                song.setMins(Integer.parseInt(tokens[3]));
                song.setSecs(Integer.parseInt(tokens[4]));
                puyol.addSong(song,Integer.parseInt(tokens[5]));
            case ("G"):
                System.out.println(puyol.getSong(Integer.parseInt(tokens[1])));
            case("R"):
                puyol.removeSong(Integer.parseInt(tokens[1]));
            case("P"):
                puyol.printAllSongs();
            case("B"):
                puyol.getSongsByArtist(puyol,tokens[1]);

        }
    }
}
