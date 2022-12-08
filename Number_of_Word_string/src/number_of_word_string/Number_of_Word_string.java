package number_of_word_string;

import java.util.Scanner;

public class Number_of_Word_string {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your string : ");
        String str = sc.nextLine();
        
        System.out.println("Number of word in string : " + count_word(str) + "\n");
    }
    public static int count_word(String str)
    {
        int count = 0;
        if (!(" ".equals(str.substring(0, 1))) || !(" ".equals(str.substring(str.length() - 1))))
        {
            for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == ' ')
                {
                    count++;
                }
            }
            count = count + 1;
        }
        return count;
    }
    
}
