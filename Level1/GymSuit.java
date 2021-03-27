package Level1;

import java.util.Arrays;
/**
 * 체육복
 * @author jy-yi
 * 
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 * 
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
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
        Arrays.fill(student, 1); // 모두 1개씩 가져왔다고 가정
        
        /* 체육복 도난 당한 학생 */
        for (int i = 0; i < lost.length; i++) {
        	student[lost[i]-1]--;
		}
        
        /* 체육복 여벌 가져온 학생 */
        for (int i = 0; i < reserve.length; i++) {
        	student[reserve[i]-1]++;
		}
        
        for (int i = 0; i < student.length; i++) {
        	// 여벌 체육복이 있는 경우
        	if (student[i] > 1) {
        		if (i > 0) {
        			/* 앞번호 학생 빌려주기 */
        			if (student[i-1] == 0) {
        				student[i]--;
        				student[i-1]++;
        			/* 뒷번호 학생 빌려주기 */
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
