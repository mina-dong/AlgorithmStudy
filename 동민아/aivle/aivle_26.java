import java.util.*;

public class aivle_26 {

    static final int N = 3;
    static final int[] dx = {-1, 1, -2, -2, 2, 2, -1, 1};
    static final int[] dy = {2, 2, 1, -1, -1, 1, -2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder startSb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            startSb.append(line);
        }
        String start = startSb.toString();

        // 목표 상태: 흰색(1)과 검정색(2) 위치 뒤집기
        StringBuilder goalSb = new StringBuilder();
        for (char c : start.toCharArray()) {
            if (c == '1') goalSb.append('2');
            else if (c == '2') goalSb.append('1');
            else goalSb.append('0');
        }
        String goal = goalSb.toString();

        if (bfs(start, goal)) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
    }

    static boolean bfs(String start, String goal) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if (cur.equals(goal)) return true;

            // 현재 상태에서 가능한 모든 이동 생성
            for (String next : getNextStates(cur)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return false;
    }

    static List<String> getNextStates(String state) {
        List<String> nextStates = new ArrayList<>();
        char[] board = state.toCharArray();

        for (int i = 0; i < board.length; i++) {
            char piece = board[i];
            if (piece == '1' || piece == '2') {
                int x = i / N;
                int y = i % N;

                for (int dir = 0; dir < 8; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        int nIdx = nx * N + ny;
                        if (board[nIdx] == '0') { // 빈 칸으로 이동 가능
                            char[] nextBoard = board.clone();
                            nextBoard[nIdx] = piece;
                            nextBoard[i] = '0';
                            nextStates.add(new String(nextBoard));
                        }
                    }
                }
            }
        }

        return nextStates;
    }
}
