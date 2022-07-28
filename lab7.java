import java.util.*;
class lab7 {
	static void srtf(int n,int[] finish,int[] temp,int[] arrival){
		int tempI;
		for(int i=0;;i++){
			tempI = -1;
			for(int j=0;j<n;j++){
				if(finish[j]==0){
					if(arrival[j]<=i){
						if(tempI==-1)tempI=j;
						else if(temp[tempI]>temp[j])tempI=j;		
					}
				}
			}
			if(tempI==-1)return;
			if(--temp[tempI]==0)finish[tempI]=i+1;
		}
	}
	static void rr(int n,int[] finish,int[] temp,int[] arrival){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter quanta");
		int quanta = s.nextInt();
		int check;
		for(int i=0;;){
			check = 0;
			for(int j=0;j<n;j++){
				if(finish[j]==0){
					check=0;
					if(arrival[j]<=i){
						if(temp[j]>quanta){
							i += quanta;
							temp[j] -= quanta;
						}
						else{
							i += temp[j];
							temp[j] = 0;
							finish[j] = i;
						}
					}
				}
				else check++;
			}
			if(check==n)return;
		}
	}
	static void printResult(int n,int[] finish, int[] temp,int[] arrival, int[] burst,String[] id){
		System.out.println("ProcessId\tBurstTime\tArrivalTime\tFinishTime\tWaitingTime\tTurnaroundTime\t");
		int sumW = 0,sumT =0,tempW,tempT;
		for(int i=0;i<n;i++){
			tempT = finish[i] - arrival[i];
			tempW = tempT - burst[i];
			sumW += tempW;
			sumT += tempT;
			System.out.printf(id[i]+"\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",burst[i],arrival[i],finish[i],tempW,tempT);
		}
		System.out.printf("Average TurnAround Time -> %d\n",sumT/n);
		System.out.printf("Average Waiting Time -> %d\n",sumW/n);
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.println("1.SRTF\n2.RR\n3.Stop");
			int choice = s.nextInt();
			if(choice==3)return;
			if(choice!=1&&choice!=2)System.out.println("Invalid Choice");
			else{
				System.out.println("Enter no. of processes");
				int n = s.nextInt();
				String[] id = new String[n];
				int[] arrival = new int[n];
				int[] burst = new int[n];
				int[] temp = new int[n];
				int[] finish = new int[n];
				System.out.println("Enter Process Id, Arrival Time & Burst Time");
				for(int i=0;i<n;i++){
					id[i] = s.next();
					arrival[i] = s.nextInt();
					burst[i] = s.nextInt();
					temp[i] = burst[i];
				}
				if(choice==1)srtf(n,finish,temp,arrival);
				else rr(n,finish,temp,arrival);
				printResult(n,finish,temp,arrival,burst,id);
			}
		}
	}
}
