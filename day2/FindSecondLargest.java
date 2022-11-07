package week1.day2;
import java.util.Arrays;
public class FindSecondLargest {

	public static void main(String[] args) {
		
		int[] data = {3,2,11,4,6,7};
		Arrays.sort(data);
		int size = data.length;
		System.out.println("Second Largest Number is "+data[size-2]);

	}

}
