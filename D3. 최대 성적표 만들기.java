import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int K = sc.nextInt();
        	int res = 0;
        	int[] arr = new int[N];
        	
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	
        	Arrays.sort(arr);
        	
        	int idx = N-1;
        	while(K > 0)
        	{
        		res += arr[idx];
        		idx--;
        		K--;
        	}
        	System.out.println("#" + test_case + " " + res);
        }
	}
}