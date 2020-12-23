package silver4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	터렛 https://www.acmicpc.net/problem/1002
	
	문제
	조규현과 백승환은 터렛에 근무하는 직원이다.
	하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다.
	다음은 조규현과 백승환의 사진이다.
	
	이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
	조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
	
	조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,
	조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
	류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 테스트 케이스의 개수 T가 주어진다.
	각 테스트 케이스는 다음과 같이 이루어져 있다.
	
	한 줄에 x1, y1, r1, x2, y2, r2가 주어진다.
	x1, y1, x2, y2는 -10,000보다 크거나 같고,
	10,000보다 작거나 같은 정수이고,
	r1, r2는 10,000보다 작거나 같은 자연수이다.
	
	출력
	각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다.
	만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
*/
class Problem_1002 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			List<String> caseList = new ArrayList<String>();
			for(int i=0; i<Integer.parseInt(input); i++){
				caseList.add(sc.nextLine());
			}
			
			for(String e:caseList){
				System.out.println(analyze(e));
			}
		}
	}
	
	public static int analyze(String caseInput){
		String[] a = caseInput.split(" ");
		int x1 = Integer.parseInt(a[0]);
		int y1 = Integer.parseInt(a[1]);
		int r1 = Integer.parseInt(a[2]);
		int x2 = Integer.parseInt(a[3]);
		int y2 = Integer.parseInt(a[4]);
		int r2 = Integer.parseInt(a[5]);
		
		// d: 두 점의 최단거리
		int d = (y2-y1)*(y2-y1) + (x2-x1)*(x2-x1);
		int result = 0;
		// 두 점에서 만난다: r2-r1 < d < r2+r1
		if((r2-r1)*(r2-r1)<d && d<(r2+r1)*(r2+r1)){
			result = 2;
			
		// 한 점에서 만난다(외접): r1+r2=d
		}else if((r1+r2)*(r1+r2)==d){
			result = 1;
			
		// 한 점에서 만난다(내접): r2-r1=d && d!=0
		}else if((r2-r1)*(r2-r1)==d && d!=0){
			result = 1;
			
		// 하나의 원이 다른 원을 포함: d<r2-r1
		}else if(d<(r2-r1)*(r2-r1)){
			result = 0;
		
		// 두 원이 멀리 떨어져 만나지 않는 경우: d>r1+r2
		}else if(d>(r1+r2)*(r1+r2)){
			result = 0;
			
		// 두 원이 일치하는 경우: d=0 && r1=r2
		}else if(d==0 && r1==r2){
			result = -1;
		}
		return result;
	}
}
