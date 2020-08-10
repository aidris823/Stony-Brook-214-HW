//The actual LinkedList
public class ItemList {
    //The head and tail of the linked list.
    private ItemInfoNode head;
    private ItemInfoNode tail;
    private int size;

    public ItemList(){
        //Initially empty
        head = null;
        tail = null;
        size = 0;
    }

    //Inserts an ItemInfoNode into the list based off tag number.
    //RFIDNumber is a means of determining order in the list (alphabetically)
    //This algorithm is O(n) run time since you must traverse the list to find your node.
    public void insertInfo(String name, String rfidTag, double Price, String initPosition)throws Exception{
        //Create a node
        ItemInfo info = new ItemInfo();
        info.setRfidTagNumber(rfidTag);
        info.setName(name);
        info.setPrice(Price);
        info.setOriginalLocation(initPosition);
        ItemInfoNode node = new ItemInfoNode();
        node.setInfo(info);
        //For a size 0 list
        if (head == null){
            head = new ItemInfoNode();
            head.setInfo(info);
            head.setPrev(node);
            return;
        }

        //The actual loop
        String compRFID = node.getInfo().getRfidTagNumber();
        ItemInfoNode currentNode = head;
        while (currentNode != null){
            String currentRFID = currentNode.getInfo().getRfidTagNumber();
            if (currentRFID.compareTo(compRFID) >= 0){
                currentNode.setNext(node);
                node.setPrev(currentNode);
                return;
            }
            currentNode = currentNode.getNext();
        }

    }

    //Helper
    public void insertInfo(ItemInfoNode node) throws Exception{
        ItemInfo info = node.getInfo();
        insertInfo(info.getName(),info.getRfidTagNumber(),info.getPrice(),info.getOriginalLocation());
    }

    //Removes all nodes with "out" as current location from the list.
    //This algorithm is O(n) run time since you must traverse the list looking for "out" ones.
    public void removeAllPurchased(){

    }
    //Helper that removes a node from the list by making its previous node point to the next node and
    // next node's previous point to the previous.
    //This is O(1) since you already know which node to remove.
    public ItemInfo removeNode(int position){
        ItemInfo oldValue = null;
        //If asked to remove the first item
        if (position == 0){
            oldValue = head.getInfo();
            head = head.getNext();
            head.setPrev(null);
            return oldValue;
        }
        //If asked to remove the last item.
        if (position == size() - 1){
            oldValue = tail.getInfo();
            tail = tail.getPrev();
            tail.setNext(null);
            return oldValue;
        }
        else{
            //Get the value at index
            int counter = 0;
            ItemInfoNode currentNode = head;
            while (counter != position){
                currentNode.getInfo();
                counter++;
            }
        }
        return oldValue;

    }

    //Moves an item with a particular rfidTag from one source to another.
    //Returns false if rfidTag not found.
    //Dest must be a cart, shelf, or "out."  Source cannot be "out".
    //This is O(n) since you need to find the node with a particular rfidTag by traversing the list.
    public boolean moveItem(String rfidTag, String source, String dest) throws Exception{
        return false;
    }

    //Prints all items currently on list.
    //This is O(n) since you need to go through the whole list.
    public void printAll(){

    }

    //Prints all items currently at a given location.
    //This is O(n) since you need to go through the entire list to find the items at the location.
    public void printByLocation(String location){

    }

    //Places all items not in "out" or a cart back in their original location.
    //Displays the items that had to be moved this way.
    public void cleanStore(){

    }
    //Given a cart, changes each of its locations to "out" and returns the checked out items in order of rfid.
    //Returns cost of items in total.
    public double checkOut(String cartNumber){
        return 0;
    }

    //Gives you the amount of items in the list.
    public int size(){
        ItemInfoNode currentNode = head;
        int counter = 0;
        while (currentNode != null){
            counter++;
            currentNode = currentNode.getNext();
        }
        size = counter;
        return counter;
    }

    public String toString(){
        String ans = "";
        int counter = 1;
        ItemInfoNode currentNode = head;
        while (currentNode != null){
            ans += "Item Number " + counter;
            ans += "\n" + currentNode.toString() + "\n\n";
            counter++;
            currentNode = currentNode.getNext();
        }
        return ans;
    }

}
