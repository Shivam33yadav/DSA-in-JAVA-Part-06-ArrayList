import java.util.ArrayList;
public class ABasic{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // operations  Add element
        list.add(1);  // arraylist ka name list then . and call add function // list object k liye ye val add ho jaegi
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(1, 9);  // index 1 pr 9 ko add   // it takes linear time 
        System.out.println(list);
        //T.C = O(n)

        System.out.println(list);

        // get operation
        int element = list.get(2);
        System.out.println(element);
    

       // delete
       list.remove(2);
       System.out.println(list);

       // set elemnt at index 3 ko htak 10 
       list.set(2, 10);
       System.out.println(list);

       // contains element chck whther the elemnt exist
       System.out.println(list.contains(1));
       System.out.println(list.contains(11));

    }
}