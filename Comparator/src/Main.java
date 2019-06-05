import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() > o2.length()) return 1;
		else if (o1.length() < o2.length()) return -1;
		return 0;
	}
	
}

class AlphabeticalComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}

class ReverseAlphabeticalComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2);
	}
	
}


public class Main {

	public static void main(String[] args) {
		
		List<String> animals = new ArrayList<>();
		animals.add("Dog");
		animals.add("Elephant");
		animals.add("Lion");
		animals.add("Tiger");
		animals.add("Cat");
		
		Collections.sort(animals, new AlphabeticalComparator());
		
		for (String string : animals) {
			System.out.println(string);
		}

	}

}
