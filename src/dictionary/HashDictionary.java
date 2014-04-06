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
public class HashDictionary<K, V>
        extends java.lang.Object
        implements Dictionary<K, V> {

    private int size;
    private Entry<K, V>[] entry;

    public HashDictionary() {
    }

    public HashDictionary(int size) {
        this.size = size;
        entry = new Entry[size];
        for (int i = 0; i <= size - 1; i++) {
            entry[i] = null;
        }

    }

    private int h(Entry entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class ChainedTableEntry extends Entry {

        ChainedTableEntry(Entry key, Entry value) {
            super(key, value);
            this.next = null;
        }
        private ChainedTableEntry next;
    }

    class ChainedHashTable extends Entry {

        public ChainedHashTable(Entry k, Entry v) {
            super(k, v);
        }

        int h(Entry key) {
            return key.hashCode() % size;
        }
    }

    @Override
    public V insert(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V search(K key) {
        ChainedTableEntry p;
        p = (ChainedTableEntry) entry[h((Entry) key)];
        while (p != null && !p.key.equals(key)) {
            p = p.next;
        }
        if (p != null) {
            return (V) p.value;
        } else {
            return null;
        }
    }

    @Override
    public V remove(K key
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
