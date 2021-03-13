package Level1;
/**
 * 서울에서 김서방 찾기
 * @author jy-yi
 * 
 * String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. 
 * seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 */
public class Kim {
	public static void main(String[] args) {
		String[] name = {"Jane", "Kim"};
		
		System.out.println(solution(name));
	}
	
	public static String solution(String[] seoul) {
        
        for (int i = 0; i < seoul.length; i++) {
			if ("Kim".equals(seoul[i])) 
				return "김서방은 " + i + "에 있다";
		}
        
        return null;
        
    }
}
