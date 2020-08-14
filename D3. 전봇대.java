import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	int N = sc.nextInt();
        	int[] arr = new int[10001], arr2 = new int[10001];
        	int min = Integer.MAX_VALUE, max = -1;
        	
        	for(int i = 0; i < N; i++){
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		min = Math.min(min, a);
        		max = Math.max(max, a);
        		arr[a] = b;
        		arr2[b] = a;
        	}
        	
        	int res = 0;
        	for(int i = min; i <= max; i++)
        		for(int j = arr[i] - 1; j >= 1; j--){
        			if(arr2[j] > i) ++res;
        		}
        	
        	System.out.println("#" + test_case + " " + res);
        }
	}
}