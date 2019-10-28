import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int Q = sc.nextInt();
        	int[] arr = new int[N+1];
        	
        	for(int i = 1; i <= Q; i++)
        	{
        		int L = sc.nextInt();
        		int R = sc.nextInt();
        		
        		for(int j = L; j <= R; j++)
        			arr[j] = i;
        	}
        	System.out.print("#" + test_case + " ");
        	for(int i = 1; i <= N; i++)
        		System.out.print(arr[i] + " ");
        	System.out.println();
        }
	}
}