import java.util.*;

public class Problem1018 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] mn = sc.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[] arr = new String[m];
        
        for(int i=0; i<m; i++){
            arr[i] = sc.nextLine();
        }//문자열 입력받기
        
        //8*8 샘플링
        int bset_result = 64;
        

        for(int a=0; a<=m-8; a++){      //행 기준 샘플 m-8 회번 할 수 있음
            for(int b = 0; b<n-8; b++){ //열 기준 샘플 n-8회번 할 수 있음
                String[] sample = new String[8];
                for(int idx=0;idx<8;idx++){//        
                    sample[idx] = arr[idx+a].substring(b,b+8);
                }
                int tmp=check(sample);
                if(tmp<bset_result){
                    bset_result = tmp;
                }
            }
        }
        System.out.println(bset_result);

    }
    public static int check(String[] arr){
        //완벽한 체스판에서 얼마나 벗어나있는지 체크하는 함수
        //적게 벗어난 쪽이 덜 노동해야하는 경우일 것이다.

        int count_bw = 64; //bw i짝수* j짝수 일때 b, i짝수* j홀수 일때 w, i홀수 * j짝수 일때 w, i홀수 * j홀수 일때 b
        int count_wb = 64; //wb i짝수* j짝수 일때 w, i짝수* b홀수 일때 b, i홀수 * j짝수 일때 b, i홀수 * j홀수 일때 w
        
        for(int i=0;i<8;i+=2){ //i짝수
            for(int j=0;j<8;j+=2){//j짝수 
                if(arr[i].charAt(j)=='B'){//b인경우
                    count_bw--;
                }
                if(arr[i].charAt(j)=='W'){ //w인경우
                    count_wb--;
                }
            }
            for(int j=1;j<8;j+=2){//j홀수
                if(arr[i].charAt(j)=='B'){//b인경우
                    count_wb--;
                }
                if(arr[i].charAt(j)=='W'){ //w인경우
                    count_bw--;
                }
            }
        }
        for(int i=1;i<8;i+=2){//i홀수
            for(int j=0;j<8;j+=2){//j짝수 
                if(arr[i].charAt(j)=='B'){//b인경우
                    count_wb--;
                }
                if(arr[i].charAt(j)=='W'){ //w인경우
                    count_bw--;
                }
            }
            for(int j=1;j<8;j+=2){//j홀수
                if(arr[i].charAt(j)=='B'){//b인경우
                    count_bw--;
                }
                if(arr[i].charAt(j)=='W'){ //w인경우
                    count_wb--;
                }
            }
        }           
        //카운트가 적은쪽 출력 
        if(count_bw<count_wb){
            return count_bw;
        }else{
            return count_wb;
        }
    }

}
