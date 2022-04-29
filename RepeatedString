import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
       long lastRoundLen = n%s.length();
        long round = n/s.length();
        long countA = 0;
        long totalA = 0;
        for(int i = 0 ; i < s.length();i++){
            if(s.charAt(i) == 'a'){
                countA ++;
            }
        }
        totalA = round*countA;
        //Find last round
        for(int i = 0 ; i < lastRoundLen;i++){
            if(s.charAt(i) == 'a'){
                totalA ++;
            }
        }
       return totalA;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
