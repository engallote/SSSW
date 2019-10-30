import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] arr = new int[26];
        arr['a' - 'a'] = arr['b' - 'a'] = arr['c' - 'a'] = 2;
        arr['d' - 'a'] = arr['e' - 'a'] = arr['f' - 'a'] = 3;
        arr['g' - 'a'] = arr['h' - 'a'] = arr['i' - 'a'] = 4;
        arr['j' - 'a'] = arr['k' - 'a'] = arr['l' - 'a'] = 5;
        arr['m' - 'a'] = arr['n' - 'a'] = arr['o' - 'a'] = 6;
        arr['p' - 'a'] = arr['q' - 'a'] = arr['r' - 'a'] = arr['s' - 'a'] = 7;
        arr['t' - 'a'] = arr['u' - 'a'] = arr['v' - 'a'] = 8;
        arr['w' - 'a'] = arr['x' - 'a'] = arr['y' - 'a'] = arr['z' - 'a'] = 9;
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0;
        	char[] order = sc.next().toCharArray();
        	int N = sc.nextInt();
        	int len = order.length;
        	for(int i = 0; i < N; i++)
        	{
        		char[] c = sc.next().toCharArray();
        		int len2 = c.length;
        		int idx = 0;
        		if(len != len2) continue;
        		boolean flag = true;
        		for(int j = 0; j < len2; j++)
        		{
        			if(arr[c[j] - 'a'] != order[idx] - '0')
        			{
        				flag = false;
        				break;
        			}
        			idx++;
        			if(idx == len)
        			{
        				break;
        			}
        		}
        		if(flag) res++;
        	}
        	System.out.println("#" + test_case + " " + res);
        }
    }
}