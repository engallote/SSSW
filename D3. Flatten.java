import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        
        while(tc <= 10)
        {
        	int dump = sc.nextInt();
        	int[] arr = new int[100];
        	Vector<Integer> v = new Vector<>();
        	
        	for(int i = 0; i < 100; i++)
        		v.add(sc.nextInt());
        	v.sort(null);
        	
        	while(dump > 0)
        	{
        		int a = v.get(0);
        		int b = v.get(v.size()-1);
        		if(a == b) break;
        		a++;
        		b--;
        		v.remove(v.size()-1);
        		v.remove(0);
        		v.add(a);
        		v.add(b);
        		v.sort(null);
        		dump--;
        	}
        	System.out.println("#" + tc + " " + (v.get(v.size()-1) - v.get(0)));
        	tc++;
        }
    }
}