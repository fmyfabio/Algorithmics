
public class StringManipulation {
	
	// This take n
	public boolean isUniqueWithDataStructure(String s) {
		if (s.length() > 128) return false;
		
		boolean[] checker = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if (checker[val]) {
				return false;
			}
			checker[val] = true;
		}
		
		return true;
	}
	
	// This take n²
	public boolean isUniqueWithoutDataStructure(String a) {
		
		boolean isUnique = true;
		
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < a.length(); j++) {
				if (i != j && (a.charAt(i) == a.charAt(j))) {
					isUnique = false;
					break;
				}
			}
		}
		
		return isUnique;
	}		
}
