import java.io.*;
import java.util.*;

public class BOJ_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        N x N 배열을 만들고, 자기 자신과의 거리는 0 직접 연결된 친구끼리는 1 그 외에는 INF로 설정
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 친구관계

        int[][] dp = new int[N + 1][N + 1];

        //1. 초기화
        //1-1 자기자신은 =0, 나머지는 최대값 9999999
        int INF = 9999999;
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        //1-2 양방향이니까 1 넣기.
        for (int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dp[x][y] = 1;
            dp[y][x] = 1;
        }

        //플로이드 워셜 알고리즘
        //i 시작 k 경유 j 종착
        for (int k = 1; k < N+1; k++) {
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {
                    if(dp[i][j] > dp[i][k]+dp[k][j]){
                        dp[i][j] = dp[i][k]+dp[k][j];
                    }
                }
            }
        }

        int result = 0;
        int ex = INF;
        // 케빈 베이컨의 수가 가장 작은 사람을 출력한다.
        for(int i=1; i<N+1; i++){
            int sum=0;
            for(int j=1; j<N+1; j++){
                sum += dp[i][j];
            }
            //한바퀴 순회 종료후
            //sum이 이전 sum보다 작으면 바꾼다.
            if( sum < ex ){
                ex = sum;
                result = i;
            }
        }

        System.out.println(result);

    }
}



//플로이드 워셜 알고리즘 = 모든 정점 간의 최단 거리
//그래프 초기화

//[[[j][i] 안하는 이유? 어차피 전체 순회해서..
//그러면 삼각형모양으로 대칭이지 않나?
//i → k → j 와
//j → k → i 는 같은 거리가 아닐 수 있어!
//그리고 노드느 N개까지이기 때문에, 순회범위는 N개까지임!
//
//
//왜 n*M 이 아닌가?
//m은 간선이 개수 = 즉 배열안에 저장되는 용도고,
//노드는 N개로 정해져있으니까 n*N 이 맞음
//int[][] dp = new int[N + 1][N + 1];
//
//
//케빈 베이컨의 수가 가장 작은 사람을 출력한다.
//이건 어떻게출력하지? 1-2, 1-3, 1-4 .. 이걸 다 정해야하는데
//이것도 포문 돌릴까
//i는 1부터 시작해서 j만 바뀌는식으로, 그리고 저장한다!! 그리고 최소값발견시변경!!
//
//
//왜 틀렸지..? 하고보니까
//최소 횟수가 아닌 사람 번호라서 잘못 출력함.