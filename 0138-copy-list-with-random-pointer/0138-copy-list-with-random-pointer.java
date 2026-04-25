/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         if (head == null) return null;

         
    HashMap<Node,Node> map=new HashMap<>();

    Node newHead=new Node(head.val);
     Node newTemp=newHead;
     
    
   Node oldTemp=head.next;
    map.put(head,newHead);



while(oldTemp!=null){

    Node newNode=new Node(oldTemp.val);
     map.put(oldTemp,newNode);
     newTemp.next=newNode;
     oldTemp =oldTemp.next;
     newTemp=newTemp.next;
}

oldTemp=head;
newTemp=newHead;

while(oldTemp!=null){
    if(oldTemp.random!=null){
        newTemp.random=map.get(oldTemp.random);
    }else{
         newTemp.random=null;
    }
 oldTemp =oldTemp.next;
     newTemp=newTemp.next;

}

return newHead;
    }
}