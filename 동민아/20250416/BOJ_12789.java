import java.io.*;
import java.util.*;

public class BOJ_12789 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        for(int i =0; i<N; i++){
            q.offer(sc.nextInt());
        }

        int start = 1; //시작인덱스


        //1. 먼저 큐를 순회하면서 조건에 맞지 않는다면, 스택에 넣음
        while(!q.isEmpty()){
            if(q.peek() == start){
                q.poll();
                start++;
            } else if (!s.isEmpty() && s.peek() == start){
                //추가대기열이 비어있찌 않고, 간식을 받아야하는 사람과 같다면
                s.pop();
                start++;
            }else {
                s.push(q.poll());
            }
        }

        while(!s.isEmpty()){
            if(s.peek() ==  start){
                s.pop();
                start++;
            } else{
                System.out.println("Sad");
                return;
            }
        }

        //방해받지 않고 끝났다면
        System.out.println("Nice");


    }
}

// 큐인가? 선입선출
//5
//5 4 1 3 2