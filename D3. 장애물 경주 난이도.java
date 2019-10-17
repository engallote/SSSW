import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int up = 0, down = 0;
        	int prev = 0;
        	for(int i = 0; i < N; i++)
        	{
        		int num = sc.nextInt();
        		if(i > 0)
        		{
        			if(prev < num)
        				up = Math.max(up, num - prev);
        			else
        				down = Math.max(down, prev - num);
        		}
        		prev = num;
        	}
        	System.out.println("#" + test_case + " " + up + " " + down);
        }
    }
}