/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Stephan
 */
public class SortedArrayDictionary<K extends java.lang.Comparable<? super K>, V>
        extends java.lang.Object
        implements Dictionary<K, V> {
    
    public class Entry<K, V> {
    K key;
    V value;

    Entry(K k, V v) {
        key = k;
        value = v;
    }
}

    private static final int DEF_CAPACITY = 20;
    private int size;
    private Entry<K, V>[] entry;

    @SuppressWarnings("unchecked")
    public SortedArrayDictionary() {
        size = 0;
        entry = new Entry[DEF_CAPACITY];
    }
    @SuppressWarnings("unchecked")
    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }
        Entry[] old = entry;
        entry = new Entry[newCapacity];
        System.arraycopy(old, 0, entry, 0, size);
    }
    // einfügen
    @Override
    public V insert(K key, V value) {
        int i = searchKey(key);
        // Vorhandener Beitrag wird überschrieben
        if (i != -1) {
            V r = entry[i].value;
            entry[i].value = value;
            return r;
        }
        //Neueintrag
        if (entry.length == size) {
            ensureCapacity(2 * size);
        }
        int j = size - 1;
        while (j >= 0 && key.compareTo(entry[j].key) < 0) {
            entry[j + 1] = entry[j];
            j--;
        }
        entry[j + 1] = new Entry<K, V>(key, value);
        size++;
        return null;
    }

    private int searchKey(K key) {
        int li = 0;
        int re = size - 1;

        while (re >= li) {
            int m = (li + re) / 2;
            if (key.compareTo(entry[m].key) < 0) {
                re = m - 1;
            } else if (key.compareTo(entry[m].key) > 0) {
                li = m + 1;
            } else {
                return m;
            }
        }
        return -1;

    }
    // suchen
    @Override
    public V search(K key) {
        int i = searchKey(key);
        if (i >= 0) {
            return entry[i].value;
        } else {
            return null;
        }
    }
    // löschen
    @Override
    public V remove(K key) {
        int i = searchKey(key);
        if (i == -1) {
            return null;
        }
        V r = entry[i].value;
        for (int j = i; j < size - 1; j++) {
            entry[j] = entry[j + 1];
        }
        entry[--size] = null;
        return r;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SortedArrayDictionary\r\n\r\nEintraege:%d\r\n\r\n", this.size));
        for (int i = 0; i < this.size; i++) {
            sb.append(String.format("\t%s = %s\r\n", entry[i].key.toString(), entry[i].value.toString()));
        }
        return sb.toString();
    }
}
