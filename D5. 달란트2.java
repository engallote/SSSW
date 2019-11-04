import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	long N = sc.nextLong();
        	long M = sc.nextLong();
        	long res = 0;
        	if(N % M == 0)
        		res = (long)Math.pow(N / M, M);
        	else
        	{
        		long num = N / M, num2 = num + 1;
        		long N2 = N, tmp;
        		for(int i = 1; i <= M; i++)
        		{
        			N2 -= num;
        			tmp = N2 % num2;
        			int count = (int) (i + (N2 / num2) + (tmp == 0 ? 0 : 1));
        			if(count != M) continue;
//        			System.out.println(N2 + " " + tmp);
        			long mul = (long)Math.pow(num, i) * (long)Math.pow(num2, N2 / num2) * (tmp == 0 ? 1 : tmp);
//        			System.out.println((long)Math.pow(num, i) + " " + (long)Math.pow(num2, N2 / num2) + " " + (tmp == 0 ? 1 : tmp));
//        			System.out.println(mul);
        			res = Math.max(res, mul);
        		}
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
	}
}