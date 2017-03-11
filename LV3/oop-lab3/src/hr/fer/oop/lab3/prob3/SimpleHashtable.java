package hr.fer.oop.lab3.prob3;

import java.util.*;

/**
 * Class SimpleHashtable represents a hash table that deals with collisions in a 
 * way that every object that doesn't have a place in an corresponding table slot 
 * is placed as a node in linked list that is derived from that slot. Class implements interface Iterable which allows us to 
 * iterate through created hash table using foreach loop. Implementations of appropriate methods for using iterators can be found 
 * in inner HashtableIterator class so as iterator method.
 * 
 * @author Martin Pisaèiæ
 *
 * @param <K> - parameter of a key
 * @param <V> - parameter of a value
 */

public class SimpleHashtable<K, V> implements Iterable<SimpleHashtable.TableEntry<K,V>> {
	
	private int size;
	private TableEntry<K,V>[] table;
	
	/**
	 * Static class that is a implementation of linked list and is used if more that one entry should be 
	 * in the given slot. In that case every other entry should be a next node in the list.
	 * 
	 * @author Martin Pisaèiæ
	 *
	 * @param <K> - parameter for key
	 * @param <V> - parameter for value
	 */
	public static class TableEntry<K, V> {
		
		private K key;
		private V value;
		TableEntry<K, V> next;
		
		/**
		 * Node constructor that constructs new node that is used in linked list implementation. 
		 * 
		 * @param key - key of an object
		 * @param value - value of an object
		 * @param next - pointer to next linked list element in the list
		 */
		public TableEntry(K key, V value, TableEntry<K,V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		/**
		 * Returns key of the current object.
		 * @return returns key of the current object
		 */
		public K getKey() {
			return key;
		}
		/**
		 * Returns value of the current object.
		 * @return value of the current object.
		 */
		public V getValue() {
			return value;
		}
		/**
		 * Sets the value of current object to the new value.
		 * @param value - value upon which object value is changed
		 */
		public void setValue(V value) {
			this.value = value;
		}
		
		/**
		 * Method that returns string representation of one object from hash table.
		 * The method returns key and value of and object in a string format.
		 * Example : "Jasna : 5"
		 */
		@Override
		public String toString() {
			return this.getKey() + " : " + this.getValue().toString();
		}
		
 	}
	
	/**
	 * Default constructor that creates hash table with 16 slots.
	 */
	@SuppressWarnings("unchecked")
	public SimpleHashtable() {
		
		table = (TableEntry[]) new TableEntry[16];
		
	}
	
	/**
	 * Constructor that creates hash table with a number of slots that is first greater or equal power of 2 capacity
	 * than a given capacity. 
	 * 
	 * @param capacity - size upon which we request table size equal to or greater than given capacity.
	 */
	@SuppressWarnings("unchecked")
	public SimpleHashtable(int capacity) {
		
		if(capacity <= 0) {
			System.err.println("Wrong capacity number. Capacity must be a number greater than 0!");
			System.exit(1);
		}
		
		int i = 0;
		
		while(capacity > Math.pow(2, i)) {
			i++;
		}
		
		int pot = (int)Math.pow(2, i);
		
		while((capacity) / pot != 1) {
			capacity++;
		}
		
		table = (TableEntry[]) new TableEntry[capacity];
		
	}
	
	/**
	 * Iterator, so called factory method that creates new iterator that is used for iterating over objects in hash table and is
	 * created on every call when we need to iterate through that table. 
	 */
	@Override
	public Iterator<SimpleHashtable.TableEntry<K,V>> iterator () {
		
		return new HashtableIterator();
		
	}
	
	/**
	 * HashtableIterator is an inner private class that gives us implementation of methods
	 * that are listed in the interface Iterator so that iterator can be used for iterating through
	 * the hash table.
	 * 
	 * @author Martin Pisaèiæ
	 *
	 */
	private class HashtableIterator implements Iterator<SimpleHashtable.TableEntry<K, V>> {
		
		private int currentSlot;
		private int elementNumber;
		private TableEntry<K, V> currentNode;
		
		/**
		 * Constructs an iterator that is used for interation in the loop. Sets the values of the object so that
		 * iteration begins from the first element of the first slot in the table.
		 */
		public HashtableIterator() {
			this.currentSlot = 0;
			this.elementNumber = 0;
			currentNode = table[0];
		}
		
		/**
		 * Examines if there are more elements that needs to be processed.
		 */
		@Override
		public boolean hasNext() {
			
			return elementNumber < size;
			
		}	
		
		/**
		 * Retrieves next element that needs to be processed.
		 */
		@Override
		public SimpleHashtable.TableEntry<K, V> next() {
			
			if(!hasNext()) {
				throw new NoSuchElementException("No more elements!");
			}
			
			if(currentNode == null) {
				currentSlot++;
				while( currentSlot < table.length ) {	
					currentNode = table[currentSlot];
					if(currentNode != null) {
						TableEntry<K, V> currentNodeReturn = currentNode;
						this.elementNumber++;
						currentNode = currentNode.next;
						return currentNodeReturn;
					}
					else currentSlot++;
				}
				throw new NoSuchElementException("No more elements!");	// Error in program running, shouldn't happen ever but is here for flow control !
			}
			else {
				this.elementNumber++;
				TableEntry<K, V> currentNodeReturn = currentNode;
				currentNode = currentNode.next;
				return currentNodeReturn;	// We return next element in the case when we are in the slot who still have more elements stored
			}
			
		}
		
	}
	
	/**
	 * Method that calculates in which slot of a hash table should object be placed. Slot value is calculated upon key value. 
	 * 
	 * @param key - key upon which corresponding slot is calculated
	 * @return Slot number in which object needs to be placed.
	 */
	private int calculateSlot(K key) {
		
		return Math.abs((key.hashCode() % table.length));
		
	}
	
	/**
	 * Put method places object in a corresponding table slot calculated upon value of a key.
	 * If corresponding slot is empty object is placed on first position in slot. Else, if slot is not empty
	 * every other object is placed as node in linked list that is derived from that table slot.
	 * If there is entry in table with the same key value, then no new object are added in the table but rather corresponding 
	 * object with the same key value is changed to new value using setValue() method.
	 * If key of object that needs to be placed in table is null method throws NullPointerException.
	 * Every object added in table result in size variable incrementation by 1.
	 * 
	 * @param key - key value of an object, key must be different than null
	 * @param value - value of an object, can be null or any other value
	 */
	public void put(K key, V value) {
		
		if(key == null) {
			throw new NullPointerException("Key value can't be null!");
		}
		
		int slot = calculateSlot(key);
		
		if(this.containsKey(key)) {
			
			TableEntry<K, V> currentNode = table[slot];
			while(currentNode.next != null) {
				if(key.equals(currentNode.getKey())) {
					currentNode.setValue(value);
					break;
				}
				else currentNode = currentNode.next;
			}
			
		}
		else {
			
			TableEntry<K, V> node = new TableEntry<>(key, value, null);	
			
			if(table[slot] == null) {
				table[slot] = node;
			}
			else {
				TableEntry<K, V> currentNode = table[slot];
				while(currentNode.next != null) currentNode = currentNode.next;
				currentNode.next = node;
			}
			size++;
			
		}
	}
	
	/**
	 * Method that examines if a key is contained in the hash table.
	 * @param key - key value that we examine whether it is contained in the table
	 * @return true if a key is contained in the table, false otherwise
	 */
	public boolean containsKey(K key) {
		
		int slot = calculateSlot(key);
		
		TableEntry<K, V> currentNode = table[slot];
		
		if(currentNode == null) return false;
		
		while(currentNode.next != null) {
			if(key.equals(currentNode.getKey())) {
				return true;
			}
			else currentNode = currentNode.next;
		}
		return false;
		
	}
	
	/**
	 * Method that search corresponding object specified by the key value and return value of that object.
	 * @param key - key that represents the wanted object
	 * @return value of wanted object
	 */
	public V get(K key) {
		
		int slot = calculateSlot(key);
		
		TableEntry<K, V> currentNode = table[slot];
		
		while(currentNode != null) {
			if(key.equals(currentNode.getKey())) {
				return currentNode.getValue();
			}
			else {
				currentNode = currentNode.next;
			}
		}
		return null;
		
	}
	
	/**
	 * Method that return number of elements that are written in the table.
	 * 
	 * @return number of elements contained in hash table
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Method that search if a specified value is located somewhere in the table and returns corresponding boolean.
	 * 
	 * @param value - value that we are looking for in the table
	 * @return true if value is contained in the table, false otherwise
	 */
	public boolean containsValue(V value) {
		
		int slot = 0;
		
		while(slot < table.length) {
			TableEntry<K, V> currentNode = table[slot];
			while(currentNode != null) {
				if(value.equals(currentNode.getValue())) return true;
				else currentNode = currentNode.next;
			}
			slot++;
		}
		
		return false;
	}
	
	/**
	 * Method that removes object from the hash table. If no object with the given key is located in the table
	 * method doesn't remove anything. With every element removed from the table size variable of the object gets decremented
	 * by 1. 
	 * 
	 * @param key - key value that is used to find an object to remove
	 */
	public void remove(K key) {
		
		int slot = calculateSlot(key);
		TableEntry<K, V> before = table[slot];
		
		if(before == null) return; //throw new NoSuchElementException("Can't remove element that isn't in the table.");
		
		TableEntry<K, V> next = before.next;
		
		if(key.equals(before.getKey())) { 
			
			table[slot] = next;
		
		} 
		else {
			/* With this mechanism we bypasses a nasty bug when we tried to delete a node that isn't in 
			 * the table which resulted with a NullPointException
			 */
			while(next != null) {
				if( !( key.equals( next.getKey() ) ) ) { 
					before = next;
					next = next.next;
				}
				else break;
			}
			if(next == null) return;	//throw new NoSuchElementException("Element is not in the table.");
			if(next.next == null) before.next = null;
			else {
				before.next = next.next;
				next = null;
			}
		}
		
		this.size--;
		
	}
	
	/**
	 * Returns a string value of an object SimpleHashtable. String returned contains keys and values of every element in the 
	 * table in the format "key : value", every object of the table is in the separated line of a string.
	 */
	@Override
	public String toString() {
		
		String stringRepresentation = "";
		
		int length = table.length;
		for(int i = 0; i < length; i++) {
			TableEntry<K, V> currentNode = table[i];
			
			while(currentNode != null) { // We are sure that all keys and value up to null reference are not empty
					
				stringRepresentation += ( currentNode.getKey() + " : " + currentNode.getValue().toString() + "\n" );
				currentNode = currentNode.next;
			}
		}
		
		return stringRepresentation;
		
	}

	/**
	 * Examines if the given hash table is empty.
	 * @return true if all table slots are null, false otherwise.
	 */
	//@Override
	public boolean isEmpty() {
		for(int i = 0, lgth = this.table.length; i < lgth; i++) {
			if(this.table[i] != null) return false; 
		}
		
		return true;
	}
	
}
