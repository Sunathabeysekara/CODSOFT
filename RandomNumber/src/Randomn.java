import java.util.Random;
import java.util.Scanner;
public class Randomn {
	public static Scanner sc=new Scanner(System.in);
	
	public static boolean check(int num,int guess,int score) {//get input & random value
		boolean bool=false;//intialize to getut put
		if(guess!=num) {
			if(guess<num) {
			System.out.println("too low!.");//w	henguess is low	
			bool=false;
			
			}else {
				System.out.println("too high!.");//	when guess is high
				bool=false;
			}
		}else {
			System.out.println("correct guess!.\n Your score: "+score);///when correct guess
			bool=true;
		}
		return bool;		
	}
	public static void ans(int i,int number) {
		int score=3;//maximum score reducing with number of guesses
		while(i<=3) {
			System.out.println("Geuess the number:");
			int guess=sc.nextInt();
			if(check(number,guess,score--)==true) {//score reduce with guess
				break;//break when win
			}else if(i==3){//to lose output
				System.out.println("you lose!.Max time reached.\nScore: "+score);
			}	
			i++;
		}
	}
	
	
	public static void main(String[] args) {
		Random r=new Random();
		
		int number=r.nextInt(100);	
		int i=1;
		//System.out.println(number+1);//to get the selected random number
		ans(i,number+1);
		sc.close();//close scanne class
	}
	
}


//sunath abeysekara