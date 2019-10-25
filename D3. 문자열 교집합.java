import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0;
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	HashSet<String> hs = new HashSet<>();
        	for(int i = 0; i < N; i++)
        		hs.add(sc.next());
        	
        	for(int i = 0; i < M; i++)
        	{
        		String s = sc.next();
        		if(hs.contains(s))
        			res++;
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
	}
}