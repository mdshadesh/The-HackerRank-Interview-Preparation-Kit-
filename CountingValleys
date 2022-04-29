import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int currentSeaLv = 0;
        int countValley = 0;
        boolean downValley = false;
        char currentStep;
        for(int i = 0 ; i < s.length();i++){
            currentStep = s.charAt(i);
            if(currentStep == 'U'){
                if(currentSeaLv == -1 && downValley == true){
                    countValley ++;
                    downValley = false;
                }
                currentSeaLv ++;
            }else if (currentStep == 'D'){
                if(currentSeaLv == 0){
                    downValley = true;
                }
                currentSeaLv --; 
            }
        }
        return countValley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
