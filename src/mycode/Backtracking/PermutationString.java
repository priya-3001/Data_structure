package mycode.Backtracking;

import java.util.*;

public class PermutationString {
	public static void main(String[] args) {
		String s = "aba";
		StringBuilder sb = new StringBuilder();
		List<String> res = new ArrayList<>();
		//permute(s, res, sb);
		permuteSwap(s.toCharArray(), res, 0);
		System.out.println(res.toString());
		
		
	}

	private static void permuteSwap(char[] ip, List<String> res, int index) {
		if(index == ip.length) {
			res.add(new String(ip));
			return;
		}
		Set<Character> used = new HashSet<>();
		for(int i = index; i< ip.length;i++) {
			if(used.contains(ip[i]))continue;
			used.add(ip[i]);
			swap(ip, i, index);
			permuteSwap(ip, res, index+1);
			swap(ip, index, i);
		}
	}
	
	private static void swap(char[] ipArr, int index, int i) {
		char tmp = ipArr[index];
		ipArr[index] = ipArr[i];
		ipArr[i] = tmp;
		//return new String(ipArr);
	}

	private static void permute(String ip, List<String> res, StringBuilder sb) {
		if(ip.length() ==0) {
			res.add(sb.toString());return;
		}
		Set<Character> used = new HashSet<>();
		for(int i = 0; i< ip.length();i++) {
			if(used.contains(ip.charAt(i)))continue;
			sb.append(ip.charAt(i));
			used.add(ip.charAt(i));
			String newIp = ip.substring(0, i) + ip.substring(i+1);
			permute(newIp, res, sb);
			sb.setLength(sb.length()-1);
		}
	}
	//
}
