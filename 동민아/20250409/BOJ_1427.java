import java.io.*;
import java.util.*;

public class BOJ_1427 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        Integer[] arr = new Integer[input.length];
        for(int i=0; i<input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int n : arr){
            System.out.print(n);
        }
        System.out.println();
    }
}
