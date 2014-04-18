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

    private Entry<K, V>[] entry;
    private int capacity;
    
    
    public HashDictionary(){  
        
    }
   
    public class Entry<K, V> {

        K key;
        V value;

        Entry(K k, V v) {
	  key = k;
	  value = v;
        }
    }
    

    @Override
    public V insert(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V search(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
