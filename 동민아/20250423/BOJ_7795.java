import java.io.*;
import java.util.*;

public class BOJ_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // A의 수
            int M = Integer.parseInt(st.nextToken());  // B의 수

            int[] A = new int[N];
            int[] B = new int[M];

            // A 배열 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // B 배열 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // B 배열 정렬 (이분 탐색 준비)
            Arrays.sort(B);

            int count = 0;
            for (int i = 0; i < N; i++) {
                count += lowerBound(B, A[i]);
            }

            System.out.println(count);
        }
    }

    // lowerBound: target보다 작은 값의 개수를 반환
    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    }
}

//이걸 꼭 이진탐색으로 풀어야하나..


//먹을 것인가 먹힐 것인가
//조건 자체가 a가 크고 b가 작아야함 = 한쪽만 검색하면 된다.
//입력
//2 - 테스트 케이스
//        5 3 - a의 수 N , b의 수 M
//        8 1 7 3 1 - a의 크기
//        3 6 1 - b의 크기
//        3 4 - 두번째 테스트  n,m
//        2 13 7
//        103 11 290 215
//
//출력:
//            7
//            1