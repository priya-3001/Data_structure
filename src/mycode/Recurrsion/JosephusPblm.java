package mycode.Recurrsion;

import java.util.*;

public class JosephusPblm {
	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i<=n;i++)
			list.add(i);
		k = k-1;
		int[] ans = new int[1];
		solve(list, k, 0, ans);
		System.out.println("Result "+ ans[0]);
	}

	private static void solve(List<Integer> list, int k, int index, int[] ans) {
		if(list.size() == 1) {
			ans[0] = list.get(list.size()-1);
			return;
		}
		index = (index + k)%list.size();
		list.remove(index);
		solve(list, k, index, ans);
	}

}
