import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0;
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	
        	Arrays.sort(arr);
        	
        	int idx = N - 1;
        	while(idx > 0)
        	{
        		if(idx - 2 < 0) break;
        		res += arr[idx];
        		idx -= 1;
        		res += arr[idx];
        		idx -= 2;
        	}
        	for(int i = idx; i >= 0; i--)
        	{
//        		System.out.println(arr[i]);
        		res += arr[i];
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
	}
}