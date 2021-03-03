package Level2;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ������
 * @author jy-yi
 * 
 * �߿䵵�� ���� ������ ���� �μ��ϴ� ������
 * 
 * 1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
 * 2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
 * 3. �׷��� ������ J�� �μ��մϴ�.
 *
 */
public class Printer {
	public static void main(String[] args) {
		Printer printer = new Printer();

		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		System.out.println(printer.solution2(priorities, 0));
	}

	public int solution(int[] priorities, int location) {

		Queue<Integer> queue = new LinkedList<Integer>();
		int target = priorities[location]; // �μ� ��û�� ����
		int order = 1; // �μ� ����

		/* ��� ��� ť�� ���� */
		Arrays.stream(priorities).forEach(i -> queue.add(i));

		while (!queue.isEmpty()) {
			int max = Collections.max(queue); // ��� ��� �� �켱 ���� �Ǻ�
			if (queue.peek() == max) {
				queue.poll();
				order++;
			} else {

				location = (location == 0) ? priorities.length - 1 : location--; // ���� ��ġ�� ù��°�� ���� �ڷ� ������
			}

			System.out.println("max >> " + max);
			System.out.println("location >> " + location);
		}

		System.out.println(target);

		return order;
	}

	public int solution2(int[] priorities, int location) {

		// �������� �켱����ť ����
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int order = 1; // �μ� ����

		/* ��� ��� ť�� ���� */
		Arrays.stream(priorities).forEach(i -> queue.add(i));

		while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				// �߿䵵 ���� ���� (= �μ��� ����)
				if (priorities[i] == queue.peek()) {
					// ���� �μ��ϴ� ������ ��û�� �������� �Ǻ�
					if (i == location) {
						return order;
					}
					queue.poll(); // �μ��� ������ ��� ��Ͽ��� ����
					order++;
				}
			}
		}
		return order;
	}
}
