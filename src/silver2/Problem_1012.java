package silver2;

import java.util.Scanner;

// 유기농 배추 https://www.acmicpc.net/problem/1012
class Problem_1012 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testCaseCount = Integer.parseInt(sc.nextLine());
			for(int i=0; i<testCaseCount; i++){
				String[] size = sc.nextLine().split(" ");
				int[][] field = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
				int cabbageCount = Integer.parseInt(size[2]);
				for(int k=0; k<cabbageCount; k++){
					String[] location = sc.nextLine().split(" ");
					int x = Integer.parseInt(location[0]);
					int y = Integer.parseInt(location[1]);
					field[x][y] = 1;
				}
				analyze(field);
			}
		}
	}
	
	public static void analyze(final int[][] field) {
		int[][] statusField = new int[field.length][field[0].length];
		int worm = 0;
		for(int x=0; x<field.length; x++) {
			for(int y=0; y<field[x].length; y++) {
				if(field[x][y]==1 && isIsolated(field, statusField, x, y)) {
					worm++;
					/*
					System.out.println("\t+1");
					for(int b=0; b<statusField[0].length; b++) {
						for(int a=0; a<statusField.length; a++) {
							System.out.print(statusField[a][b] + "  ");
						}
						System.out.println();
					}
					System.out.println();
					*/
				}
			}
		}
		System.out.println(worm);
	}
	
	public static boolean isIsolated(final int[][] field, int[][] statusField, int x, int y) {
		// dfs 알고리즘(깊이 우선 탐색)
		if(statusField[x][y] != 0){return false;} // 이미 방문한 노드
		//System.out.print(new StringBuilder().append("(").append(x).append(", ").append(y).append(")"));
		
		statusField[x][y]=1;
		if(y>0 && field[x][y-1]==1){ isIsolated(field, statusField, x, y-1); } // 상
		if(y<statusField[x].length-1 && field[x][y+1]==1){ isIsolated(field, statusField, x, y+1); } // 하
		if(x>0 && field[x-1][y]==1){ isIsolated(field, statusField, x-1, y); } // 좌
		if(x<statusField.length-1 && field[x+1][y]==1){ isIsolated(field, statusField, x+1, y); } // 우
		
		return true;
	}
}
