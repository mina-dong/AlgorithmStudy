import java.io.*;
import java.util.*;

public class aivle_25 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        char[] data = inputLine.toCharArray();

        // 'x'를 최소 섬이 되도록 처리한 배열과 최대 섬이 되도록 처리한 배열
        char[] min = data.clone();
        char[] max = data.clone();

        // 'x' 처리: 최소 섬은 앞 문자와 같게, 최대 섬은 앞 문자와 다르게
        for (int i = 1; i < data.length; i++) {
            if (data[i] == 'x') {
                min[i] = min[i - 1];
                max[i] = (max[i - 1] == 'o') ? 'g' : 'o';
            }
        }

        // 섬 개수 계산
        int minCount = countIslands(min);
        int maxCount = countIslands(max);

        System.out.println(minCount);
        System.out.println(maxCount);
    }

    // 섬 개수 세는 함수: 'g'로 시작해서 바다(o)로 끊기는 구간마다 count
    public static int countIslands(char[] map) {
        int count = 0;
        boolean inLand = false;

        for (char c : map) {
            if (c == 'g') {
                if (!inLand) {
                    inLand = true;
                    count++;
                }
            } else {
                inLand = false;
            }
        }

        return count;
    }
}
