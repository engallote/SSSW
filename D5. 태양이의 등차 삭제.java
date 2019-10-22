import java.util.*;

public class Main {
	static int res, K, start, startIdx, end;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = Integer.MAX_VALUE;
        	int N = sc.nextInt();
        	K = sc.nextInt();
        	Pair[] arr = new Pair[N];
        	for(int i = 0; i < N; i++)
        		arr[i] = new Pair(sc.nextInt(), i);
        	
        	for(int i = 0; i < N; i++)
        	{
        		start = -1;
        		startIdx = i;
        		end = -1;
        		int idx = 0;
        		Vector<Pair> v = new Vector<>();
        		for(int j = i; j < N; j++)
        		{
        			v.add(new Pair(arr[j].num, idx));
        			idx++;
        		}
        		for(int j = 0; j < i; j++)
        		{
        			v.add(new Pair(arr[j].num, idx));
        			idx++;
        		}
        		while(!v.isEmpty())
            	{
        			if(v.get(2).idx == 0 || v.get(1).idx == 0)
        			{
        				while(v.get(0).idx != 0)
        				{
        					Pair tmp = v.get(0);
        					v.remove(0);
        					v.add(tmp);
        				}
        			}
        			if(v.get(1).num - v.get(0).num == K && v.get(2).num - v.get(1).num == K)
            		{
            			v.remove(0);
            			v.remove(0);
            			v.remove(0);
            			start = -1;
            		}
            		else
            		{
            			Pair tmp = v.get(0);
            			if(start == -1)
            			{
            				start = tmp.num;
            				end = tmp.idx;
            			}
            			else if(start == tmp.num && end == tmp.idx) break;
            			v.remove(0);
            			v.add(tmp);
            		}
//        			System.out.println(start + " " + startIdx + " " +  end);
            		if(v.size() < 3) break;
            	}
        		res = Math.min(res, v.size());
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
    }
}
class Pair{
	int num, idx;
	Pair(int num, int idx)
	{
		this.num = num;
		this.idx = idx;
	}
}