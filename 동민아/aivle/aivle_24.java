import java.io.*;
import java.util.*;

// don't change 'Main' class name and  'public' accessor.

public class aivle_24 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] weight = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
        }

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.add(new int[]{u, v});
        }

        int cost = 0;         // 비용
        boolean changed;      // 반복 내 변화 유무 체크

        do {
            changed = false;  // 반복마다 초기화

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                int diff = Math.abs(weight[u] - weight[v]); // 두 정점의 가중치 차이 계산

                if (diff > K) {
                    int increase = diff - K; // 차이를 줄이기 위해 필요한 증가량

                    // 더 작은 정점의 가중치를 증가
                    if (weight[u] < weight[v]) {
                        weight[u] += increase;
                    } else {
                        weight[v] += increase;
                    }

                    cost += increase;
                    changed = true;
                }
            }

        } while (changed);

        System.out.println(cost);
    }
}