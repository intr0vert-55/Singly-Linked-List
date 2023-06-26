import java.util.InputMismatchException;
import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
class SinglyLinkedList{
    Node head;                                  //Creating an object in the begining to check if there's any data in it already
    void inAtFirst(int data){
        Node newNode = new Node(data);          //New object is created along with the data
        if(head == null){
            head = newNode;                     //If the head is null it will be made to point to the new object's address
        }
        else{
            newNode.next = head;                //Since we're inserting at first we'll have the head node stored in the object of the newNode
            head = newNode;
        }
        System.out.println("Element added");
    }
    void inAtLast(int data){
        Node newNode = new Node(data);
        if(head == null)
            head = newNode;                     //In case the node is empty this will insert the element at the begining
        else{
            Node current = head;                //Creating a copy element to traverse through the list without affecting the instance object
            while(current.next!=null){          //if the object (next) stored in the newNode points to null,it means that it's the last element
                current = current.next;         //This is like incrementing the object
            }
            current.next = newNode;             //Now the next object of the last element will point to newNode making the newNode the last
        }
        System.out.println("Element added");
    }
    void inAfter(int data,int value){
        if(head == null)                        //If the list have no element in the begining it won't assign any elements 
            System.out.println("No data inserted in the linked list yet. Try again");
        else{
            int x = 0;                          //x is the temporary variable here to find if the value is there in the list
            Node current = head;
            while(current!=null){
                if(current.data == value){
                    x++;                        //If the value is found,x will become 1 and the loop will be broke to get the current object unchanged
                    break;
                }
                current = current.next;
            }
            if(x==0){
                System.out.println("The inserted value is not found dumbo!");
            }
            else{
                Node newNode = new Node(data);
                //New object is created just if the value is there I thought it'd make it more efficient I'm not that familiar with complexity yet
                newNode.next = current.next;    //This should be done first so that there will be no confusion in pointing of data. Refer the line below
                current.next = newNode;         //The next object of the current is stored to the next of the newNode and then the next of the current is modded
                System.out.println("Element Added");
            }
        }
    }
    void inBefore(int data,int value){
        if(head == null)
            System.out.println("No data inserted in the linked list yet. Try again");
        else{
            int x = 0;
            Node current = head;
            if(current.data == value){      //The first element is checked because it won't be checked in the below steps
                x++;
            }
            else{
                while(current.next!=null){
                    Node current1 = current.next;
                    /*A new node is created whose data will be checked because we'll be adding the element behind it. So by doing this we will have
                    the previous element to be accessed*/
                    if(current1.data == value){
                        x++;
                        break;
                    }
                    current = current1;
                }
            }
            if(x == 0)
                System.out.println("The inserted value is not found dumbo!");
            else{
                Node newNode = new Node(data);
                newNode.next = current.next;        //The next of the newNode is assigned with the current which is the previous element
                current.next = newNode;
                System.out.println("Element Added");
            }
        }
    }
    void delete(int value){
        if(head == null){
            System.out.println("No data inserted in the linked list yet. Try again");
        }
        else{
            int x = 0;
            Node current = head;
            Node current1 = current;
            /*The same concept is used as in the inBefore() the current1 holds the value of current in the initialization to
              avoid the NullPointerException which could occur here if there is only one element in the list */
            if(current.data == value){
                x++;
            }
            else{
                try{
                    current1 = current.next;
                }
                catch(NullPointerException e){
                    /*NullPointerException will occur here in case there is only one value in the list and that value is not given
                      as the data to this method*/
                    System.out.println("Enter an inserted value dumbo");
                    return;     //If this exception occurs it will print the above sentence and it will exit the method
                }
                while(current1!=null){
                    current1 = current.next;
                    if(current1 == null)     //checked again to avoid NullPointerException in the below step since the value is updated above
                        break;
                    if(current1.data == value){
                        x++;
                        break;
                    }
                    current = current1;
                }
            }
            if(x==0)
                System.out.println("Enter an inserted value dumbo");
            else{
                current.next = current1.next;
                /*Since the next object of the object is pointed to the next object of the next node the center node is lost
                I don't know what it will do with the memory in this step though*/
                System.out.println(value+" is deleted");
            }
        }
    }
    void out(){
        if(head == null){
            System.out.println("----EMPTY----");
        }
        else{
            Node current = head;
            System.out.println("The inserted elements are....");
            while(current.next!=null){
                System.out.print(current.data+" ---> ");    //This will print all the elements except the last one
                current = current.next;
            }
            System.out.print(current.data);     //This will print the data on the last node
            System.out.println();
        }
    }
}
class Main{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        SinglyLinkedList sll = new SinglyLinkedList();
        int choice = 0,data = 0,value = 0,i = 0;
        while(i!=1){    //while loop is used to iterate the code infinitely until the exit option is exited
            System.out.println("----> SINGLY LINKED LIST <----");
            System.out.println("1. Insert data\n2. Remove data\n3. Print data\n4. Exit");
            System.out.println("--------------> <--------------");
            System.out.print("Enter your choice : ");
            try{
                choice = s.nextInt();
                /*To avoid getting input of another data type, this is under the try block.
                This breaks the loop if we enter a different data type as input. Maybe help me with a way that it won't affect the loop*/
            }
            catch(InputMismatchException e){
                System.out.println("Enter an integer value. Will you?");
                s.nextLine();       //In case if string occurs as the input to skip to the next line s.nextLine() is used
                //break;
            }
            switch(choice){         //switch is used for convenience
                case 1:
                    int j = 0;
                    while(j!=1){    //The same goes here as the above loop this loop will be running until the go back option is selected
                        System.out.println("1. Insert in the begining\n2. Insert in the middle\n3. Insert in the end\n4. Go Back");
                        System.out.print("Enter your choice : ");
                        int choice1 = 0;
                        try{
                            choice1 = s.nextInt();
                        }
                        catch(InputMismatchException e){
                            System.out.println("Enter an integer value. Will you?");
                            s.nextLine();    
                        }
                        switch(choice1){
                            case 1 :
                                System.out.print("Enter the data you wanna insert in the begining : ");
                                try{
                                    data = s.nextInt();
                                }
                                catch(InputMismatchException e){
                                    System.out.println("This only accepts integer values sorry.\nPlease try again");
                                    s.nextLine();        //In case if string occurs as the input to skip to the next line s.nextLine() is used
                                    break;
                                }
                                sll.inAtFirst(data);    //The inAt() function is called to insert the data in the begining
                                break;
                            case 2 :
                                System.out.println("Where do you wanna insert?\n1. Before a data\n2. After a data");
                                System.out.print("Enter your choice : ");
                                int choice2;
                                try{
                                    choice2 = s.nextInt();
                                }
                                catch(InputMismatchException e){
                                    System.out.println("Please enter an integer value");
                                    s.nextLine();
                                    break;
                                }
                                switch(choice2){
                                    case 1 :    //Here it is decided if the data should be inserted before or after a data(value)
                                        try{
                                            System.out.print("Enter the data you wanna insert(data) : ");
                                            data = s.nextInt();
                                            System.out.print("Enter the data which should be after this inserted data(value) : ");
                                            value = s.nextInt();
                                            sll.inBefore(data, value);  //This method will assign the data before the value
                                        }
                                        catch(InputMismatchException e){
                                            System.out.println("Sorry this only accepts integer values.\nPlease try again");
                                            s.nextLine();
                                            break;
                                        }
                                        break;
                                    case 2 : 
                                        try{
                                            System.out.print("Enter the data you wanna insert(data) : ");
                                            data = s.nextInt();
                                            System.out.print("Enter the data which should be before this inserted data(value) : ");
                                            value = s.nextInt();
                                            sll.inAfter(data, value);   //This method will assign the data after the value
                                        }
                                        catch(InputMismatchException e){
                                            System.out.println("Sorry this only accepts integer values.\nPlease try again");
                                            s.nextLine();
                                            break;
                                        }
                                        break;
                                    default : 
                                        System.out.println("You have entered an invalid choice");
                                        //In case values other than 1,2 is passed
                            }
                            break;
                        case 3 :
                            System.out.print("Enter the data you wanna insert in the end : ");
                            try{
                                data = s.nextInt();
                                sll.inAtLast(data); //This method will assign the data to the last node
                            }
                            catch(InputMismatchException e){
                                System.out.println("This only accepts integer values sorry.\nPlease try again");
                                s.nextLine();
                                break;
                            }
                            break;
                        case 4 :
                            j = 1;  //This will change the value of j which breaks the loop
                            break;
                        default : 
                            System.out.println("Invalid Choice! Please try again");
                            // In case values other than 1,2,3,4 are passed   
                        }
                    }
                    break;
                case 2 :
                    System.out.print("Enter the element you wanna delete : ");
                    data = s.nextInt();
                    sll.delete(data);       //This method will delete the inserted value
                    break;
                case 3 :
                    System.out.println();
                    System.out.println("-------------------------------");
                    sll.out();
                    System.out.println("-------------------------------");
                    System.out.println();
                    break;
                case 4 :
                    System.out.println("---------- OK BYE ----------");
                    i = 1;  //This will modify i which will break the loop exiting the program
                    break;
                default :
                    System.out.println("Invalid choice");
                    break;
                    // In case values other than 1,2,3,4 are passed
            }
        }
    }
}
/**                                 Thank you for taking a look at my code 
 * This is a simple project that I wanted to do on my own as soon as I learnt Singly Linked List just to get a clear understanding
 * of it and I'll do one like this for every Data Structures to make sure that I can apply the concepts practically.
 * Feel free to tell me if I made any mistakes explained something wrong or if there's any error in it.
 * 
 * 
 * 
 *    Done on,                                                                                By,
 *    25/06/2023.                                                                     @author Mukesh Prakash P,
 *                                                                                            HICET,Coimbatore.
 *                                                                                            Tamil Nadu,India.
 */
