//일곱 난쟁이

import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] dwarfs = new int[9];
        int heights = 0;
        for(int i=0;i<9;i++){
            dwarfs[i] = sc.nextInt();
            heights += dwarfs[i];
        }
        
        Arrays.sort(dwarfs); //오름차순으로 정렬
        
        for(int i=0;i<8;i++){//제외할 난쟁이 1
            for(int j=i+1;j<9;j++){//제외할 난쟁이2
                if(heights - (dwarfs[i] + dwarfs[j]) == 100){
                    for(int k=0;k<9;k++){
                        if(k==i || k==j){ //2명 제외하고 
                            continue;
                        }
                        System.out.println(dwarfs[k]);//출력하기
                    }
                    return;
                }
            }
        }
    }
}