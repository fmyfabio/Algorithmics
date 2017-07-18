import java.util.Arrays;

public class Permutation {

	/**
	 * Calculate N possible combination!!
	 */
	public static void main(String[] args) {
		String[] array = {"*","-","+"};
		permutation(array, 0, 4);
	}
	
	static void swap(String[] array, int index1, int index2) {
		String temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;		
	}
	
	
	
	static void permutation(String[] array, int startPoint, int qtd) {
		
		if (startPoint == array.length) {
	        System.out.println(Arrays.toString(array));
	        return;
		}
		
		for (int i = startPoint; i < array.length; i++) {
			swap(array, i, startPoint);
			permutation(createArray(array, qtd), startPoint+1, qtd);
			swap(array, i, startPoint);
		}

	}
	
	static String[] createArray(String[] array, int qtd) {
		String[] result = new String[qtd];
		int countAux = 0;
		
		for (int i = 0; i < result.length; i++) {
			if (countAux == array.length) {
				countAux = 0;
			}
			
			result[i] = array[countAux];
			countAux++;
		}
		
		return result;
	}
	
}
