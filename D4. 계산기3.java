import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0, num = 0;
        	int N = sc.nextInt();
        	Stack<Integer> st = new Stack<>();
        	Stack<String> all = new Stack<>();
        	boolean[] chk = new boolean[N];
        	char[] c = sc.next().toCharArray();
        	
        	for(int i = 0; i < N; i++)
        	{
        		if(c[i] == ')')
        		{
        			Arrays.fill(chk, false);
        			int start = 0;
        			for(int j = all.size() - 1; j >= 0; j--)
        				if(all.get(j).equals("("))
        				{
        					start = j;
        					break;
        				}
        			st.clear();
        			for(int j = start + 1; j < all.size(); j++)
        			{
        				if(all.get(j).equals("*"))
        				{
        					if(!chk[j-1] && j + 1 < all.size())
        					{
                				st.push(Integer.parseInt(all.get(j-1)) * Integer.parseInt(all.get(j+1)));
                				chk[j-1] = chk[j+1] = true;
        					}
                			else
                			{
                				int tmp = st.pop();
                				st.push(tmp * (Integer.parseInt(all.get(j+1))));
                				chk[j+1] = true;
                			}
        				}
        			}
        			
        			num = 0;
        			for(int j = start + 1; j < all.size(); j++)
        			{
        				if(!chk[j] && !all.get(j).equals("+") && !all.get(j).equals("*"))
        					num += Integer.parseInt(all.get(j));
        			}
        			
        			while(!st.isEmpty())
        				num += st.pop();
        			
        			for(int j = all.size() - 1; j >= start; j--)
        				all.remove(j);
//        			System.out.println(">>" + num);
        			all.add(Integer.toString(num));
        		}
        		else
        			all.add(c[i]+"");
//        		for(int j = 0; j < all.size(); j++)
//        			System.out.print(all.get(j));
//        		System.out.println();
        	}
        	
//        	for(int i = 0; i < all.size(); i++)
//        		System.out.print(all.get(i));
//        	System.out.println();
        	if(!all.isEmpty())
        	{
        		Arrays.fill(chk, false);
        		st.clear();
        		for(int i = 1; i < all.size(); i+=2)
        		{
        			if(all.get(i).equals("*"))
        			{
        				if(!chk[i-1])
        				{
        					chk[i-1] = chk[i+1] = true;
        					st.add(Integer.parseInt(all.get(i-1)) * Integer.parseInt(all.get(i+1)));
        				}
        				else
        				{
        					chk[i+1] = true;
        					int tmp = st.pop();
        					st.add(tmp * Integer.parseInt(all.get(i+1)));
        				}
        			}
        		}
        		for(int i = 0; i < all.size(); i++)
        		{
        			if(!chk[i] && !all.get(i).equals("+") && !all.get(i).equals("*"))
        				st.add(Integer.parseInt(all.get(i)));
        		}
        		while(!st.isEmpty())
        			res += st.pop();
        	}
        	else
        		res = Integer.parseInt(all.get(0));
        	
        	
        	System.out.println("#" + test_case + " " + res);
        }
    }
}