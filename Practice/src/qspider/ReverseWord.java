package qspider;

public class ReverseWord {

	public static void main(String[] args) {

		String str = "Virat is playing";
		String[] word = str.split(" ");
		
		for(String s:word)
		{
			String reverse ="";
			for(int i = s.length()-1;i>=0;i--)
			{
				reverse = reverse + s.charAt(i);
			}
			
			System.out.print(reverse + " ");
		}
		
		
	}

}
