import java.io.*;
import java.util.*;

public class BOJ_2309 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        int idx1 =0;
        int idx2 =0;
        //일곱난쟁이의 합은 100 = 아홉명에서 2명을 뺀다
        //찾을 수 없는 경우는 없다.
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                //진짜난쟁이로만 이루어진 경우 = 100을 만족함
                if (sum - arr[i] - arr[j] == 100) {
                    idx1 =i;
                    idx2=j;
                    break;
                }
            }
        }

        //idx1, idx2를 제외한 나머지를 출력.
        for(int i=0; i<arr.length; i++){
            if (i != idx1 && i!= idx2) {
                System.out.println(arr[i]);
            }
        }


    }
}
