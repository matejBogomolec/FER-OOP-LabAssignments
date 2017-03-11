package hr.fer.oop.lab3.prob2;

/**
 * 
 * @author Matej Bogomolec
 *
 * @param <K> - key of the entry
 * @param <V> - value of the entry
 */
public class SimpleHashtable<K, V> {
	private int size;
	private TableEntry<K, V>[] table;
	/**
	 * Default SimpleHashtable constructor that creates a 16 hash-table
	 */
	public SimpleHashtable()
	{ 
		size=16;
		table = (TableEntry<K, V>[]) new TableEntry[size];
	}
	/**
	 * SimpleHashtable constructor which creates a hash-table which best fits the desired capacity.
	 * @param capacity - desired capacity
	 */
	public SimpleHashtable(int capacity)

	{
		if(capacity<1)
		{
			System.err.println("Invalid size for table!");
		}
		else
		{
			int exp=(int)Math.floor(Math.sqrt(capacity));
			size = (int) Math.pow(2, exp);
			table = (TableEntry<K, V>[]) new TableEntry[size];	
		}
		
	}
	/**
	 * Method to insert a single entry into the hash-table
	 * @param key - key of the entry
	 * @param value - value of the entry
	 */
	public void put(K key, V value){
		int index = Math.abs(key.hashCode()) % 2;
		TableEntry<K, V> pointer=table[index];
		if(pointer==null)
		{
			TableEntry<K, V> Entry=new TableEntry<K, V>(key,value,null);
			table[index]=Entry;
		}
		else
		{
			while(pointer!=null)
			{
				if(pointer.next==null)
				{
					TableEntry<K,V> Entry=new TableEntry<K, V>(key,value,null);
					pointer.next=Entry;
					break;
				}
				if(pointer.getKey() == key)
				{
					pointer.setValue(value);
					break;
				}
				pointer=pointer.next;
			}
		}
	}
	/**
	 * Method which returns the value which is stored in the desired key
	 * @param key - desired hash key
	 * @return value stored in the key
	 */
	public V get(K key){
		int index=Math.abs(key.hashCode())%size;
		TableEntry<K, V> pointer=table[index];
		while(pointer!=null){
			if(pointer.getKey().equals(key)){
				return pointer.getValue();
			}
			pointer=pointer.next;
		}
		return null;
	}
	/**
	 * Method which calculates the number of entries in the hash-table
	 * @return - number of entries in the hash-table
	 */
	public int size()
	{
		int n=0;
		for(int i=0; i < size; i++)
		{
			TableEntry<K, V> pointer=table[i];
			while(pointer != null)
			{
				n++;
				pointer=pointer.next;	
			}
		}
		return n;
	}
	/**
	 * Method which searches for the desired key in the hash table
	 * @param key - desired key
	 * @return true if the desired key is in the hash table, else false
	 */
	public boolean containsKey(K key)
	{
		for(int i=0;i<size;i++)
		{
			TableEntry<K, V> pointer=table[i];
			while(pointer!=null){
				if(pointer.getKey() == key)
				{
					return true;
				}
				pointer=pointer.next;
			}
		}
		return false;
	}
	/**Method which searches for the desired value in the hash table
	 * @param value - desired value
	 * @return true if the desired value is in the hash table, else false
	 * 
	 */
	public boolean containsValue(V value)
	{
		for(int i=0;i<size;i++)
		{
			TableEntry<K, V> pointer=table[i];
			while(pointer!=null){
				if(pointer.getValue() == value)
				{
					return true;
				}
				pointer=pointer.next;
			}
		}
		return false;
	}
	/**
	 * Removes the entry with the corresponding key
	 * @param key - key of entry that needs to be removed
	 */
	public void remove (K key)
	{
		int hash = key.hashCode();
		for (int i = 0; i < size; i++) 
		{
			TableEntry<K, V> pointer = table[i];
			TableEntry<K, V> previous = null;
			for (; pointer != null; previous = pointer, pointer = pointer.next) 
			{
				if ((pointer.getKey().equals(key))
						&& (pointer.getKey().hashCode() == hash)) {
					
				}
					if (previous != null) 
					{
						previous.next = pointer.next;
					} else
					{
						table[i] = pointer.next;
					}
			}
		}
	}
	/**
	 * Checks if the hash table is empty
	 * @return true if hash table is empty, else false
	 */
	public boolean isEmpty()
	{
		for(int i=0; i<= size; i++)
		{
			if (table[i]!=null) return false;
		}
		return true;
	}
	@Override
	/** Converts the hash-table to a String
	 * 
	 */
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		for(int i=0;i<size;i++){
			TableEntry<K, V> pointer=table[i];
			while(pointer!=null){
				string.append(pointer.toString());
				pointer=pointer.next;
			}
			string.append('\n');
		}
		return string.toString();
	}
	/**
	 * Class used in creation of a single hash table entry
	 * @author Matej Bogomolec
	 *
	 * @param <K> - hash key
	 * @param <V> - entry value
	 */
	public static class TableEntry<K,V>
	

	{
		private K key;
		private V value;
		protected TableEntry<K, V> next;
		/**
		 * Constructor which creates a new table entry.
		 * @param key - key of this entry
		 * @param value - value of this entry
		 * @param next - adress of the next entry
		 */
		TableEntry (K key, V value, TableEntry<K,V> next)
		{
			this.key = key;
			this.value = value;
			this.next = next;
		}
		/**
		 * Returns the key of this entry.
		 * @return key
		 */
		public K getKey()
		{
			return key;
		}
		/**
		 * Returns the value of this entry.
		 * @return value
		 */
		public V getValue()
		{
			return value;
		}
		/**
		 * Sets new value for this entry.
		 * @param new_value - new value
		 */
		public void setValue(V new_value)
		{
			value = new_value;
		}
		/**
		 * Converts a single table entry into String
		 */
		@Override
		public String toString()
		{
			StringBuilder string=new StringBuilder();
			string.append(" { ");
			string.append(key.toString());
			string.append(" = ");
			string.append(value.toString());
			string.append(" } ");
			return string.toString();
		}
	}

/**
 * Main method used to execute the hash table
 * @param args - no parameters are used
 */
	public static  void main(String args[])
	{
	// create collection:
	SimpleHashtable<String,Integer> examMarks = new SimpleHashtable<>(2);
	// fill data:
	examMarks.put("Ivana", Integer.valueOf(2));
	examMarks.put("Ante", Integer.valueOf(2));
	examMarks.put("Jasna", Integer.valueOf(2));
	examMarks.put("Kristina", Integer.valueOf(5));
	examMarks.put("Ivana", Integer.valueOf(5)); // overwrites old grade for Ivana
	// query collection:
	Integer kristinaGrade = examMarks.get("Kristina");
	System.out.println("Kristina's exam grade is: " + kristinaGrade); // writes: 5
	// What is collection's size? Must be four!
	System.out.println("Number of stored pairs: " + examMarks.size()); // writes: 4
	}
}
