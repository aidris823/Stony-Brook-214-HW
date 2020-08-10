import java.util.Scanner;
//The driver
public class ItemListDriver {
    public static void main(String[] arguments) throws Exception{
        ItemInfo info = new ItemInfo();
        info.setOriginalLocation("S00013");
        info.setName("Donkey Kong 64");
        info.setPrice(59.99);
        info.setRfidTagNumber("AFD6498RE");
        ItemInfoNode testNode = new ItemInfoNode();
        testNode.setInfo(info);
        //System.out.println(testNode.toString());

        ItemList list = new ItemList();
        list.insertInfo(testNode);


        ItemInfo info2 = new ItemInfo();
        info2.setOriginalLocation("S00024");
        info2.setName("Spongebob: Battle for Bikini Bottom");
        info2.setPrice(39.99);
        info2.setRfidTagNumber("AFD6498RE");
        ItemInfoNode testNode2 = new ItemInfoNode();
        testNode2.setInfo(info2);
        list.insertInfo(testNode2);
        System.out.println(list.toString());




    }
}
