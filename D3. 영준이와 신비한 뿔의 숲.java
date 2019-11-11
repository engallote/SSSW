import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res1 = 0, res2 = 0;
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	
        	for(int i = M; i >= 0; i--)
        	{
        		int tmp = i * 2;
        		if((N - tmp) + i == M)
        		{
        			res1 = (N - tmp);
        			res2 = i;
        			break;
        		}
        	}
        	
        	System.out.println("#" + test_case + " " + res1 + " " + res2);
        }
	}
}