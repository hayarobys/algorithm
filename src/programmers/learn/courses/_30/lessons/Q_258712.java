package programmers.learn.courses._30.lessons;

import java.util.HashMap;
import java.util.Map;

class Q_258712 {
	public static void main(String[] args) {
		System.out.println(solution(
				new String[]{"muzi", "ryan", "frodo", "neo"}
				, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
		));
	}
	
    public static int solution(String[] friends, String[] gifts) {
    	Map<String, History> nameHistoryMap = new HashMap<>();
        Map<String, Integer> presentHistoryMap = new HashMap<>();
        
        for(String name : friends) {
        	nameHistoryMap.put(name, new History());
        }
        
        for(String hist : gifts){
            String[] names = hist.split(" ");
            
            History giver = nameHistoryMap.get(names[0]);
            giver.addGive();
            History receiver = nameHistoryMap.get(names[1]);
            receiver.addReceive();
            
            presentHistoryMap.put(hist, presentHistoryMap.getOrDefault(hist, 0)+1);
        }
        
        for(String nameA : nameHistoryMap.keySet()) {
        	History histA = nameHistoryMap.get(nameA);
        	
        	for(String nameB : nameHistoryMap.keySet()) {
        		if(nameA.equals(nameB)) { continue; }
        		History histB = nameHistoryMap.get(nameB);
        		
        		
        		Integer aToB = presentHistoryMap.getOrDefault(nameA + " " + nameB, 0);
        		Integer bToA = presentHistoryMap.getOrDefault(nameB + " " + nameA, 0);
        		
        		// 기록이 없거나 주고받은 수가 같다면
        		if((aToB==0 && bToA==0) || (aToB==bToA)) {
        			// 선물 지수가 더 큰 사람이 더 작은 사람에게 받는다
        			if(histA.getScore()>histB.getScore()) {
        				histA.addNextMonth();
        			}else if(histA.getScore()<histB.getScore()) {
        				histB.addNextMonth();
        			}
        			// 선물 지수도 같다면 아무 행동X
        		}else {
        		// 두 사람이 선물을 주고받은 기록이 있다면
        			// 더 많은 선물을 준 사람이 받는다
        			if(aToB > bToA) {
        				histA.addNextMonth();
        			}else {
        				histB.addNextMonth();
        			}
        		}
        	}
        }
        
        int max = 0;
        for(String name : nameHistoryMap.keySet()) {
        	Integer nextMonthCount = nameHistoryMap.get(name).getNextMonthCount()/2;
        	if(nextMonthCount>max) {
        		max = nextMonthCount;
        	}
        }
        
        return max;
    }
    
    static class History{
    	private int nextMonthCount;
        private int giveCount;
        private int receiveCount;
        
        public int getNextMonthCount() {
			return nextMonthCount;
		}
		public int getGiveCount(){
            return this.giveCount;
        }
        public int getReceiveCount(){
            return this.receiveCount;
        }
        public int getScore(){
            return this.giveCount - this.receiveCount;
        }
        public void addGive(){
            this.giveCount++;
        }
        public void addReceive(){
            this.receiveCount++;
        }
        public void addNextMonth() {
        	this.nextMonthCount++;
        }
    }
}
