//import java.util.LinkedList;
import java.util.*;

public class ALinkList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data =data;
            this.next = null;

        }

    }
    // head and tail
    public static Node head;
    public static Node tail;
    // size of ll
    public static int size ;

    public void addFirst(int data) {
       

        
        //step1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }


        //step 2 - newnode next = head;
        newNode.next = head; // linking


        //step 3 - head = new node
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;

        }
        tail.next = newNode;
        tail = newNode;
    }

    // methods
   
    
        public void print(){
            if(head == null){
                System.out.println("LL is Empty");
                return;
            }
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
   // add in  the middle;
   public void add(int idx, int data ){
    if(idx == 0){
        addFirst(data);
        return;
    }
    Node newNode = new Node(data);
    size++;
    Node temp = head;
    int i =0;

    while(i < idx-1){
        temp = temp.next;
        temp.next = newNode;
    }
    // i = idx -1; temp -> prev
      newNode.next = temp.next;
      temp.next = newNode;
   }

   // Remove in ll
   public int removeFirst(){
    if(size == 0){
        System.out.println("LL is empty");
        return Integer.MIN_VALUE;
    } else if(size == 1){
        int val = head.data;
        head = tail = null;
        size =0;
        return val;

    }
    int val = head.data;
    head = head.next;
    size--;
    return val;
   }
  

   // making method for remove last
   public int removeLast(){
    if(size == 0){
        System.out.println("LL is empty");
        return Integer.MIN_VALUE;


    }else if(size == 1){
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
    }
    // prev : i = size-2
    Node prev = head;
    for(int i =0; i <size-2; i++){
        prev = prev.next;

    }
     
    int val = prev.next.data;//tail. data
    prev.next = null;
    tail = prev;
    size--;
    return val;
   }

   // iterative Search

   public int itrSearch(int key) {
        Node temp = head;
        int i = 0;

        while(temp != null){
            if(temp.data == key ){ //key found case 
                return i ;
            }
            temp = temp.next;
            i++;
        }
        // key not found
        return -1;
   }
   public int helper(Node head, int key){ // it is actual rec function
        if(head == null){  // t.c O(n)
            return -1;
        }

        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;  // kyuki jo upR wale ne idx diya wo glt hh logically


   }
   public int recSearch(int key){
    return helper(head, key);
      
   }
   // reversing a linked list

   public void reverse(){
    Node prev = null; // head k pehle kuch nhi hota
    Node curr = tail = head;
    Node next;

    while(curr !=  null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    head = prev;

   }

   public void  deleteNthfromEnd(int n){
          // calc size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;

        }
        if(n == sz){
            head = head.next; //removeFirst
            return;
        }

        //sz-n
        int i =1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;


   }
   // pallindrome
     // find middle -> slow fast approach
     public Node findMid(Node head){ // helper func
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // +1 se move
            fast = fast.next.next; // +2 se move
        }
        return slow; // slow is my midNode
     }
     public  boolean checkPallindrome(){
        if(head == null || head.next == null ){
            return true;
        }
         // step1 - find mid
         Node midNode = findMid(head);


         //step2 - reverse 2nd half
         Node prev = null;
         Node curr = midNode;
         Node next;
         while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

         }
          
          Node right = prev ;// right half head
          Node left = head;

         // step3 - check left half & right half
         while(right!= null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
         }
          return true;



     }
     // Part 2 LL
     public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // +1 
            fast = fast.next.next; // +2
            if(slow == fast){
                return true; // cycle exists

            }
        }
        return false; // cycle does not exist
     }

     // remove loop/cycle
    public static void removeCycle(){  // return type is removecycle
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;  // cycle doesnt exists
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;

            }

        }
        if(cycle == false ){
            return;
        }

        // find meeting point 
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next.next;


        }


        // remove cycle -> last.next = null
        prev.next = null;

    }

     

   // public static void main(String[] args) {
       // LinkedList ll = new LinkedList();
       // ll.addFirst(2);
        //ll.addFirst(1);
        //ll.addLast(4);
        //ll.addLast(5);
        //ll.add(2, 3);
      //  ll.addLast(1);
       // ll.addLast(2);
       // ll.addLast(1); // these all are pallindrome 

      //  ll.print(); // 1-> 2 -> 3-> 4->5
      //  ll.reverse();
       // ll.print();

        //ll.reverse();
      // ll.deleteNthfromEnd(3);
     //  ll.print;

    // System.out.println(ll.checkPallindrome());
        //add middle
       // ll.print(2,9);

       // ll.print(); //  1->2->3 ->4->5
     //   System.out.println(ll.size);  // 5
    // ll.removeFirst();
   //  ll.print();  // 1 will be remeove 2,3 4, 5
       
    // ll.removeLast();
     //ll.print();
    // System.out.println(ll.size);

     //System.out.println(ll.itrSearch(3));
     //System.out.println(ll.itrSearch(10));
    // System.out.println(ll.recSearch(3));  // 2
     //System.out.println(ll.recSearch(10));  // -1 does not exist

  //  }
    
//}
 // output 1-> 2->9->3->4-> null
 public static void main(String[] args) {
    head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = head; 
    //1->2->3->1


    System.out.println(isCycle());
    removeCycle();
    System.out.println(isCycle());
     }
 }