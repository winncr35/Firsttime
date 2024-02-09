public class LinkListTestKnowledge {

    public static class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    public static Node addhead (Node headNode,int value){
        Node newNode = new Node(value);

        if (headNode != null){
            newNode.next= headNode;

        }
        return newNode;
    }
    public static Node addtail(Node headNode, int value){
        Node newNode = new Node(value);
        if(headNode == null){
            return newNode;
        }
        else{
            Node curNode = headNode;
            while(curNode.next != null){
                curNode = curNode.next;
            }
            curNode.next= newNode;
        }

        return headNode;
    }
    public static Node addtoindex(Node headNode,int value, int index){
        if (index == 0 ) {
            return addhead(headNode, value);
        }
        Node curNode= headNode;    //   1  2   3  4
        int count=0;
        Node newNode= new Node(value);
        while (curNode != null) {
            count++;
            if(index == count){
                newNode.next=curNode.next;
                curNode.next= newNode; 
                break;
            }
            curNode= curNode.next;
            
        }


        return headNode;
    }
    public static Node removehead(Node headNode){

        if(headNode != null){
            return headNode.next;
        }
        return headNode;
    }
    public static Node removetail(Node headNode){
  
        if (headNode == null) {
            return null;
        }
        
        Node prevNode= null;
        Node curNode = headNode;
        while (curNode.next != null) {  /// 1 2 3 4
            prevNode = curNode;
            curNode=curNode.next;    
        }
        if (prevNode == null) { // 1-> null;
            return null;
        }
        
        prevNode.next = curNode.next;
        


        return headNode;
    }
    public static Node removeatindex(Node headNode,int index){
        if (headNode == null) {
            return null;
        }
        if (index == 0) {
            return removehead(headNode);
            
        }
        Node prevNode = null;
        Node curNode= headNode;
        int count=0;
        while (curNode.next != null) {
            count++;
            prevNode= curNode;
            curNode=curNode.next; 
            if(index == count){
                break;
            }

            

            
        }
        if(prevNode == null){
            return null;
        }
        prevNode.next= curNode.next;
        

        return headNode;
    }
    public static Node ReverseLinkedList( Node headNode){
        Node curNode= headNode;
        while (curNode != null && curNode.next != null) {
            Node nextNode= curNode.next;
            curNode.next= nextNode.next;
            nextNode.next= headNode;
            headNode= nextNode;
        }


        return headNode;
    }
    public static Node ReverseLinkedList1(Node headNode){
       
        if( headNode == null){
            return null;
        }
        Node nextNode = headNode.next;

        if (nextNode == null) {
            return headNode;
        }
        Node newhead= ReverseLinkedList1(nextNode);
        nextNode.next= headNode;
        headNode.next=null;

        return newhead;
    }
    public static void printLinkedList(Node head){
        if (head ==null) {

            System.out.println("Empty List");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+ "");
            if(temp.next != null){
                System.out.print("->");
            }
            else{
                System.out.println();
            }
            temp=temp.next;
            
        }
        
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next= n2;
        n2.next=n3;
        n3.next=n4;

        printLinkedList(n1);
        
        // printLinkedList(addhead(n1,0));
        // printLinkedList(addtail(n1, 5));
        // printLinkedList(addtoindex(n1, 6, 5));
        // printLinkedList(removehead(n1));
        // printLinkedList(removetail(n1));
        // printLinkedList(removeatindex(n1, 2));
        printLinkedList(ReverseLinkedList1(n1));

    }
}