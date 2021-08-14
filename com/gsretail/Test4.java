package com.gsretail;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {
	public static void main(String[] args) {
//		int[] result = solution("AaTa+!12-3");
//		int[] result = solution("aaaaZZZZ)");
//		int[] result = solution("CaCbCgCdC888834A");
		int[] result = solution("UUUUU");
//		int[] result = solution("ZzZz9Z824");
//		int[] result = solution("+++++++");
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(String inp_str) {

        Matcher match;
        List<Integer> list = new ArrayList<Integer>();

        int length = inp_str.length();

        // 1. 8 <= password ���� <= 15
        if (length < 8 || length > 15) {
            list.add(1);
        }

        // 2. 4������ ���� �׷��� ������, �ٸ� � ���ڵ� ���� ��� X
        if (!inp_str.matches("[a-zA-Z\\d~!@#$%^&*]*")) {
            list.add(2);
        }

        // 3. (2.)���� ��õ� 4������ ���� �׷� �߿��� 3���� �̻� ���� �ʼ�
        int chk = 0;
        if (inp_str.matches("^(?=.*[A-Z]).*$")) chk++;
        if (inp_str.matches("^(?=.*[a-z]).*$")) chk++;
        if (inp_str.matches("^(?=.*[0-9]).*$")) chk++;
        if (inp_str.matches("^(?=.*[~!@#$%^&*]).*$")) chk++;

        if (chk < 3) {
            list.add(3);
        }

        // 4. � ���ڶ� ���� ���ڰ� 4�� �̻� ���� X
        String pattern4 = "(.)\\1\\1\\1";
        match = Pattern.compile(pattern4).matcher(inp_str);
        if (match.find()) {
            list.add(4);
        }

        // 5. � ���ڶ� ���� ���ڰ� 5�� �̻� ���� X
        for(int i = 0; i < length; i++) {
            char c = inp_str.charAt(i);
            if (getCount(inp_str, c) >= 5) {
                list.add(5);
                break;
            }
        }

        // ����� ��Ģ�� �ϳ��� ���� ���
        if (list.size() == 0) {
            list.add(0);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static long getCount (String str, char ch) {
        return str.chars().filter(c -> c == ch).count();
    }

}
