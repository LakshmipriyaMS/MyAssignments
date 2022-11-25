package week3.day2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstMostDuplicate {

	public static void main(String[] args) {
		
		String s = "abbabab";
		char[] y = s.toCharArray();
		//int size = y.length;
		
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(char ch : y)
        {  
           map.put(ch, map.getOrDefault(ch,0)+1) ;   
            }
        System.out.println(map);
        
        Set<Map.Entry<Character, Integer>> hmap = map.entrySet();
        char maxkey = ' ';
        int maxval = 0;
        for (Map.Entry<Character, Integer> data : hmap) {
			if (data.getValue() > maxval) {
				maxval = data.getValue();
				maxkey = data.getKey();
			}
		}
        System.out.println(maxval);
        System.out.println(maxkey);

	}

}
