import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int tesct_case = 1; tesct_case <= T; tesct_case++) {
    		int D = sc.nextInt();//������
    		int L = sc.nextInt();//���� ����
    		int N = sc.nextInt();//���� Ƚ��
    		int res = 0;
    		
    		for(int i = 0; i < N; i++)
    			res += D * (1 + i * (L * 0.01));
    		
    		System.out.println("#" + tesct_case + " " + res);
    	}
    }
}