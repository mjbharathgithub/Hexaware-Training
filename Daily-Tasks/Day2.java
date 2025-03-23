 import java.util.*;
class StackUsingArray{ 
     
    int[] a;
    int top,size;

    StackUsingArray(int size){ 
        this.size=size; 
        top =-1; 
        a= new int[size]; 
    } 

    boolean push(int x){ 
        if (top>=size-1){ 
            System.out.println("Stack Overflow"); 
            return false; 
        }
        
        a[++top]=x; 
        
        return true; 
    } 

    int pop(){ 
        if (top<0){ 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        
        return a[top--]; 
    } 

    int peek(){ 
        if(top<0){ 
            System.out.println("Stack is Empty"); 
            return 0; 
        } 
        return a[top]; 
    } 

    boolean isEmpty(){ 
        return top<0; 
    } 
} 


class RestaurantOrderProcessingUsingQueue{
    
    Queue<String> queue ;
    
    RestaurantOrderProcessingUsingQueue(){
        queue = new LinkedList<String>();
        
    }
    
    void addOrder(String order){
        queue.offer(order);
        System.out.println("Your order is added Successfully");
    }
    
    String deliverOrder(){
        String order = queue.poll();
       if(order!=null) {
        System.out.println("Enjoy your order Sir/Mam");
        return order;
    } 
    else{
        System.out.println("No orders to deliver.");
        return "null";
    }
        
    }
    
    void viewOrder(){
        if(queue.isEmpty()){
            System.out.println("There are no orders to see");
        }
        else{
            System.out.println(queue);
        }
    }
    
    
}

class Node{
    int data;
    Node left,right;
    
    Node(int data){
        this.data=data;
    }
}

class BinarySearchTree{
    Node root;
    
    void insert(int key){
        root=insertRecord(root,key);
    }
    
    Node insertRecord(Node root,int key){
        
        if(root==null){
            return new Node(key);
        }
        
        if(root.data<key) root.left=insertRecord(root.left,key);
        else root.right=insertRecord(root.right,key);
        
        return root;
    }
    
    
    void inorderTraversal(Node root){
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root.data+" ");
            inorderTraversal(root.right);
        }
    }
    
    void preorderTraversal(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            inorderTraversal(root.left);
            inorderTraversal(root.right);
        }
    }
    
    void postorderTraversal(Node root){
        if(root!=null){
            inorderTraversal(root.left);
            inorderTraversal(root.right);
            System.out.print(root.data+" ");
        }
    }
    
}

public class Main { 
    public static void main(String[] args) { 
        // StackUsingArray s= new StackUsingArray(5); 
        // s.push(32); 
        // s.push(12); 
        // s.push(54); 
        // System.out.println(s.pop()+ " popped from stack"); 

        // System.out.println("Top element is: "+ s.peek()); 

        // System.out.print("Elements present in stack: "); 
        // while(!s.isEmpty()){ 
        //     System.out.print(s.peek() +" "); 
        //     s.pop(); 
        // } 
        // RestaurantOrderProcessingUsingQueue restaurant= new RestaurantOrderProcessingUsingQueue();
        // restaurant.addOrder("Rice");
        // restaurant.addOrder("Dosa");
        // restaurant.addOrder("Chicken");
        // restaurant.addOrder("shawarma");
        // restaurant.viewOrder();
        // System.out.println(restaurant.deliverOrder());
        // restaurant.viewOrder();
        
        BinarySearchTree tree= new BinarySearchTree();
        tree.insert(34);
        tree.insert(23);
        tree.insert(54);
        tree.insert(56);
        tree.insert(12);
        
        tree.inorderTraversal(tree.root);
        
    } 
}
[17/03, 13:06] Joseph Bharath: // // package com.example.stackandqueue;

// // public class RecursionWithoutStack {
	
// // 	public static int factorial(int n , int result)
// // 	{
// // 		while(n>0)
// // 		{
// // 			result *= n;
// // 			n--;
// // 		}
// // 		return result;
// // 	}
	
// // 	public static void main(String[] args)
// // 	{
		
// // 		int num =5;
// // 		int fact = factorial(num ,1);
// // 		System.out.println("factorial of " + num + " is : " + fact);
	
// // 	}

// // }



// // package com.example.stackandqueue;

// // public class RecursionWithStack {
	
// // 	public static int factorial(int n)
// // 	{
// // 		if (n == 1) return 1;
		
// // 		return n*factorial(n-1); // uses stack memory
// // 	}
	
// // 	public static void main(String[] args)
// // 	{
		
// // 		int num =5;
// // 		int fact = factorial(num);
// // 		System.out.println("factorial of " + num + " is : " + fact);
	
// // 	}

// // }



// // Stack Example

// // package com.example.stackandqueue;

// // import java.util.ArrayList;
// // import java.util.LinkedList;
// // import java.util.Queue;
// // import java.util.Stack;


// // public class StackExample {
	
// // 	static ArrayList<String> tempstate = new ArrayList<>();
	
	
	
	
// // 	public static void inputText(String text) {
		
// // 			tempstate.add(text);
		
// // 		}
// // 		public static void undo()
// // 		{
			
// // 			if(!tempstate.isEmpty()) tempstate.remove(tempstate.size()-1);
// // 		}

// // 	public static void main(String[] args) {
// // 		// TODO Auto-generated method stub
		
// // 		/*
// // 		 * Stack<Integer> stack = new Stack<>();
// // 		 * 
// // 		 * stack.push(10); stack.push(34); stack.push(56);
// // 		 * System.out.println("Stack Elements : "+ stack);
// // 		 * 
// // 		 * System.out.println("Popped element : " + stack.pop());
// // 		 * System.out.println("Top Element : " + stack.peek());
// // 		 * 
// // 		 * 
// // 		 * 
// // 		 * 
// // 		 * 
// // 		 * 
// // 		 * //managing incoming customer calls Queue<String> queue = new LinkedList<>();
// // 		 * queue.add("Customer 1"); queue.add("Customer 2"); queue.add("Customer 3");
// // 		 * 
// // 		 * System.out.println("Queue Elements : "+ queue);
// // 		 * 
// // 		 * System.out.println("Removed element : " + queue.poll()); //remove the element
// // 		 * System.out.println("Next Customer in a pipeline : " + stack.peek());
// // 		 */
		
		
// // 		inputText("Hello..");
// // 		inputText("Java..");
// // 		inputText("Learning..");
		
// // 		System.out.println("current data : " + tempstate);
		
// // 		undo();
// // 		System.out.println("After Undo Operation : "+ tempstate);
// // 	}

// // }

// // // implement a stack using an array (without stack class).
// // // Simulate a restaurant order processing queue.

// // // Manage the queue scheduler without queue and with queue(Automatic task processing)

// package com.example.treeexamples;

// class Node{
	
	
// 	int data ;
// 	Node left , right;
	
// 	public Node(int item) {
// 		super();
// 		this.data = item;
		
// 	}
	
	
	
	
// }




// public class BinarySearchTree {

// 	Node root;
	
// 	void insert(int key)
// 	{
		
// 		root = insertRec(root , key);
// 	}
	
//  Node insertRec(Node root , int key)
// 	{
// 	 if (root == null) return new Node(key);
// 	 if(key<root.data) root.left = insertRec(root.left , key);
// 	 else root.right = insertRec(root.right ,key);
// 	 return root;
		
		
// 	}
	
//  void inorder()
 
//  {
// 	 inorderRec(root);
//  }
	 
// 	void  inorderRec(Node root)
// 	 {
// 		 if (root != null) {
			 
// 			 inorderRec(root.left);
// 			 System.out.println(root.data + " ");
// 			 inorderRec(root.right);
// 		 }
		 
// 	 }
 
// 	public static void main(String[] args) {
// 		// TODO Auto-generated method stub
		
// 		BinarySearchTree bst = new BinarySearchTree();
		
// 		bst.insert(50);
// 		bst.insert(30);
// 		bst.insert(70);
// 		bst.insert(20);
// 		bst.insert(40);
// 		bst.insert(60);
// 		bst.insert(80);

// 		bst.inorder();
// 	}

// }
import java.util.*;
class TaskSchedulerWithoutQueue{
    String[] tasks;
    int taskCounter;

    public TaskSchedulerWithoutQueue(int size){
        tasks= new String[size];
        taskCounter = 0;
    }

    public void addTask(String task){
        if(taskCounter>=tasks.length){
            System.out.println("Task list is full Cannot add more tasks");
            return;
        }
        
        tasks[taskCounter++]= task;
        System.out.println("Added Task: "+ task);
    }

    public void executeTask() {
        if(taskCounter==0){
            System.out.println("No tasks to execute");
            return;
        }
        
        System.out.println("Executing Task: "+ tasks[0]);

        for (int i=1;i<taskCounter;i++){
            tasks[i-1]=tasks[i];
        }
        
        tasks[--taskCounter]=null;
    }

    public void showTasks(){
        System.out.println("Pending Tasks: "+Arrays.toString(tasks));
    }

    
}

class Task {
    String name;
    long createdTime;

    public Task(String name) {
        this.name = name;
        this.createdTime = System.currentTimeMillis();
    }
}


class TaskSchedulerWithQueue{
    
    Queue<Task> taskScheduler;
    
    TaskSchedulerWithQueue(){
        taskScheduler=new LinkedList<>();
    }
    
    void addTask(String task){
        
        
            taskScheduler.offer(new Task(task));
            System.out.println("Added Task: "+ task);
            
        
    }
    
    void executeTask(){
        if(taskScheduler.isEmpty()){
            System.out.println("No tasks to execute");
        }
        else{
            Task task = taskScheduler.poll();
            System.out.println("Executed "+ task.name+" in "+(System.currentTimeMillis()-task.createdTime)+"ms");
        }
    }
    
    public void showTasks(){
        
        System.out.println("Remaining Tasks : ");
        for(Task task: taskScheduler){
            System.out.print(task.name+" ");
        }
        System.out.println();
        
    }
}

    public class Main{
        
    
        public static void main(String[] args) {
                 //TaskSchedulerWithoutQueue scheduler= new TaskSchedulerWithoutQueue(5);
                
                TaskSchedulerWithQueue scheduler= new TaskSchedulerWithQueue();
                scheduler.addTask("Task 1");
                scheduler.addTask("Task 2");
                scheduler.addTask("Task 3");
        
                scheduler.showTasks();
        
                scheduler.executeTask(); 
                scheduler.showTasks();
        
                scheduler.executeTask();
                scheduler.showTasks();
                
                scheduler.executeTask();
                scheduler.showTasks();
                
                
            }
  }
