//소트인사이드
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int[] nums = new int[N.length()];
        for(int i=0;i<nums.length;i++){ //숫자들을 분리시켜 정수배열에 담기
            nums[i] = N.charAt(i)-'0';
        }
        //선택정렬 내림차순으로
        nums=selectionSort(nums);
        
        for(int i:nums) System.out.print(i);
        
        
    }
    //선택정렬
    public static int[] selectionSort(int[] arr){
        int len = arr.length;
        for(int i=0;i<len-1;i++){
            int max = arr[i],max_idx=i;
            int j;
            for(j=i+1;j<len;j++){
                
                if (max <arr[j]){
                    max_idx = j;
                    max = arr[j];
                }
            }
            arr[max_idx] = arr[i];
            arr[i] = max;
        }
        return arr;
    }
   
    
}