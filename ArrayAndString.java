import java.util.Arrays;

/**
 * - Auxiliary array with code ASCII 128
 * - Shift count to balance
 * - Rotation s1+s2
 * - FoundOne
 * - Count subsequence string
 */
public class ArrayAndString {

	public static void main(String[] args) {
		int[][] array = {
					{3 ,5 ,7 ,8},
					{9 ,12,13,14},
					{10,20,21,30},
					{11,31,32,40},
				};
		
		RotationMatrix rotationMatrix = new RotationMatrix();
		rotationMatrix.rotation90(array);
	}
	
	static class RotationMatrix {
		
		public void rotation90(int[][] matrix) {
			 			
			for (int layer = 0; layer < matrix.length / 2; layer++) {
				
				int first = layer;
				int last = matrix.length - layer - 1;
				
				for (int j = first; j < last; j++) {
					
					int offset = j - first;
					
					int temp = matrix[first][j];
					
					matrix[first][j] = matrix[last-offset][first];
					
					matrix[last-offset][first] = matrix[last][last-offset];
					
					matrix[last][last-offset] =  matrix[j][last];
					 
					matrix[j][last] = temp;
				}
			}
						
			this.print(matrix);
		}
		
		private void print(int[][] matrix) {
			
			for (int[] is : matrix) {
				System.out.println(Arrays.toString(is));
			}
			
		}
		
	}
	
	static class Rotation {
		
		public boolean isRotation(String s1, String s2) {
			StringBuilder sb = new StringBuilder();
			sb.append(s1);
			sb.append(s1);
			
			return sb.toString().contains(s2);						
		}
		
	}
	
	static class Compression {
				
		public String compress(String s1) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			
			for (int i = 0; i < s1.length(); i++) {
				count++;
				
				if ((i+1) == s1.length() || s1.charAt(i) != s1.charAt(i+1)) {
					sb.append(s1.charAt(i));
					sb.append(count);
					count = 0;
				}
			}
			
			return sb.length() < s1.length() ? sb.toString() : s1;
		}
		
	}
	
	static class OneAway {
		
		public boolean isOne(String s1, String s2) {
			
			if (s1.length() == s2.length()) {
				
				boolean foundOne = false;
				for (int i = 0; i < s1.length(); i++) {
					if (s1.charAt(i) != s2.charAt(i)) {
						if (foundOne) {
							return false;
						}
						foundOne = true;
					}
				}
				
				return true;
				
			} else {
				
				if (s1.length() > s2.length() && s1.length() == (s2.length()+1)) {
					int count = 0;
					boolean foundOne = false;
					
					for (int i = 0; i < s2.length(); i++) {
						if (s1.charAt(i+count) != s2.charAt(i)) {
							if (foundOne) {
								return false;
							}
							foundOne = true;
							count++;
						}
					}
					
					return true;
					
				} else if (s1.length() < s2.length() && (s1.length()+1) == s2.length()) {
					
					int count = 0;
					boolean foundOne = false;
					
					for (int i = 0; i < s1.length(); i++) {
						if (s1.charAt(i) != s2.charAt(i+count)) {
							if (foundOne) {
								return false;
							}
							foundOne = true;
							count++;
						}
					}
					
					return true;					
					
				}
				
				return false;
			}
			
			
		}
		
	}
	
	static class PalimdromePermutation {
		
		public boolean hasPalindrome(String s1) {
			int[] check = new int[128];
			int count = 0;
			
			for (char character : s1.toCharArray()) {
				if (' ' != character ) {
					check[character]++;
					
					if (check[character]%2 == 1) {
						count++;
					} else {
						count--;
					}					
				}
			}

			return count == 0 || count == 1;			
		}
		
	}
	
	static class URLify {
		
		public void replace(char[] array, int realLenght) {						
			int index = array.length;
			
			for (int i = (realLenght - 1); i >= 0; i--) {
				if (array[i] != ' ') {
					array[index - 1] = array[i];
					index--;
				} else {
					array[index - 1] = '0';
					array[index - 2] = '2';
					array[index - 3] = '%';
					
					index = index - 3;
				}
			}
		}
		
	}
	
	static class CheckPermutation {
		
		public boolean isPermutation(String s1, String s2) {
			if (s1.length() != s2.length()) return false;
			
			int[] check = new int[128];
			
			for (char character : s1.toCharArray()) {
				int index = character;
				check[index]++;
			}
			
			for (char character : s2.toCharArray()) {
				check[character]--;
				if (check[character] < 0) {
					return false;
				}
			}
			
			return true;
		}

	}
	
}
