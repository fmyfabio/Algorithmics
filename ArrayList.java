
public class ArrayList {

	public static void main(String[] args) {
		ArrayListStructure arrayListStructure = new ArrayListStructure();
		arrayListStructure.add("A");
		arrayListStructure.add("B");
		arrayListStructure.add("C");
		arrayListStructure.add("D");
		arrayListStructure.add("E");
		arrayListStructure.add("F");
		arrayListStructure.add("G");
		arrayListStructure.add("A");
		arrayListStructure.add("B");
		arrayListStructure.add("C");
		arrayListStructure.add("D");
		arrayListStructure.add("E");
		arrayListStructure.add("F");
		arrayListStructure.add("G");
		arrayListStructure.add("A");
		arrayListStructure.remove(3);
		arrayListStructure.remove(5);
		
	}
	
	
	static class ArrayListStructure {	
		
		private final int LENGTH = 10 ;
		private String[] array = new String[LENGTH];
		private int nextIndex = 0;
		private int size = 0;
		
		public void add(String s) {
			
			if (nextIndex == array.length) {
				
				String[] arrayAux = new String[array.length + LENGTH];
				for (int i = 0; i < array.length; i++) {
					arrayAux[i] = array[i];
				}
				array = arrayAux;
				
			}
			
			array[nextIndex] = s;
			size++;
			nextIndex++;
		}
		
		public void remove(int index) {
			this.array[index] = null;
			size--;
		}
		
		public String get(int index) {
			return this.array[index];
		}
		
		public int size() {
			return this.size;
		}
	}
	
	
	
}
