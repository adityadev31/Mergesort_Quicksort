
import java.util.*;

class Node<Integer>{
    int data;
    Node<Integer> next;
    Node(int data){
        this.data = data;
        next = null;
    }
}



class Handle_list{
    
    
    /////////// PRINTING LIST ///////////////////
    
    void print(Node<Integer> head){
        
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }System.out.println();
    }
    
    
    
    ///////////// MAKING LIST /////////////////////
    
    Node<Integer> makeList(int size){
        
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner scan = new Scanner(System.in);
        
        for(int i=0; i<size; i++){
            
            int x = scan.nextInt();
            Node<Integer> temp = new Node<Integer>(x);
            
            if(head!=null){
                tail.next = temp;
                tail = tail.next;
            }
            else{
                head = temp;
                tail = temp;
            }
        }
        return head;
    }
    
    
    
    ///////// FINDING MID POSITION ////////////////
    Node<Integer> findMid(Node<Integer> head){
        
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    
    
    
    
    ///////// MERGING LIST ////////////
    Node<Integer> merge_2_list(Node<Integer> head1, Node<Integer> head2){
        
        Node<Integer> header = null;
        Node<Integer> tail = null;
        Node<Integer> t1 = head1;
        Node<Integer> t2 = head2;
        
        
        if(t1.data<t2.data){
            
            header = t1;
            tail = t1;
            t1 = t1.next;
        }
        else{
            
            header = t2;
            tail = t2;
            t2 = t2.next;
        }
        
        
        while(t1!=null && t2!=null){
            
            if(t1.data<t2.data){
            
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }
            else{
                
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }
        
        if(t1==null)
            tail.next = t2;
            
        else
            tail.next = t1;
            
        return header;
    }
    
    
    
    
    
    
    ////////////// MERGE SORT /////////////////////////
    Node<Integer> mergeSort(Node<Integer> head){
        
        if(head==null || head.next==null)
            return head;
            
        Node<Integer> mid = findMid(head);
        Node<Integer> mid_next = mid.next;
        mid.next = null;
        
        Node<Integer> left = mergeSort(head);
        Node<Integer> right = mergeSort(mid_next);
        head = merge_2_list(left, right);
        return head;
    }
    
}



public class Main
{

	public static void main(String[] args) {
	    
	  Handle_list ob = new Handle_list();
		
		Node<Integer> head1 = ob.makeList(3);
		Node<Integer> head2 = ob.makeList(5);
		
		for(int i=0; i<50; i++){System.out.println();}
		ob.print(head1);
		ob.print(head2);
		
		Node<Integer> l1 = ob.mergeSort(head1);          // for un-ordered list
		Node<Integer> l2 = ob.mergeSort(head2);          // for un-ordered list
		Node<Integer> header = ob.merge_2_list(l1, l2);  // only for ordered list 
		ob.print(header);
	}
}
