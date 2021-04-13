import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int tesct_case = 1; tesct_case <= T; tesct_case++) {
    		int D = sc.nextInt();//데미지
    		int L = sc.nextInt();//공격 레벨
    		int N = sc.nextInt();//때린 횟수
    		int res = 0;
    		
    		for(int i = 0; i < N; i++)
    			res += D * (1 + i * (L * 0.01));
    		
    		System.out.println("#" + tesct_case + " " + res);
    	}
    }
}