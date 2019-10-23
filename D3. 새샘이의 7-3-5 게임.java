import java.util.*;

public class Main {
	static int res;
	static int[] arr;
	static Vector<Integer> v = new Vector<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	v.clear();
        	arr = new int[7];
        	res = 0;
        	for(int i = 0; i < 7; i++)
        		arr[i] = sc.nextInt();
        	
        	solve(0, 0, 0);
        	v.sort(null);
        	
        	int cnt = 0;
        	for(int i = v.size() - 1; i >= 0; i--)
        	{
        		cnt++;
        		if(cnt == 5)
        		{
        			res = v.get(i);
        			break;
        		}
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int idx, int cnt, int sum) {
		if(cnt == 3)
		{
			if(!v.contains(sum))
				v.addElement(sum);
			return;
		}
		if(idx == 7) return;
		
		solve(idx + 1, cnt, sum);
		solve(idx + 1, cnt + 1, sum + arr[idx]);
	}
}