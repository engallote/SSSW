import java.util.*;

public class Solution{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int test_case = 1; test_case <= T; test_case++) {
    		int N = sc.nextInt();
    		int[] arr = new int[N];
    		int res = 0;
    		
    		for(int i = 0; i < N; i++) {
    			arr[i] = sc.nextInt();
    			
    			if(i > 1) {
    				if(arr[i-1] > arr[i-2] && arr[i-1] > arr[i]) continue;
    				if(arr[i-1] < arr[i-2] && arr[i-1] < arr[i]) continue;
    				++res;
    			}
    		}
    		
    		System.out.println("#" + test_case + " " + res);
    	}
    }
}