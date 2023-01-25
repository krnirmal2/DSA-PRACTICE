package AdvancedDSA.Arrays.one.LinkedList;

    public class linkedlist{
        int data;
        linkedlist prev;
        linkedlist next;
        linkedlist(){
        }
        linkedlist(int data){
            this.data=data;
        }
        linkedlist head,tail;
        public void add(int data){
            if(head==null){
                linkedlist newNode=new linkedlist(data);
                head= newNode;
                tail=newNode;
                head.prev=null;
                tail.next=null;
            }
            else{
                linkedlist newNode=new linkedlist(data);
                tail.next=newNode;
                newNode.prev=tail;
                tail=newNode;
                tail.next=null;
            }
        }
        public void display(){
            linkedlist current =head;
            while(current!=null){
                System.out.println(current.data);
                current=current.next;
            }
        }

        public static void main(String args[])
        {
            linkedlist list =new linkedlist();
            list.add(8);
            list.add(4);
            list.add(6);
            list.display();
        }
    }
