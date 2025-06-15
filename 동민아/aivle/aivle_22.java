import java.io.*;
import java.util.*;

public class aivle_22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //(1) 입력
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        //(2) stack
        for(int i=0; i< N*2; i++){
            int tmp = Integer.parseInt(st.nextToken());
            // System.out.println("tmp:"+tmp);
            if(!stack.isEmpty()){
                if(stack.peek() == tmp)
                {
                    stack.pop();
                } else{
                    stack.push(tmp);
                }
            }else {
                stack.push(tmp);
            }
            // System.out.println("stack:"+stack);
        }

        //(3)출력
        String result = "NO";
        if (stack.isEmpty()) { result = "YES";}

        System.out.println(result);
    }
}