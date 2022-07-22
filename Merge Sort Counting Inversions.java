import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static long mergeSortCount(int[] a, int[] aux, int from, int to) {
        if (from >= to) { return 0; }
        int mid = (from + to) >>> 1;
        long count = 0L;
        count += mergeSortCount(a, aux, from, mid);
        count += mergeSortCount(a, aux, mid + 1, to);
        count += merge(a, aux, from, mid, to);
        return count;
    }
    
    private static long merge(int[] a, int[] aux, int from, int mid, int to) {
        System.arraycopy(a, from, aux, from, to - from + 1);
        long count = 0L;
        int i = from, j = mid + 1;
        for (int k = from; k <= to; k++) {
            if (i > mid) {
                a[k] = aux[j++];    
            } else if (j > to) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
                count += mid - i + 1;
            } else {
                a[k] = aux[i++];
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(mergeSortCount(arr, new int[n], 0, n - 1));
        }
    }
}