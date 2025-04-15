//체스판 다시 칠하기

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); //체스판 세로 
        int M = sc.nextInt(); //체스판 가로
        sc.nextLine();
        
        int min = Integer.MAX_VALUE;
        
        String[] board = new String[N];
        
        for(int i=0;i<N;i++){
            board[i] = sc.nextLine();
        }
        //1행 1열부터 8개씩 n-8행 n-8열까지 모두 탐색
        
        for(int i=0;i<N-7;i++){ //부분배열의 행 시작인덱스
            for(int j=0;j<M-7;j++){//부분배열의 열 시작인덱스
                
                int BSum = 0; //B부터 시작할 경우 고쳐야 할 개수
                int WSum = 0; //W부터 시작할 경우 고쳐야 할 개수
                
                for(int k=0;k<8;k++){//배열 탐색
                    
                    String row = board[i+k].substring(j,j+8);
                    for(int l=0;l<8;l++){
                        if ((k+l)%2==0){// 배열의 홀수 칸이
                            if (row.charAt(l)=='W'){ //W일 경우
                                BSum+=1;
                            } else{
                                WSum+=1;
                            }
                        } else{// 배열의 짝수 칸이
                            if (row.charAt(l)=='B'){ //W일 경우
                                BSum+=1;
                            } else{
                                WSum+=1;
                            }
                        }
                    }
                }
                min = Math.min(min,Math.min(WSum,BSum));
            }
        }
        System.out.print(min);
    }
}