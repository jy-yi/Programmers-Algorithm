package Level2;

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
public class SkillTree2 {
	public static void main(String[] args) {
		SkillTree2 st = new SkillTree2();

		String skill = "CBDK";
		String[] skill_trees = {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};

		System.out.println(st.solution(skill, skill_trees));
	}

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		
		for (String skillTree : skill_trees) {
			String tempSkill = skillTree;
			
			for (int i = 0; i < skillTree.length(); i++) {
				String s = skillTree.substring(i, i+1);
				if (!skill.contains(s)) {
					tempSkill = tempSkill.replace(s, ""); // �ʼ� ��ų�� �ƴ� ��� �������� ġȯ
				}
			}
			
			if (skill.indexOf(tempSkill) == 0)
				answer++;
		}

		return answer;
	}
}
