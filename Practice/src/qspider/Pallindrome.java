package qspider;

public class Pallindrome {

	public static void main(String[] args) {

		int num = 1121;
		int org = num;
		int rev = 0;
		
		while(num>0)
		{
			int rem = num%10;
			rev = rev*10+rem;
			num = num/10;
			
		}
		if(org==rev)
		{
			System.out.println("number is pallindrome");
		}
		else 
		{
			System.out.println("Not Pallindrome");
			
		}
		
	}

}
