package programmers.learn.courses._30.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q_42888 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				new Answer_42888().solution(
				new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}
		)));
	}
}

class Answer_42888 {
	private static final String ENTER = "님이 들어왔습니다.";
	private static final String LEAVE = "님이 나갔습니다.";
	
    public String[] solution(String[] record) {
    	Map<String, String> nameMap = new HashMap<>();
    	List<String[]> outputLog = new ArrayList<>();
    	
    	for(String e : record) {
    		String[] inputLog = e.split(" ");
    		if("Change".equals(inputLog[0]) == false) {
    			outputLog.add(new String[] {inputLog[0], inputLog[1]});
			}
    		if("Leave".equals(inputLog[0]) == false){
				nameMap.put(inputLog[1], inputLog[2]);
			}
    	}
    	
    	String[] answer = new String[outputLog.size()];
    	int idx = 0;
    	
    	for(String[] e : outputLog) {
    		answer[idx++] = nameMap.get(e[1]) + ("Enter".equals(e[0]) ? ENTER : LEAVE);
    	}
    	
        return answer;
    }
}