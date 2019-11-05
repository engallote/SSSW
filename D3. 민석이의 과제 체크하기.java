import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 1; t <= tc; t++)
        {
        	int N = sc.nextInt();
        	int K = sc.nextInt();
        	
        	Vector<Integer> v = new Vector<>();
        	for(int i = 1; i <= N; i++)
        		v.add(i);
        	
        	for(int i = 0; i < K; i++)
        	{
        		int num = sc.nextInt();
        		if(v.contains(num))
        		{
        			int idx = v.indexOf(num);
        			v.remove(idx);
        		}
        	}
        	String res = "";
        	
        	for(int i : v)
        		res += i + " ";
        	res = res.trim();
        	System.out.println("#" + t + " " + res);
        }
    }
}