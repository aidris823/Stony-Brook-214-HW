//Gives information about items
public class ItemInfo {

    //Fields:

    private String name = "";
    private double price;
    //Radio Frequency that's 9 character string in base 16 hexadecimal
    private String rfidTagNumber = "";
    //6 character original shelf position starting with 's'
    private String originalLocation = "";
    //Either 4 character current shelf position starting with 'c' or 'out' if customer checked out
    private String currentLocation = "";

    public ItemInfo(){

    }
    //Accessors and mutators
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getRfidTagNumber(){
        return rfidTagNumber;
    }
    public String getOriginalLocation(){
        return originalLocation;
    }
    public String getCurrentLocation(){
        return currentLocation;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price) throws Exception{
        if (price <= 0){
            throw new Exception("Positive prices only");
        }
        this.price = price;
    }
    public void setRfidTagNumber(String rfidTagNumber)throws Exception{
        if (rfidTagNumber.length() != 9){
            throw new Exception("9 character RFIDs only");
        }
        this.rfidTagNumber = rfidTagNumber;
    }
    public void setOriginalLocation(String originalLocation) throws Exception{
        if (originalLocation.length() != 6){
            throw new Exception("Original Location must be 6 characters");
        }
        if (originalLocation.toLowerCase().charAt(0) != ('s')){
            throw new Exception("All original locations start with 's'");
        }
        this.originalLocation = originalLocation;
        this.currentLocation = originalLocation;
    }
    public void setCurrentLocation(String currentLocation) throws Exception{
        if (currentLocation.charAt(0) != 'c' ||
                !currentLocation.toLowerCase().equals("out")){
            throw new Exception("Current location must either start with c or be 'out'");
        }
        this.currentLocation = currentLocation;
    }

    //Gives a list of all the stuff it currently holds:
    public String toString(){
        String ans = "";
        ans += "Name: " + getName();
        ans += "\n --------------- \n Price: " + getPrice();
        ans += "\n --------------- \n rfidTagNumber: " + getRfidTagNumber();
        ans += "\n --------------- \n Original Location: " + getOriginalLocation();
        ans += "\n ---------------\n Current Location: " + getCurrentLocation();
        return ans;
    }



}
