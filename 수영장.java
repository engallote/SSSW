import java.util.*;

public class Main {
	static int one, month, thrmonth, year, res;
	static int[] arr = new int[12];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	one = sc.nextInt();
        	month = sc.nextInt();
        	thrmonth = sc.nextInt();
        	year = sc.nextInt();
        	res = year;
        	
        	for(int i = 0; i < 12; i++)
        		arr[i] = sc.nextInt();
        	
        	solve(0, 0);
        	
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int idx, int sum) {
		if(idx >= 12)
		{
			res = Math.min(res, sum);
			return;
		}
		
		solve(idx + 1, sum + (arr[idx] * one));
		solve(idx + 1, sum + month);
		solve(idx + 3, sum + thrmonth);
	}
}