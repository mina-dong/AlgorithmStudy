import java.io.*;
import java.util.*;

public class BOJ_2178 {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};  // 상하좌우
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }

        bfs(0, 0);

        System.out.println(arr[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int currentX = tmp[0] + dx[i];
                int currentY = tmp[1] + dy[i];

                if (currentX >= 0 && currentY >= 0 && currentX < N && currentY < M) {
                    if (arr[currentX][currentY] == 1 && !visited[currentX][currentY]) {
                        visited[currentX][currentY] = true;
                        arr[currentX][currentY] = arr[tmp[0]][tmp[1]] + 1;
                        queue.offer(new int[]{currentX, currentY});
                    }
                }
            }
        }
    }
}



//bfs가 적격인지 dfs가 적격인지?
//dfs 스택 - 한 방향만 파다가 - 안되면 백트래킹
//bfs 큐 - 넓게 퍼지듯, 인근 노드 전부 방문 - 한번에 모든 경로를 탐색한다