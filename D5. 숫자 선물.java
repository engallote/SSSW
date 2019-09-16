import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		char[] c, res;
		int x, y, len, len2, under, number;
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	c = sc.next().toCharArray();
            x = sc.nextInt();
            y = sc.nextInt();
            len = c.length;
            res = new char[len];
            len2 = 0;
            under = 0;
            number = 0;
            if(len == 1)//숫자가 한 개일 경우
            {
            	if(y <= c[0] - '0') System.out.println("#" + test_case + " " + y);
            	else if(x <= c[0] - '0' && x != 0) System.out.println("#" + test_case + " " + x);
            	else System.out.println("#" + test_case + " -1");
            	continue;
            }
            System.out.print("#" + test_case + " ");
            
            for(int i = 0; i < len; i++)
            {
            	if(under == 1) //무조건 y를 삽입
            	{
            		res[len2] = (char)(y+'0');
            		number += y;
            		len2++;
            	}
            	else if(c[i] - '0' >= y)
                {
            		if(c[i] - '0' > y) //현재 수보다 작으면 뒷자리 수 상관 없이 y값 삽입
            		{
            			res[len2] = (char)(y+'0');
            			under = 1;
            			number += y;
                        len2++;
            		}
            		else if(i + 1 < len && c[i + 1] - '0' >= x)//현재 수와 같고 다음 수가 x 이상
            		{
            			res[len2] = (char)(y+'0');
            			number += y;
                        len2++;
            		}
            		else if(i + 1 < len && c[i + 1] - '0' < x)//현재 수와 같고 다음 수가 x 미만
            		{
            			res[len2] = (char)(x+'0');
            			number += x;
            			len2++;
            			under = 1;
            		}
            		else//마지막 수
            		{
            			res[len2] = (char)(y + '0');
            			len2++;
            			number += y;
            		}
                }
            	else if(c[i] -'0' >= x)
            	{
                    if(len2 == 0 && x == 0)//처음인데 x가 0일 경우
                    {
                    	under = 1;
                    	continue;
                    }
            		if(c[i] - '0' > x)//현재 수가 x보다 큼
            		{
            			under = 1;
            			res[len2] = (char)(x+'0');
            			number += x;
                        len2++;
            		}
            		else if(i + 1 < len && c[i+1] - '0' >= x)//현재 수가 x와 같고 다음 수가 x 이상
            		{
            			number += x;
            			res[len2] = (char)(x+'0');
            			len2++;
            		}
            		else if(i + 1 < len && c[i+1] - '0' < x)//현재 수가 x와 같고 다음 수가 x 미만
            		{
            			if(len2 - 1 >= 0 && res[len2 - 1] - '0' == y)//다음 수가 x 미만이고 이전 수가 y
                		{
                			res[len2 - 1] = (char)(x + '0');
                			res[len2] = (char)(y + '0');
                			len2++;
                			under = 1;
                			number += y;
                		}
                		else if(len2 - 1 >= 0 && res[len2 - 1] - '0' == x)//다음 수가 x 미만이고 이전 수가 x
                		{
                			int idx = len2 - 1;
                			under = 1;
                			while(idx >= 0 && res[idx] - '0' == x)
                			{
//                				System.out.println(idx + " " + res[idx]);
                				res[idx] = (char)(y + '0');
                				idx--;
                			}
                			if(idx >= 0 && res[idx] - '0' == y)
                			{
                				res[idx] = (char)(x + '0');
                				res[len2] = (char)(y + '0');
                				len2++;
                			}
                		}
                		else//현재 수가 x이고 다음 수가 x 미만이면서 처음 수
                			under = 1;
            		}
            		else//마지막 수
            		{
            			res[len2] = (char)(x + '0');
            			len2++;
            			number += x;
            		}
            	}
            	else
            		under = 1;
            }
            
            if(number == 0)
            {
            	System.out.println("-1");
            	continue;
            }
            System.out.println(new String(res).substring(0, len2));
            System.out.println(len + " " + new String(res).substring(0, len2).length());
        }
    }
}