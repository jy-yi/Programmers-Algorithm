package Level1;

import java.util.Arrays;
/**
 * ü����
 * @author jy-yi
 * 
 * ���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. 
 * ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. 
 * �л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. 
 * ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. 
 * ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.
 * 
 * ��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, 
 * ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */
public class GymSuit {
	public static void main(String[] args) {
		int[] lost = {5, 7, 9};
		int[] reserve = {1, 2, 3, 4, 6, 8};
		
		System.out.println(solution(10, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n];
        Arrays.fill(student, 1); // ��� 1���� �����Դٰ� ����
        
        /* ü���� ���� ���� �л� */
        for (int i = 0; i < lost.length; i++) {
        	student[lost[i]-1]--;
		}
        
        /* ü���� ���� ������ �л� */
        for (int i = 0; i < reserve.length; i++) {
        	student[reserve[i]-1]++;
		}
        
        for (int i = 0; i < student.length; i++) {
        	// ���� ü������ �ִ� ���
        	if (student[i] > 1) {
        		if (i > 0) {
        			/* �չ�ȣ �л� �����ֱ� */
        			if (student[i-1] == 0) {
        				student[i]--;
        				student[i-1]++;
        			/* �޹�ȣ �л� �����ֱ� */
        			} else if (i < student.length-1 && student[i+1] == 0) {
        				student[i]--;
        				student[i+1]++;
        			}
        		}
        	}
		}
        
        for (int i : student) {
			if (i > 0)
				answer++;
		}
        
        return answer;
    }
}
