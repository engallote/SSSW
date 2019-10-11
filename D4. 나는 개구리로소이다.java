import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 1; t <= tc; t++)
        {
        	Stack<Character>[] st = new Stack[650];
        	int[] arr = new int[5];
        	char[] c = sc.next().toCharArray();
        	int len = c.length;
        	for(int i = 0; i < len; i++)
        	{
        		if(c[i] == 'c')
        			arr[0]++;
        		else if(c[i] == 'r')
        			arr[1]++;
        		else if(c[i] == 'o')
        			arr[2]++;
        		else if(c[i] == 'a')
        			arr[3]++;
        		else arr[4]++;
        	}
        	Arrays.sort(arr);
        	if(arr[0] != arr[4])
        	{
        		System.out.println("#" + t + " " + (-1));
        		continue;
        	}
        	for(int i = 0; i < 650; i++)
        		st[i] = new Stack<>();
        	
        	boolean ok = true;
        	for(int i = 0; i < len; i++)
        	{
        		boolean flag = false;
        		switch(c[i]){
        		case 'c':
        			for(int j = 0; j < 650; j++)
        			{
        				if(st[j].isEmpty() || st[j].peek() == 'k')
        				{
        					st[j].push('c');
        					flag = true;
        					break;
        				}
        			}
        			break;
        		case 'r':
        			for(int j = 0; j < 650; j++)
        			{
        				if(!st[j].isEmpty() && st[j].peek() == 'c')
        				{
        					st[j].push('r');
        					flag = true;
        					break;
        				}
        			}
        			break;
        		case 'o':
        			for(int j = 0; j < 650; j++)
        			{
        				if(!st[j].isEmpty() && st[j].peek() == 'r')
        				{
        					st[j].push('o');
        					flag = true;
        					break;
        				}
        			}
        			break;
        		case 'a':
        			for(int j = 0; j < 650; j++)
        			{
        				if(!st[j].isEmpty() && st[j].peek() == 'o')
        				{
        					st[j].push('a');
        					flag = true;
        					break;
        				}
        			}
        			break;
        		case 'k':
        			for(int j = 0; j < 650; j++)
        			{
        				if(!st[j].isEmpty() && st[j].peek() == 'a')
        				{
        					st[j].push('k');
        					flag = true;
        					break;
        				}
        			}
        			break;
        		}
        		if(!flag)
        		{
        			ok = false;
        			break;
        		}
        	}
        	if(ok)
        	{
        		int cnt = 0;
        		for(int i = 0; i < 650; i++)
        		{
        			if(st[i].isEmpty())
        				break;
        			cnt++;
        		}
        		System.out.println("#" + t + " " + cnt);
        	}
        	else
        		System.out.println("#" + t + " " + (-1));
        }
    }
}