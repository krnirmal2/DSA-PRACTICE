import java.util.Stack;

public class ImplementQueueusingtwostacks1ands2 {
    Stack<Integer> input = new Stack<Integer>(); 
    Stack<Integer> output = new Stack<Integer>(); 
    
    /*The method pop which return the element poped out of the stack*/
    int dequeue()
    {
	    // Your code here
	    
	    // if the s1 is having element then we have to take the peek element and return 
	     // if first stack is empty 
        if (input.isEmpty()) 
        { 
            return -1;
        } 
 
        // Return top of s1 
        int x = input.peek(); 
        input.pop(); 
        return x; 
    }
	
    /* The method push to push element into the stack */
    void enqueue(int x)
    {
	    // Your code here
	    
	    // check if s1 contain any element or not if yes then remove it to s2
	    while(!input.isEmpty()){
	        output.push(input.pop());
	    }
	    
	    // take new element in the s1
	    input.push(x);
	    // now remove the element from s2 and return back to s1
	    while(!output.isEmpty()){
	        input.push(output.pop());
	    }
	    
    }
    
}
