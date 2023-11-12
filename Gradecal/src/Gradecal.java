import java.util.Scanner;

public class Gradecal {
	public static Scanner sc=new Scanner(System.in);
	public static int mark[];
	//for grade
	public static char getgrade(int k) {	
			if(k>=75) {
				return 'A';
			}else if(k>=65) {
				return 'B';
			}else if(k>=55) {
				return 'C';
			}else if(k>=45){
				return 'S';
			}else if(k>=35) {
				return 'D';
			}else {
				return 'E';
			}
	}
	//for get marks
	public static void getmarks(int numofsubjects){
		mark =new int[numofsubjects];
		for(int i=0;i<numofsubjects;i++) {
			mark[i]=sc.nextInt();
		}
		
	}
	
	//for get sum of marks
	public static int sum(int numofsubjects) {
		int sum=0;
		for(int i=0;i<numofsubjects;i++) {
			sum=sum+mark[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("Please give number of subjects: ");
		int numofsubjects=sc.nextInt();
		//for get marks
		System.out.println("Enter the marks: ");
		getmarks(numofsubjects);
		//sum of marks
		int msum=sum(numofsubjects);
		
		//needed output
		System.out.println("total of marks: "+msum);
		System.out.println("Averag percentage: "+msum/numofsubjects+"%");
		System.out.println("Grade: "+getgrade(msum/numofsubjects));
		
		sc.close();
	}

}




//sunath abeysekara