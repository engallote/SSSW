import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int K = sc.nextInt();
        	char[] c = sc.next().toCharArray();
        	
        	long res = 0;
        	String tmp = "";
        	HashSet<String> hs = new HashSet<>();
        	PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        	int num = N / 4, idx = 0;
        	
        	boolean flag = true;
        	while(true)
        	{
        		flag = false;
        		idx = 0;
        		while(idx < N)
        		{
        			tmp = "";
        			for(int j = idx; j < idx + num; j++)
        				tmp += "" + c[j];
        			if(!hs.contains(tmp))
        			{
        				flag = true;
        				hs.add(tmp);
        			}
        			idx += num;
        		}
        		
        		if(!flag) break;
        		
        		char f = c[N - 1];
        		for(int i = N - 1; i > 0; i--)
        			c[i] = c[i - 1];
        		c[0] = f;
        	}
        	
        	Iterator<String> it = hs.iterator();
        	while(it.hasNext())
        		pq.add(it.next());
        	
        	while(K-- > 1)
        	{
        		pq.poll();
//        		System.out.println(">" + pq.poll());
        	}
//        	System.out.println(pq.peek());
        	char[] ch = pq.peek().toCharArray();
        	long x = 1;
        	for(int i = ch.length - 1; i >= 0; i--)
        	{
        		if(ch[i] >= '0' && ch[i] <= '9') res += ((ch[i] - '0') * x);
        		else
        		{
        			switch(ch[i]){
        			case 'A': res += (10 * x); break;
        			case 'B': res += (11 * x); break;
        			case 'C': res += (12 * x); break;
        			case 'D': res += (13 * x); break;
        			case 'E': res += (14 * x); break;
        			case 'F': res += (15 * x); break;
        			}
        		}
//        		System.out.println(res);
        		x *= 16;
        	}
        	
            System.out.println("#" + test_case + " " + res);
        }
	}
}