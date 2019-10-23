import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 1;
        	int N = sc.nextInt();
        	Stack<Character> st = new Stack<>();
        	char[] c = sc.next().toCharArray();
        	int len = c.length;
        	
        	for(int i = 0; i < len; i++)
        	{
        		switch(c[i])
        		{
        		case '(':
        		case '[':
        		case '{': st.push(c[i]); break;
        		case ')':
        			if(st.isEmpty()) res = 0;
        			else
        			{
        				if(st.peek() == '(') st.pop();
        				else res = 0;
        			}
        			break;
        		case ']':
        			if(st.isEmpty()) res = 0;
        			else
        			{
        				if(st.peek() == '[') st.pop();
        				else res = 0;
        			}
        			break;
        		case '}':
        			if(st.isEmpty()) res = 0;
        			else
        			{
        				if(st.peek() == '{') st.pop();
        				else res = 0;
        			}
        			break;
        		}
        		if(res == 0) break;
        	}
        	if(!st.isEmpty()) res = 0;
        	System.out.println("#" + test_case + " " + res);
        }
    }
}