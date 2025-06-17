import java.io.*;
import java.util.*;

public class aivle_23 {
    static boolean[][] arr;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수

        arr = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            arr[one][two] = true;
        }

        visited = new boolean[N + 1];
        visited[1] = true;

        String result = "NO";

        for (int i = 1; i <= N; i++) {
            if (arr[1][i]) {
                if (dfs(i, 1)) {
                    result = "YES";
                    break;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean dfs(int now, int depth) {
        if (now == 1 && depth >= 2) {
            return true;
        }

        visited[now] = true;

        for (int next = 1; next <= N; next++) {
            if (arr[now][next]) {
                if (!visited[next] || (next == 1 && depth >= 1)) {
                    if (dfs(next, depth + 1)) {
                        return true;
                    }
                }
            }
        }

        visited[now] = false; // 백트래킹
        return false;
    }
}
