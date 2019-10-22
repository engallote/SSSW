import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int[][] arr = new int[4][14];
        	int s = 13, d = 13, h = 13, c = 13;
        	boolean flag = true;
        	char[] str = sc.next().toCharArray();
        	
        	for(int i = 0; i < str.length; i+=3)
        	{
        		char t = str[i];
        		int num = Integer.parseInt((str[i+1] + "" + str[i+2]));
        		if(t == 'S')
        		{
        			s--;
        			arr[0][num]++;
        			if(arr[0][num] > 1)
        			{
        				flag = false;
        				break;
        			}
        		}
        		else if(t == 'D')
        		{
        			d--;
        			arr[1][num]++;
        			if(arr[1][num] > 1)
        			{
        				flag = false;
        				break;
        			}
        		}
        		else if(t == 'H')
        		{
        			h--;
        			arr[2][num]++;
        			if(arr[2][num] > 1)
        			{
        				flag = false;
        				break;
        			}
        		}
        		else
        		{
        			c--;
        			arr[3][num]++;
        			if(arr[3][num] > 1)
        			{
        				flag = false;
        				break;
        			}
        		}
        	}
        	
        	if(flag)
        		System.out.println("#" + test_case + " " + s + " " + d + " " + h + " " + c);
        	else
        		System.out.println("#" + test_case + " " + "ERROR");
        }
	}
}