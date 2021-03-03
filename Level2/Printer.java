package Level2;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프린터
 * @author jy-yi
 * 
 * 중요도가 높은 문서를 먼저 인쇄하는 프린터
 * 
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
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
		int target = priorities[location]; // 인쇄 요청한 문서
		int order = 1; // 인쇄 순서

		/* 대기 목록 큐에 삽입 */
		Arrays.stream(priorities).forEach(i -> queue.add(i));

		while (!queue.isEmpty()) {
			int max = Collections.max(queue); // 대기 목록 중 우선 순위 판별
			if (queue.peek() == max) {
				queue.poll();
				order++;
			} else {

				location = (location == 0) ? priorities.length - 1 : location--; // 현재 위치가 첫번째면 제일 뒤로 보내기
			}

			System.out.println("max >> " + max);
			System.out.println("location >> " + location);
		}

		System.out.println(target);

		return order;
	}

	public int solution2(int[] priorities, int location) {

		// 내림차순 우선순위큐 선언
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int order = 1; // 인쇄 순서

		/* 대기 목록 큐에 삽입 */
		Arrays.stream(priorities).forEach(i -> queue.add(i));

		while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				// 중요도 높은 문서 (= 인쇄할 문서)
				if (priorities[i] == queue.peek()) {
					// 현재 인쇄하는 문서에 요청한 문서인지 판별
					if (i == location) {
						return order;
					}
					queue.poll(); // 인쇄한 문서는 대기 목록에서 제거
					order++;
				}
			}
		}
		return order;
	}
}
