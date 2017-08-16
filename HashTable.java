
public class HashTable {

	public static void main(String[] args) {
		HashTableStructure hashTableStructure = new HashTableStructure();
		
		hashTableStructure.put("FA", "Fabio");
		hashTableStructure.put("FE", "Faca");
		hashTableStructure.put("FI", "Facil");
		hashTableStructure.put("GA", "Gabriela");
		hashTableStructure.put("GE", "Galo");
		hashTableStructure.put("EA", "Elefante");
		hashTableStructure.put("OA", "Oportunidade");
		hashTableStructure.put("OE", "Ovulo");
		hashTableStructure.put("OI", "Orientacao");
		
		System.out.println(hashTableStructure.get("FA"));
		System.out.println(hashTableStructure.get("FE"));
		System.out.println(hashTableStructure.get("FI"));
		System.out.println(hashTableStructure.get("GA"));
		System.out.println(hashTableStructure.get("GE"));
		System.out.println(hashTableStructure.get("EA"));
		System.out.println(hashTableStructure.get("OA"));
		System.out.println(hashTableStructure.get("OE"));
		System.out.println(hashTableStructure.get("OI"));
		System.out.println(hashTableStructure.get("X"));

	}
	
	static class HashTableStructure {
		
		private int TABLE_SIZE = 10;
		private HashTableNode[] array = new HashTableNode[TABLE_SIZE];
		private int size = 0;
		
		public void put(String key, String value) {
			
			int hashIndex = this.myhash(key);
			if (array[hashIndex] == null) {
				array[hashIndex] = new HashTableNode(key, value);
				size++;
				
			} else {
			
				HashTableNode hashNode = array[hashIndex];
				while (hashNode.getNext() != null && !hashNode.getKey().equals(key)) {
					hashNode = hashNode.getNext();					
				}
				
				if (hashNode.getKey().equals(key)) {
					hashNode.setValue(value);
				} else {
					hashNode.setNext(new HashTableNode(key, value));
					size++;
				}
				
			}
			
		}
		
		public String get(String key) {
			
			int hashIndex = this.myhash(key);
			if (array[hashIndex] == null) {
				return null;
			} else {
				
				HashTableNode hashNode = array[hashIndex];
				while (hashNode.getNext() != null && !hashNode.getKey().equals(key)) {
					hashNode = hashNode.getNext();					
				}
				
				if (hashNode.getKey().equals(key)) {
					return hashNode.getValue();
				} else {
					return null;
				}				
			}						
		}
		
		public int size() {
			return this.size;
		}
		
		private int myhash(String x) {
			int hashVal = x.hashCode();
			hashVal %= TABLE_SIZE;
			if (hashVal < 0)
				hashVal += TABLE_SIZE;
			return hashVal;
		}
		
	}
	
	static class HashTableNode {
		
		private String key;
		private String value;
		private HashTableNode next;
		
		public HashTableNode(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public HashTableNode getNext() {
			return next;
		}

		public void setNext(HashTableNode next) {
			this.next = next;
		}

	}
	
}
