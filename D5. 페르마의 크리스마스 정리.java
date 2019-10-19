import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        boolean[] chk = new boolean[1000001];
        chk[0] = chk[1] = true;
        for(int i = 2; i <= 1000000; i++)
        {
        	if(chk[i]) continue;
        	for(int j = i + i; j <= 1000000; j+=i)
        		chk[j] = true;
        }
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	long res = 0;
        	int L = sc.nextInt();
        	int R = sc.nextInt();
        	
        	for(int i = L; i <= R; i++)
        	{
        		if(!chk[i] && i % 4 == 1)
        		{
        			res++;
//        			System.out.println(i);
        		}
        		if(i == 2)
        			res++;
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
    }
}