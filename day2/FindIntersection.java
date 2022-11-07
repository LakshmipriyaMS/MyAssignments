package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		int[] data1 = {3,2,11,4,6,7};
		int[] data2 = {1,2,8,4,9,7};
        int size1 = data1.length;
        int size2 = data2.length;
        for (int i = 0; i < size1; i++) {
			
			for (int j = 0; j < size2; j++) {
				
				if (data1[i]==data2[j]) {
					System.out.println(data1[i]);
				}
			}
		}
        
	}

}
