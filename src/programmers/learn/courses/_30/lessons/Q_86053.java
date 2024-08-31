package programmers.learn.courses._30.lessons;

public class Q_86053 {

	public static void main(String[] args) {
		System.out.println(new Answer_86053().solution(
				10, 10
				, new int[] {100}, new int[] {100}
				, new int[] {7}
				, new int[] {10}
		));
		
		System.out.println(new Answer_86053().solution(
				90, 500
				, new int[] {70,70,0}, new int[] {0,0,500}
				, new int[] {100,100,2}
				, new int[] {4,8,1}
		));
	}
}

class Answer_86053 {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
    	int neededGold = a;
    	int neededSilber = b;
    	int[] spendTime = new int[] {};
    	
    	// 그리디 알고리즘
    	for(int i=0; i<g.length; i++) {
    		
    		g[i] -= w[i];
    		spendTime[i] += t[i];
    		neededGold -= w[i];
    		
    	}
    	
    	
    	
    	
    	
        long answer = -1;
        return answer;
    }
}

/*
	DFS = Stack, 경우의 수
	BFS = Queue, 가장 빠른, 최솟값
	그리디 = 매 루프마다 최선의 결과를 선택하는 것
	동적 계획 = 피보나치, 작은단위로 분리해서 점차 큰 문제를 풀어나가는 것
*/