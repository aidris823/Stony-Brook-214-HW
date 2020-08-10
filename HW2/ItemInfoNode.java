//A doubly-linked node with a reference to an ItemInfo object.
public class ItemInfoNode {
    private ItemInfo info;
    private ItemInfoNode prev;
    private ItemInfoNode next;

    //Constructor
    public ItemInfoNode(){
        info = new ItemInfo();
        prev = null;
        next = null;
    }
    //Gets and sets
    public void setInfo(ItemInfo info){
        this.info = info;
    }
    public void setPrev(ItemInfoNode prev){
        this.prev = prev;
    }
    public void setNext(ItemInfoNode next){
        this.next = next;
    }
    public ItemInfo getInfo(){
        return info;
    }
    public ItemInfoNode getPrev(){
        return prev;
    }
    public ItemInfoNode getNext(){
        return next;
    }

    public String toString(){
        return info.toString();
    }

}
