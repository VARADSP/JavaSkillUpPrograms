import java.util.*;
import java.io.*;

public class Demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, Character> hashMap = new HashMap<Integer, Character>();
		
		
		
		String input = sc.nextLine();
		
		System.out.println("Converting");
		
		for(int i=0;i<input.length();i++) {
			
			hashMap.put(i, input.charAt(i));
			
			
		
		}
		
		Set<Character> newVariable = new HashSet<Character>(hashMap.values());

		System.out.println(newVariable.toString());
		
		  
		  
		
		File f1 = new File("D:\\vsp.txt");
		
		
		
		
		
	}

}
