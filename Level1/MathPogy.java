package Level1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * ���ǰ��
 * @author jy-yi
 *
 * �����ڴ� ������ ������ ����� �ظ��Դϴ�. 
 * ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.
 * 
 * 1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 
 * 1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
 * ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */
public class MathPogy {

	public static void main(String[] args) {
		int[] answers1 = { 1, 2, 3, 4, 5 };
		int[] answers2 = { 1, 3, 2, 4, 2 };

		int[] result = solution(answers2);

		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] answers) {
		int[] person1 = { 1, 2, 3, 4, 5 };
		int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] result = new int[3];

		for (int i = 0; i < answers.length; i++) {
			int now = answers[i]; // ���� ���� ��

			/* ���� Ȯ�� */
			if (now == person1[i % person1.length]) result[0]++;
			if (now == person2[i % person2.length]) result[1]++;
			if (now == person3[i % person3.length]) result[2]++;

		}
		
		int max = result[0];
		
		/* ���� �ִ밪 Ž�� */
		for (int i : result) {
			if (i >= max) {
				max = i;
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		/* ���� ���� ���� ��� ����Ʈ */
		for (int i = 0; i < result.length; i++) {
			if (result[i] == max) {
				list.add(i+1);
			}
		}
		
		Collections.sort(list); // �������� ����

		return list.stream().mapToInt(Integer::intValue).toArray(); // list to array
	}

}
