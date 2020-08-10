import java.util.Scanner;
public class DepartmentStore {
    public DepartmentStore(){

    }
    public static void main(String[] arguments){
        DepartmentStore dep = new DepartmentStore();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! \n " +
                "C - Clean Store \n "+
                "I - Insert an item into the list \n"+
                "L - List by location \n" +
                "M - Move an item into the store \n" +
                "O - Checkout \n" +
                "P - Print all items in store \n" +
                "R - Print by RFID tag number \n"+
                "U - Update inventory system \n" +
                "Q - Exit program");



    }
}
