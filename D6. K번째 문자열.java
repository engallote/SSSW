import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        Vector<String> v = new Vector<>();
        HashSet<String> hs = new HashSet<>();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	v.clear();
        	hs.clear();
        	int N = sc.nextInt() - 1;
        	char[] c = sc.next().toCharArray();
        	int len = c.length;
        	StringBuilder tmp;
        	for(int i = 0; i < len; i++)
        	{
        		tmp = new StringBuilder();
        		tmp.append(c[i]);
        		if(!hs.contains(tmp.toString()))
        		{
        			hs.add(tmp.toString());
        			v.add(tmp.toString());
        		}
        		for(int j = i + 1; j < len; j++)
        		{
        			tmp.append(c[j]);
        			if(!hs.contains(tmp.toString()))
        			{
        				hs.add(tmp.toString());
            			v.add(tmp.toString());
        			}
        		}
        	}
        	
        	v.sort(null);
//        	for(String s : v)
//        		System.out.println(s);
        	if(v.size() <= N)
        		System.out.println("#" + test_case + " none");
        	else
        		System.out.println("#" + test_case + " " + v.get(N));
        }
    }
}