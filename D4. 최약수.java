import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		ArrayList<Long> arr = new ArrayList<>();
		HashSet<Long> hs = new HashSet<>();
		hs.add(1l);
		hs.add(2l);
		arr.add(1l);
		arr.add(2l);
		long num = 0;
		for(int i = 0;; i++)
		{
			num = (long)(20 * (long)Math.pow(10, i));
			if(num > 1000000000) break;
			if(hs.contains(num)) continue;
			arr.add(num);
			hs.add(num);
		}
		for(int i = 0;; i++)
		{
			num = (long)(5 * (long)Math.pow(10, i));
			if(num > 1000000000) break;
			if(hs.contains(num)) continue;
			arr.add(num);
			hs.add(num);
		}
		for(int i = 0;; i++)
		{
			num = (long)(25 * (long)Math.pow(10, i));
			if(num > 1000000000) break;
			if(hs.contains(num)) continue;
			arr.add(num);
			hs.add(num);
		}
		for(int i = 0;; i++)
		{
			num = (long)(125 * (long)Math.pow(10, i));
			if(num > 1000000000) break;
			if(hs.contains(num)) continue;
			arr.add(num);
			hs.add(num);
		}
		for(int i = 1;; i++)
		{
			num = (long)Math.pow(10, i);
			if(num > 1000000000) break;
			if(hs.contains(num)) continue;
			arr.add(num);
			hs.add(num);
		}
		Collections.sort(arr);
//		for(int i = 0; i < arr.size(); i++)
//			System.out.println(arr.get(i));
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int idx = 0;
			for(int i = arr.size() - 1; i >= 0; i--)
				if(arr.get(i) <= N)
				{
					idx = i;
					break;
				}
			System.out.println("#" + test_case + " " + (idx+1));
		}
	}
}