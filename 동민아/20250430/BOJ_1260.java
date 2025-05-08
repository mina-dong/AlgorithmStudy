import java.io.*;
import java.util.*;

public class BOJ_1260 {
        static int N,M,V;
        static int graph[][];
        static boolean[] check;
        static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 정점 N
        M = Integer.parseInt(st.nextToken());  // 간선 M
        V = Integer.parseInt(st.nextToken());  // 시작정점v

        graph =   new int[N+1][N+1];

        for (int i=0; i<M; i++){
            //입력받기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 정점 N
            int b = Integer.parseInt(st.nextToken());  // 간선 M

            graph[a][b] = graph[b][a] = 1;
        }

        check  = new boolean[N+1];
        dfs(V);

        System.out.println();

        check  = new boolean[N+1];
        bfs(V);
    }
    public static void dfs (int start) {
        check[start] = true;
        System.out.print(start+" ");

        //노드 수 만큼 반복한다. 0은 채우지 않고 인덱스 기준으로 하기때문에, 4개까지니까 +1을 해야함.
        for(int i=1; i<N+1; i++){
            if(!check[i] && graph[start][i] == 1) {
                    dfs(i);
            }
        }

    }
    public static void bfs (int start) {
        q.add(start); //시작 노드 큐에 추가 - 참고로 큐는 선입선출이다.
        check[start] =  true; // 노드 방문처리
        System.out.print(start+" "); // 방문처리되면 출력한다

        //큐가 비워질때까지 반복한다.
        while(!q.isEmpty()){
            int tmp = q.poll(); // 큐에서 꺼낸다.

            //큐에서 꺼낸 정점과 연결됨 && 아직 방문안함
            for(int i=1; i<N+1; i++){
                if (graph[tmp][i] == 1 && !check[i]){
                    q.add(i); //연결된 정점 큐에 추가
                    check[i] =true;
                    System.out.print(i+" ");
                }
            }

        }
    }

}


//1260
//4 5 1  정점N/ 간선M/ 정점V
//        1 2
//        1 3
//        1 4
//        2 4
//        3 4
//
//첫째줄출력 dfs 깊이 스택/재귀
//두번째출력 bfs 너비 큐

