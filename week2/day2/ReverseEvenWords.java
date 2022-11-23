package week2.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		
		String test = "I am a software tester"; 
		String s[] = test.split(" ");
		//String[] strStore;
  		String revStr = "";
  		char[] charArray = {};
  		for (int i=0;i<s.length;i++)
  		{
  			if(i%2 !=0)
  			{
  				System.out.println(s[i]);
  				
  				charArray = s[i].toCharArray();
  				for (int j=s[i].length()-1;j>=0;j--)
  				{
  					  					
  				 revStr = revStr+charArray[j];
  				}
  				
  				
 				System.out.println("Reversed string = "+revStr);
  				
  			}
  			
  			
  			
  		}


	}

}
