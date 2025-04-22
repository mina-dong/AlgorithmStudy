import java.io.*;
import java.util.*;

public class BOJ_10773 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int N=sc.nextInt();

        for(int i=0; i<N; i++){
            int num = sc.nextInt();

            if (num !=0){
                s.push(num);
            }else {
                s.pop();
            }

        }

        int result =0;
        while (!s.isEmpty()){
           result += s.pop();
        }
        System.out.println(result);

    }
}

// 스택 pop push peek isEmpty

//재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
//재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합
//첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000) 이후 K개의 줄에 정수가 1개씩.
//정수는 0에서 1,000,000 사이의 값을 가지며,
//정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
//
//정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.

//[1]
//        [1,3]
//        [1,3,5]
//        [1,3,5,4]
//        [1,3,5] (0을 불렀기 때문에 최근의 수를 지운다)
//        [1,3] (0을 불렀기 때문에 그 다음 최근의 수를 지운다)
//        [1,3,7]
//        [1,3] (0을 불렀기 때문에 최근의 수를 지운다)
//        [1] (0을 불렀기 때문에 그 다음 최근의 수를 지운다)
//        [1,6]

