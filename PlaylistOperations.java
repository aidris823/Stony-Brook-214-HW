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
    public static void main(String[] arguments){
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

        //Actually does the thing:

    }
}
