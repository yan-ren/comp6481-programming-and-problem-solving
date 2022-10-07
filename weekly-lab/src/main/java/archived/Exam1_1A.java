package archived;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exam1_1A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Character> volwels = new HashSet<>();
		volwels.add('a');
		volwels.add('e');
		volwels.add('i');
		volwels.add('o');
		volwels.add('u');
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] values = input.split(" ");
		
		if(getStructure(volwels, values[0]).equals(getStructure(volwels, values[1]))) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
	}

	public static String getStructure(Set<Character> volwels, String src) {
		String structure = "";
		src = src.toLowerCase();
		for(int i = 0; i < src.length(); i++) {
			if(volwels.contains(src.charAt(i))) {
				structure += "v";
			}else {
				structure += "c";
			}
		}
		
		
		return structure;
	}

}
