import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long Q = sc.nextInt();

        int tag, k;
        String last, newString;
        Stack<String> stack = new Stack<>();

        while(Q-->0){
            tag = sc.nextInt();
            switch (tag){
                case 1:
                    //append W
                    last = stack.size() > 0 ? stack.peek() : "";
                    newString = last + sc.next();
                    //System.out.println(tag + " " + newString);
                    stack.push(newString);
                    break;
                case 2:
                    //erase last k character of S
                    k = sc.nextInt();
                    last = stack.peek();
                    newString = last.substring(0, last.length()-k);
                    //System.out.println(tag + " " + newString);
                    stack.push(newString);
                    break;
                case 3:
                    //return kth character of S
                    k = sc.nextInt()-1;
                    if(stack.size() > 0) {
                        last = stack.peek();
                        String c = String.valueOf(last.charAt(k));
                        //System.out.println(tag + " " + c);
                        System.out.println(c);
                    }
                    break;
                case 4:
                    //undo
                    //System.out.println(tag + " " + stack.peek());
                    stack.pop();
                    break;
            }
        }
    }
}