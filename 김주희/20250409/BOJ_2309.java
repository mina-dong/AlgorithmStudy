import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2309 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] list = new int[9];
        int idx1 = 0;
        int idx2 = 0;
        int sum = 0;
        boolean found = false;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
            sum += num;
        }

        Arrays.sort(list);

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - (list[i] + list[j]) == 100) {
                    idx1 = i;
                    idx2 = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == idx1 || i == idx2) {
                continue;
            } else {
                System.out.println(list[i]);
            }
        }
    }
}
