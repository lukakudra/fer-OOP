package hr.fer.oop.lab4.prob2;

import java.util.NoSuchElementException;

/**
 * The class represents a hash table used to implement  an associative array,
 * a structure that can map keys to values. A hash uses a hash method to 
 * calculate an index into an array of slots, from which the desired value
 * can be found.
 * 
 * @author Luka
 *
 * @param <K> key argument
 * @param <V> value argument
 */

public class SimpleHashTable<K,V> {
	private int size;
	private TableEntry<K,V>[] table;
	
	/**
	 * A class that represents an array for the superclass SimpleHashTable.
	 * Class is used to store entries by their key and value.
	 * 
	 * @author Luka
	 *
	 * @param <K> key argument
	 * @param <V> value argument
	 */
	
	private static class TableEntry<K,V> {
		private final K key;
		private V value;
		private TableEntry<K,V> next;
		
		/**
		 * Constructs a new table entry for given key, value and
		 * next table entry in a singly linked list.
		 * 
		 * @param key key argument
		 * @param value value argument
		 * @param next next table entry
		 */
		
		TableEntry(K key, V value, TableEntry<K,V> next) {
			this.key=key;
			this.value=value;
			this.next=next;
		}
		
		/**
		 * Getter for the argument key
		 * @return key
		 */
		
		K getKey() {
			return key;
		}
		
		/**
		 * Getter for the argument value
		 * @return value
		 */
		
		V getValue() {
			return value;
		}
		
		/**
		 * Setter for the argument value
		 * @param value value
		 */
		
		void setValue(V value) {
			this.value=value;
		}
		
		/**
		 * Overrides the original method to print a string representation
		 * of the table entry
		 */
		
		@Override
		public String toString() {
			return "Key: " + getKey() + "," + "Value: " + getValue() + ".";
		}
	}
	
	/**
	 * Constructs a new object that stores entries in a table
	 * of size 16. The object is initially empty.
	 */
	
	@SuppressWarnings("unchecked")
	public SimpleHashTable() {
		table=(TableEntry<K,V>[]) new TableEntry<?,?>[16];
		size=0;
	}
	
	/**
	 * Constructs a new object that stores entries in a table 
	 * with a size of the first power of two that is greater than
	 * or equal to the argument capacity. The object is initially empty.
	 * 
	 * @param capacity capacity of the hash table
	 */
	
	@SuppressWarnings("unchecked")
	public SimpleHashTable(int capacity) {
		if(capacity<0) {
			throw new IllegalArgumentException("Hash table size can not be negative.");
		}
		int pow2=makePowerOfTwo(capacity);
		table=(TableEntry<K,V>[]) new TableEntry<?,?>[pow2];
		size=0;
	}
	
	/**
	 * This method returns an integer value of power of two that
	 * is greater than or equal to the argument n
	 * 
	 * @param n an integer value
	 * @return an integer value that represents the power of two
	 *		   that is greater than or equal to the argument n
	 */
	
	private int makePowerOfTwo(int n) {
		if(n<=0) {
			throw new UnknownError("There is no power of two with this number.");
		}
		int exponent=(int)(Math.ceil(Math.log(n)/Math.log(2)));
		return (int)Math.pow(2, exponent);
	}
	
	/**
	 * This method puts a new entry into the given object by determining
	 * the key's hash code for insertion.
	 * 
	 * @param key key of the entry
	 * @param value value of the entry
	 */
	
	public void put(K key, V value) {
		if(key==null) {
			return;
		}
		
		int hash=Math.abs(key.hashCode())%table.length;
		
		
		if(table[hash]==null) { //hash table is empty
			table[hash]=new TableEntry<>(key, value, null);
			size++;
			
		} else {
			
			TableEntry<K,V> entry=table[hash];
			while(entry.next!=null && entry.getKey()!=key) {
				entry=entry.next;
			}
			if(entry.getKey()==key) {
				entry.setValue(value);
			} else {
				entry.next=new TableEntry<>(key, value, null);
				size++;
			}
		}
	}
	
	/**
	 * This method returns a value of the entry with given key. 
	 * If the entry with that key does not exist, returns null.
	 * 
	 * @param key key of the entry
	 * @return value of the entry if the entry is found, null otherwise
	 */
	
	public V get(K key) {
		if(key==null) {
			return null;
		}
		
		int hash=Math.abs(key.hashCode())%table.length;
		
		if(table[hash]==null) {
			return null;
		}
		
		TableEntry<K,V> entry=table[hash];
		
		while(entry!=null && entry.getKey()!=key) {
			entry=entry.next;
		}
		
		if(entry==null) {
			return null;
		} else {
			return entry.getValue();
		}
	}
	
	/**
	 * This method returns the size of the simple hash table. 
	 * Size is determined by the number of entries in the table
	 * 
	 * @return size of the simple hash table
	 */
	
	public int size() {
		return size;
	}
	
	/**
	 * This method checks if the simple hash table contains a 
	 * certain key, returns true if it does and false if it doesn't.
	 * 
	 * @param key key of the entry
	 * @return true if the searched key is found, false otherwise
	 */
	
	public boolean containsKey(K key) {
		int hash=Math.abs(key.hashCode())%table.length;
		TableEntry<K,V> temp=table[hash];
		while(temp!=null && temp.getKey()!=key) {
			temp=temp.next;
		}
		if(temp!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method checks if the simple hash table contains a
	 * certain value, returns true if it does and false if it doesn't.
	 * 
	 * @param value value of the entry
	 * @return true if the searched value is found, false otherwise
	 */
	
	public boolean containsValue(V value) {
		for(TableEntry<K,V> helpTable : table) {
			if(helpTable==null) {
				continue;
			}
			TableEntry<K,V> temp=helpTable;
			while(temp!=null) {
				if(temp.getValue().equals(value)) {
					return true;
				}
				temp=temp.next;
			}
		}
		return false;
	}
	
	/**
	 * This method removes an existing entry with the given key
	 * @param key key of the entry
	 */
	
	public void remove(K key) {
		
		int hash=Math.abs(key.hashCode())%table.length;
		
		if(table[hash]!=null) {
			TableEntry<K,V> previousEntry=null;
			TableEntry<K,V> entry=table[hash];
			while(entry.next!=null && entry.getKey()!=key) {
				previousEntry=entry;
				entry=entry.next;
			}
			if(entry.getKey()==key) {
				if(previousEntry==null) {
					table[hash]=entry.next;
				} else {
					previousEntry.next=entry.next;
				}
				size--;
			} else {
				throw new NoSuchElementException("Key: \"" + key + "\" does not exist in table.");
			}
		} else {
			throw new NoSuchElementException("Key: \"" + key + "\" does not exist in table.");
		}
	}	
	
	/**
	 * This method determines if the hash table is empty by checking it's size.
	 * Returns true if the size is zero, false otherwise
	 * 
	 * @return true if the size is zero, false otherwise
	 */
	
	public boolean isEmpty() {
		if(size==0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Overrides the existing method to give a string representation of 
	 * the hash table
	 */
	
	@Override
	public String toString(){
		int currentSlot=0;
		StringBuilder output=new StringBuilder();
		while(currentSlot<table.length) {
			TableEntry<K,V> entry=table[currentSlot];
			while(entry!=null) {
				output.append(entry.toString()).append("\n");
				entry=entry.next;
			}
			currentSlot++;
		}
		return output.toString();
	}
}
