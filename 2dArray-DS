import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = 0;
        for(int c = 0 ; c < 3;c++){
            for(int k = 0; k < 3 ; k ++){
                    if(c == 1){
                        if(k==1){
                            maxSum+= arr[1][1];
                        }
                    }
                    else{
                        maxSum+=arr[c][k];
                    }
            }
        }
        
        for(int curI = 0 ; curI < arr.length-2;curI++){
            for(int curJ = 0 ; curJ < arr[0].length-2;curJ++){
                if(curI == 0 && curJ ==0){
                    continue;
                }
                else{
                    int sum = 0;
                    for(int k = 0; k < 3 ; k ++){
                        for(int l = 0; l < 3; l++){
                            if(k == 1){
                                if(l==1){
                                    sum+= arr[curI+k][curJ+l];
                                    System.out.printf("  %d   ",arr[curI+k][curJ+l]);
                                }
                            }
                            else{
                            sum+= arr[curI+k][curJ+l];
                            System.out.printf("%d ",arr[curI+k][curJ+l]);
                            }
                        }
                        System.out.println();
                    }
                        System.out.printf("Sum = %d\n",sum);
                    if(sum > maxSum) maxSum = sum;
                }
            }
        }

        return maxSum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
