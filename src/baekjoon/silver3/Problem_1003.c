#include <stdio.h>

int memory[41]={0,};

int fibonacci(int n){
	if(n==0){
		memory[n]=0;
		return 0;
	}else if(n==1){
		memory[n]=1;
		return 1;
	}
	
	if(memory[n] != 0){
		return memory[n];
	}else{
		memory[n] = fibonacci(n-1) + fibonacci(n-2);
		return memory[n];
	}
}
 
int main(void) {
	int caseCount, i;
	scanf("%d", &caseCount);
	for(i=0; i<caseCount; i++){
		int n;
		scanf("%d", &n);
		
		if(n==0){
			printf("%d %d\n",1,0);
		}else if(n==1){
			printf("%d %d\n",0,1);
		}else{
			printf("%d %d\n",fibonacci(n-1),fibonacci(n));
		}
	}
	return 0;
}