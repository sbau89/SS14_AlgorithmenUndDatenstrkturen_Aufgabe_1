/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Map;

/**
 *
 * @author Stephan
 * @param <K> key
 * @param <V> value
 */
@SuppressWarnings("unchecked")
public class MapDictionary<K, V>
        extends java.lang.Object
        implements Dictionary<K, V> {

    private final Map<K, V> map;
    private final String art;

    public MapDictionary(Map<K,V> m, String s) {
        map = m;
        art = s;
    }

    @Override
    public V insert(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public V search(K key) {
        return map.get(key);
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(art + ":" + "\r\n\r\n Eintraege:%d\r\n\r\n", map.size()));
        map.entrySet().stream().forEach((e) -> {
            K k = e.getKey();
            V v = e.getValue();
            sb.append(String.format("\t%s = %s\r\n", k.toString(), v.toString()));
        });
        return sb.toString();
    }
}
