/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Stephan
 * @param <K>
 * @param <V>
 */
class HashDictionary<K extends java.lang.Comparable<K>, V>
        extends java.lang.Object
        implements Dictionary<K, V> {

    private static final int capacity = 32423;
    static Object[] tab;
    static int size;

    public HashDictionary() {
        tab = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
	  tab[i] = null;
        }
    }

    private static class ChainedEntry<K, V> {

        K key;
        V value;
        ChainedEntry next;

        public ChainedEntry(K k, V v, ChainedEntry p) {
	  key = k;
	  value = v;
	  next = p;
        }
    }

    public int h(K key) {
        int k = key.hashCode() % capacity;
        if (k < 0) {
	  k = k * (-1);
        }
        return k;
    }

    @Override
    public V insert(K key, V value) {
        int k = h(key);
        if (tab[k] == null) {
	  tab[k] = new ChainedEntry(key, value, null);
	  return null;
        } else {
	  ChainedEntry p = (ChainedEntry) tab[h(key)];
	  while (!p.key.equals(key) && p.next != null) {
	      p = p.next;
	  }
	  if (!p.key.equals(key)) {
	      p.next = new ChainedEntry(key, value, null);
	      return null;
	  }
	  if (p.key.equals(key)) {
	      V v = (V) p.value;
	      p.value = value;
	      return v;
	  }
        }
        return null;
    }

    @Override
    public V search(K key) {
        ChainedEntry p = (ChainedEntry) tab[h(key)];
        if(p == null){
            return null;
        } else{
        while (!p.key.equals(key) && p.next != null) {
	  p = p.next;
        }
        if (p.key.equals(key)) {
	  return (V) p.value;
        } else {
	  return null;
        }

    }}

    @Override
    public V remove(K key) {
        ChainedEntry p = (ChainedEntry) tab[h(key)];
        if(p.next == null){
            V value = (V) p.value;
            tab[h(key)] = null;
            return value;
        } else{
        while (!p.next.key.equals(key) && p.next != null) {
	  p = p.next;
        }
        if (p != null) {
	  V value = (V) p.next.value;
	  p.next = p.next.next;
	  return (V) p.value;
        } else {
	  return null;
        }
    }}

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("HashDictionary:\r\n\r\n");
        appendS(s);
        s.append("\r\nEinträge: ").append(size);
        size = 0;
        return s.toString();
    }

    private static void appendS(StringBuilder s) {
        for (int i = 0; i < capacity; i++) {
	  ChainedEntry entry = (ChainedEntry) tab[i];
	  for (ChainedEntry e; entry != null; entry = entry.next) {
	      s.append("\t").append(entry.key).append(" = ").append(entry.value).append("\r\n");
	      size++;
	  }
        }
    }
}
