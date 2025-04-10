import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1427 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();
        Integer[] list = new Integer[line.length()];

        for (int i = 0; i < line.length(); i++) {
            int temp = line.charAt(i) - '0';
            list[i] = temp;
        }

        Arrays.sort(list, Collections.reverseOrder());

        for (int i = 0; i < line.length(); i++) {
            System.out.print(list[i]);
        }
    }
}
