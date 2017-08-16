
public class StringBuilder {

	public static void main(String[] args) {
		StringBuilderStructure sb = new StringBuilderStructure();
		
		sb.append("Fabio ");
		sb.append("dos ");
		sb.append("Santos ");
		
		System.out.println(sb.toString());
	}
	
	static class StringBuilderStructure {
		private final int LENGTH = 50 ;
		private char[] array = new char[LENGTH];
		private int currentIndex = 0;
		
		public void append(String s) {
			
			if (currentIndex == array.length) {
				
				char[] arrayAux = new char[array.length + LENGTH];
				for (int i = 0; i < array.length; i++) {
					arrayAux[i] = array[i];
				}
				array = arrayAux;
				
			}
			
			char[] arrayCharAux = s.toCharArray();
			for (char c : arrayCharAux) {
				array[currentIndex] = c;
				currentIndex++;
			}
		}
		
		public String toString() {
			return new String(array, 0, currentIndex);
		}

	}
	
}
