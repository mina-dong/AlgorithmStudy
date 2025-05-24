import java.io.*;
import java.util.*;

public class BOJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //합을 구할 부분의 개수
        int K = Integer.parseInt(br.readLine());

        for (int z = 0; z < K; z++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;

            for (int r =i; r<x; r++){
                for(int l = j; l<y; l++){
                    sum += arr[r][l];
                }
            }

            System.out.println(sum);
            }

           }
    }


//문제이해... 이 문제가 순차적으로 하나씩 증가하는 시스템이 아니라
// 좌표가 주어지면, 그 사각형내에서 더하는것이 핵심임.

//근데 증가하는 식으로 이해하여 접근함

//이전코드 ---- > 근데 for문 두번돌리는게 직관성 있어서 더 보기 좋고 편리함.
//시작좌표 i,j 부터 최종 x,y 좌표일때까지
//        while (i != x + 1 && j != y + 1) {
//sum = sum + arr[i][j];
//
////제한? 언제 i와 j를 늘릴것인가?
////0 1 2  즉 M-1 에 도달하면 i는 증가,
//// 그리고 j는 초기화.
//j++;
//
//        if (j == M - 1) {
//i++;
//j = 0;
//        }
