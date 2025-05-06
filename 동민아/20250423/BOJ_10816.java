import java.io.*;
import java.util.*;

public class BOJ_10816 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        int[] findList = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            findList[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int target = findList[i];
            int count = upper(cards, target) - lower(cards, target);
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static int upper(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static int lower(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}



// 숫자카드2
//1번째: 갖고있는 숫자카드 개수 N
//2번째: 숫자카드에 적혀있는 정수
//3번째: M
//4번째: 몇개 갖고있는 숫자카드인지 구해야하는 M개의 정수
//
//-> 이진 탐색까지는 생각이 되는데
//**중복**되는 숫자를 어떻게 탐색하지...
//===>> 1 2 2 2 5 이경우에 2의 하한선인 인덱스1, 2의 상한선인 인덱스3+1 = 4    =>> 4-1 = 3
//-> 해쉬맵 getOfdefault (0, i+1) 방법도 있긴한데 이진탐색 사용
