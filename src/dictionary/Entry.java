/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author sbau8_000
 * @param <K>
 * @param <V>
 */
public class Entry<K, V> {

    K key;
    V value;
//

    Entry(K k, V v) {
        key = k;
        value = v;
    }
}
