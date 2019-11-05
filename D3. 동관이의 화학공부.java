import java.util.*;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	char[] c = sc.next().toCharArray();
        	String res = "-1";
        	Queue<Integer> num = new LinkedList<>();
        	Queue<Character> ch = new LinkedList<>();
        	for(int i = 0; i < c.length; i++)
        	{
        		if(c[i] >= '0' && c[i] <= '9') num.add(c[i]-'0');
        		else ch.add(c[i]);
        	}
        	
        	StringBuilder ans = new StringBuilder();
    		while(!ch.isEmpty() && !num.isEmpty())
    		{
    			char cc = ch.poll();
    			int n = num.poll();
    			if(cc >= 'a' && cc <= 'z')
    			{
    				ch.add(cc);
    				break;
    			}
    			if(!ch.isEmpty() && (cc >= 'A' && cc <= 'Z') && (ch.peek() >= 'a' && ch.peek() <= 'z'))
				{
					ans.append(cc);
					cc = ch.poll();
				}
    			if(!num.isEmpty() && n == 1 && num.peek() == 0)
				{
					num.poll();
					n = 10;
				}
    			if(n == 1)
    				ans.append(cc);
    			else if(n == 0)
    			{
    				ch.add(cc);
    				break;
    			}
    			else
    				ans.append(cc + "" + n);
    		}
//    		System.out.println(ans.toString());
    		if(!ch.isEmpty() || !num.isEmpty()) System.out.println("#" + test_case + " " + res);
    		else
    		{
    			res = ans.toString();
    			System.out.println("#" + test_case + " " + res);
    		}
        }
	}
}