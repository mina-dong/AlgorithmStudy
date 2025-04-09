import java.util.*;

public class Problem1427 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        //0~9 각 자리수 개수 파악
        int[] num_count = new int[] {0,0,0,0,0,0,0,0,0,0};

        for(int i=0;i<input.length();i++){
            num_count[Integer.parseInt(String.valueOf(input.charAt(i)))] +=1;
        }//0~9 각 자리수 개수 덧셈
        
        for(int i=9;i>=0;i--){
            while(num_count[i]>0){
                num_count[i]--;
                System.out.print(i);
            }
        } //자리수 카운팅 된 수만큼 출력
    }
}
