public class SuperArray {
    private String[] data;
    public SuperArray(){
       data = new String[5];
    }

    //Tells you if one SuperArray is equal to another
    public boolean equals(SuperArray obj){
        String[] compData = obj.getData();
        if (size() != obj.size()){
            return false;
        }
        for (int i = 0; i < size(); i++){
            if (!data[i].equals(obj.getData()[i])){
                return false;
            }
        }
        return true;
    }

    //Returns how many items are in the SuperArray
    public int size(){
        int size = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i] != null){
                size++;
            }
        }
        return size;
    }

    //Returns data in SuperArray as a String Array
    public String[] getData(){
        return data;
    }

    //Returns data in SuperArray but in a UI-friendly manner.
    public String toString(){
        String ans = "[";
        for (int i = 0; i < size(); i++){
            ans += data[i];
            ans += " ";
        }
        ans += "]";
        return ans;
    }

    //Adds a new value to SuperArray:
    //Adds position using array terms (position == 0 means I add it to beginning)
    public void addValue(String value, int position) throws Exception {
        if (size() == 5) {
            throw new Exception("Playlist already full.");
        }
        if (position > size()) {
            throw new Exception("Value placed ahead of valid spot.");
        }

        //If the array is 1 away from being full it should just append

        /*
        Should:
            Go through array and make each value at a position equal to
            the value one behind it.
         */

        int size = size();
        for (int i = position; i < size; i++) {
            data[i+1] = data[i];
        }
        data[position] = value;
    }

    public void removeValue(int position) throws Exception{
        if (position >= size()||size()==0){
            throw new Exception("Cannot remove an empty spot");
        }

        int size = size();
        data[position] = null;
        for (int i = position; i < size; i++){
            data[i] = data[i+1];
        }
    }

    public static void main(String[] arguments) throws Exception{
        SuperArray sA1 = new SuperArray();
        sA1.addValue("Stromae",0);
        System.out.println(sA1.toString());
        System.out.println(sA1.size());

        sA1.addValue("TheHu",0);
        System.out.println(sA1.toString());
        System.out.println(sA1.size());

        sA1.removeValue(0);
        System.out.println(sA1.toString());
        System.out.println(sA1.size());

        sA1.addValue("Bob",1);
        System.out.println(sA1.toString());
        System.out.println(sA1.size());

        sA1.addValue("John",2);
        System.out.println(sA1.toString());
        System.out.println(sA1.size());

        sA1.removeValue(1);
        System.out.println(sA1.toString());
        System.out.println(sA1.size());

        sA1.removeValue(1);
        System.out.println(sA1.toString());
        System.out.println(sA1.size());


    }
}
