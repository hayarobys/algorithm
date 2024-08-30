package programmers.learn.courses._30.lessons;

import java.util.Arrays;
import java.util.Collections;

public class Q_86053 {

	public static void main(String[] args) {
		System.out.println(new Answer_86053().solution(
				10, 10 // 신도시 건설에 필요한 금, 은
				, new int[] {100}, new int[] {100} // 도시가 보유한 금, 은
				, new int[] {7} // 제한중량
				, new int[] {10} // 편도 소요시간
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
    public long solution(
    		final int a, final int b
    		, int[] g, int[] s, int[] w, int[] t
    ) {
        int neededGold = a;
        int neededSilver = b;
        int[] carryGold = new int[g.length];
        int[] carrySilver = new int[s.length];
        int[] spendTime = new int[w.length];
        int[] fastCityDesc = new int[t.length];
        
        // O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(n^3) < O(2^n) < O(n!)
        // 기수정렬O(dn) < 힙정렬O(n log n) < 병합정렬O(n log n)+O(n)메모리
        // < 삽입정렬O(n)~O(n^2) < 퀵정렬O(n log n)~O(n^2) < 선택정렬O(n^2) = 버블정렬O(n^2)
        
        // t배열의 오름차순 인덱스를 구한다. 병합정렬을 쓰자
        
        
        for(int i=0; i<g.length; i++) {
        	// 시간이 가장 빠른 도시의 금을 먼저. 잔여 공간이 있으면 빈공간은 은으로 채우기
        	
        	
        	
        	
        	g[i] -= w[i];
        	
        	carryGold[i] = w[i]; // TODO gold, silver 배분
        	carrySilver[i] = w[i];
        	neededGold -= carryGold[i];
        	neededSilver -= carrySilver[i];
        	
        	spendTime[i] += t[i];
        }
    	
    	long answer = -1;
        return answer;
    }
}