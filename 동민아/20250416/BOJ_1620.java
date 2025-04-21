import java.io.*;
import java.util.*;

public class BOJ_1620 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();

        //String[] pokemon = new String[N];

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();


        //포켓몬이름입력
        for(int i=0; i<N; i++){
            String poke = sc.nextLine();
            map1.put(i+1, poke); //번호는 1부터 시작한다.
            map2.put(poke, i+1);
        }

        //문제입력
        for(int i=0; i<M; i++){
            String question = sc.nextLine();

            if(Character.isDigit(question.charAt(0))){
                int number = Integer.parseInt(question);
                System.out.println(map1.get(number));
            }else {
                System.out.println(map2.get(question));
            }
        }
    }
}


//hashmap 을 두 개를 선언한 이유
//키가 들어왔을때 get을 통해 밸류를 반환할수는 있는데
//밸류가 들어올 경우 entryset을 이용해야함 = 계속 순환 = 밸류를 기준으로 키를 가져오지는 못함
//        => 따라서 해쉬맵을 두개 설정하여 처리한다.

//포켓몬 이름에는 숫자가 없기때문에 맨 첫번째만 따와서 숫자여부 판별후 진행.