import java.io.*;
import java.util.*;

public class BOJ_1018 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String [] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

//        체스판 자르기 - 8*8 형태로 쪼개서 비교하는 방법

        int sol = Integer.MAX_VALUE;
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                //현 체스판의 최소 비용
                int curSol = getSolution(i,j,arr);

                //전체 최적의 값과 비교
                if (sol > curSol) sol = curSol;
            }
        }

        System.out.println(sol);

    }

    public static int getSolution(int row, int col, String[] board){
        String[] originBoard = {"WBWBWBWB","BWBWBWBW"};
        int whiteSol = 0;

        for(int i=0; i<8; i++){
            int r = row+i;
            for(int j=0; j<8; j++) {
                int c = col+j;
                if(board[r].charAt(c) != originBoard[r%2].charAt(j))whiteSol++;
            }
        }
        return Math.min(whiteSol, 64-whiteSol );
    }
}

////최소 칠해야하는 개수?
//>>언제 칠해야하는데? 상하좌우가 나랑 같을때... 이겠지?
//나는 맨 왼쪽 위 칸이 흰색인 경우
//
//대각선의 기준인가?
//==> 2*2 기준으로 봤을때 블랙이 먼저 시작하는 체스판을만든다고 가정하면, cnt:0일때
//반대로 화이트 체스판은cnt:4 라는 결과가 나온다. 즉, 이 0+4 = 2*2 라는 같은 경우의 수를 의미한다...
