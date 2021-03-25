package Level2;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ųƮ��
 * @author jy-yi
 *
 * ���� ��ų�̶� � ��ų�� ���� ���� ���� ����� �ϴ� ��ų�� ���մϴ�.
 * ���� ��� ���� ��ų ������ ����ũ �� ����Ʈ�� ��Ʈ �� ����϶�, 
 * ����� ������ ���� ����Ʈ�� ��Ʈ�� ����� �ϰ�, ����Ʈ�� ��Ʈ�� ������ ���� ����ũ�� ����� �մϴ�.
 * 
 * �� ������ ���� �ٸ� ��ų(���� ��)�� ������ ������� ��� �� �ֽ��ϴ�. 
 * ���� ����ũ �� ���� �� ����Ʈ�� ��Ʈ �� ����� ���� ��ųƮ���� ����������, 
 * ��� �� ����ũ�� ����Ʈ�� ��Ʈ �� ����ũ �� ���� �� ����� ���� ��ųƮ���� �Ұ����մϴ�.
 * 
 * ���� ��ų ���� skill�� �������� ���� ��ųƮ��1�� ���� �迭 skill_trees�� �Ű������� �־��� ��, 
 * ������ ��ųƮ�� ������ return �ϴ� solution �Լ��� �ۼ����ּ���.
 */
public class SkillTree {
	public static void main(String[] args) {
		SkillTree st = new SkillTree();

		String skill = "BDC";
//		String[] skill_trees = {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};
		String[] skill_trees = {"AAAABACA"};

		System.out.println(st.solution(skill, skill_trees));
	}

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		Map<String, Integer> skillMap = new HashMap<String, Integer>();

		/* ���� ��ų ���� */
		for (int i = 0; i < skill.length(); i++) {
			skillMap.put(skill.substring(i, i + 1), i);
		}

		for (String s : skill_trees) {
			boolean[] isAllSkill = new boolean[skillMap.size()];

			Loop1: for (int i = 0; i <= s.length() - 1; i++) {
				String prev = s.substring(i, i + 1); // ���� ù��° ��ų

				/* ���� ��ų�� ������ ��� ���� ��� �� �ִ� ��ų�� ��� */
				if (!skillMap.containsKey(prev)) {
					if (prev.equals(s.substring(s.length() - 1))) {
						answer++;
					}
					continue;
				} else {
					isAllSkill[skillMap.get(prev)] = true;
					for (int j = i + 1; j < s.length(); j++) {
						String next = s.substring(j, j + 1); // ���� �ι�° ��ų

						/* �Ұ����� ��ų Ʈ�� */
						if (skillMap.containsKey(next) && skillMap.get(prev) > skillMap.get(next)) {
							break Loop1; // ���� ��ųƮ��1�� Ż��
						}
					}

					/* ���������� �� �Ϸ��� ��� */
					if (prev.equals(s.substring(s.length() - 1))) {
						answer++;
						for (int j = 1; j < isAllSkill.length; j++) {
							if (!isAllSkill[j-1] && !isAllSkill[j]) {
								answer--;
								break;
							}
						}
					}
				}
			}
		}

		return answer;
	}
}
