import java.util.Arrays;

public class Permutation {

	/**
	 * Calculate all possible combination!!
	 */
	public static void main(String[] args) {
		String[] array = {"*","-","+"};
		permutation(array, 0);
	}
	
	static void swap(String[] array, int index1, int index2) {
		String temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;		
	}
	
	static void permutation(String[] array, int startPoint) {
		
		if (startPoint == array.length) {
	        System.out.println(Arrays.toString(array));
	        return;
		}
		
		for (int i = 0; i < array.length; i++) {
			swap(array, i, startPoint);
			permutation(array, startPoint+1);
			swap(array, i, startPoint);
		}

	}
		
}
