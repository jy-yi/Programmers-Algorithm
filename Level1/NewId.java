package Level1;

/**
 * 신규 아이디 추천
 * @author jy-yi
 *
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 * 		 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
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

		new_id = new_id.toLowerCase(); // 1단계) 모든 대문자를 소문자로 치환

		String pattern = "[^-_.0-9a-z]";
		new_id = new_id.replaceAll(pattern, ""); // 2단계) 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거

		pattern = "\\.{2,}";
		new_id = new_id.replaceAll(pattern, "."); // 3단계) 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환

		if (new_id.charAt(0) == '.') // 4단계) 마침표(.)가 처음에 위치하면 제거
			new_id = new_id.substring(1);

		if (!"".equals(new_id) && new_id.charAt(new_id.length() - 1) == '.') // 4단계) 마침표(.)가 끝에 위치하면 제거
			new_id = new_id.substring(0, new_id.length() - 1);

		if ("".equals(new_id)) // 5단계) 빈 문자열이라면, new_id에 "a"를 대입
			new_id = "a";

		// 6단계) 길이가 16자 이상이면,
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15); // 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
			if (new_id.charAt(new_id.length() - 1) == '.') // 4단계) 마침표(.)가 끝에 위치하면 제거
				new_id = new_id.substring(0, new_id.length() - 1);
		}

		// 7단계) 길이가 2자 이하이면,
		if (new_id.length() <= 2) {
			while (new_id.length() < 3) {
				new_id += new_id.substring(new_id.length() - 1);
			}
		}

		return new_id;
	}
}
