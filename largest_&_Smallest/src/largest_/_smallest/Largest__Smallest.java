import java.util.Scanner;
package largest_smallest;

public class Largest__Smallest {

    public static void main(String[] args) {
        System.out.println("Welcome to Java Program to find " + "largest and smallest number without using array"); 
        System.out.println("Please enter value of N: "); 
        
        Scanner sc = new Scanner(System.in); 
        
        int n = sc.nextInt(); 
        int largest = Integer.MIN_VALUE; 
        int smallest = Integer.MAX_VALUE; 
        
        System.out.printf("Please enter %d numbers %n", n); 
        for (int i = 0; i < n; i++) 
        { 
            int current = sc.nextInt(); 
        if (current > largest) 
        { 
            largest = current; 
        } 
        if (current < smallest) 
        { 
            smallest = current; 
        } 
        } 
        System.out.println("largest of N number is : " + largest); 
        System.out.println("smallest of N number is : " + smallest);
       
    }
    
}
