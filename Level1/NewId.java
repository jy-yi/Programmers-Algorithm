package Level1;

/**
 * �ű� ���̵� ��õ
 * @author jy-yi
 *
 * 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
 * 2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
 * 3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
 * 4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
 * 5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
 * 6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
 * 		 ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
 * 7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
 */
public class NewId {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println("-----------");
		System.out.println(solution("z-+.^."));
		System.out.println("-----------");
		System.out.println(solution("=.="));
		System.out.println("-----------");
		System.out.println(solution("123_.def"));
		System.out.println("-----------");
		System.out.println(solution("abcdefghijklmn.p"));

	}

	public static String solution(String new_id) {

		new_id = new_id.toLowerCase(); // 1�ܰ�) ��� �빮�ڸ� �ҹ��ڷ� ġȯ

		String pattern = "[^-_.0-9a-z]";
		new_id = new_id.replaceAll(pattern, ""); // 2�ܰ�) ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� ����

		pattern = "\\.{2,}";
		new_id = new_id.replaceAll(pattern, "."); // 3�ܰ�) ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ

		if (new_id.charAt(0) == '.') // 4�ܰ�) ��ħǥ(.)�� ó���� ��ġ�ϸ� ����
			new_id = new_id.substring(1);

		if (!"".equals(new_id) && new_id.charAt(new_id.length() - 1) == '.') // 4�ܰ�) ��ħǥ(.)�� ���� ��ġ�ϸ� ����
			new_id = new_id.substring(0, new_id.length() - 1);

		if ("".equals(new_id)) // 5�ܰ�) �� ���ڿ��̶��, new_id�� "a"�� ����
			new_id = "a";

		// 6�ܰ�) ���̰� 16�� �̻��̸�,
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15); // ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� ����
			if (new_id.charAt(new_id.length() - 1) == '.') // 4�ܰ�) ��ħǥ(.)�� ���� ��ġ�ϸ� ����
				new_id = new_id.substring(0, new_id.length() - 1);
		}

		// 7�ܰ�) ���̰� 2�� �����̸�,
		if (new_id.length() <= 2) {
			while (new_id.length() < 3) {
				new_id += new_id.substring(new_id.length() - 1);
			}
		}

		return new_id;
	}
}
