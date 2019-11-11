import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0;
        	char[] ori = sc.next().toCharArray();
        	int len = ori.length;
        	char[] c = new char[len];
        	Arrays.fill(c, '0');
        	
        	for(int i = 0; i < len; i++)
        	{
        		if(c[i] == ori[i]) continue;
        		else
        		{
        			for(int j = i; j < len; j++)
        				c[j] = ori[i];
        			res++;
        		}
        	}
        	System.out.println("#" + test_case + " " + res);
        }
	}
}