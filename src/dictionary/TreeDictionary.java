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
public class TreeDictionary<K extends java.lang.Comparable<K>, V>
        extends java.lang.Object
        implements Dictionary<K, V> {

    private Node<K, V> root;
    private static int size = 0;
    V oldValue;

    public TreeDictionary() {
    }

    static private class Node<K, V> {

        int height;
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        private Node(K k, V v) {
            height = 0;
            key = k;
            value = v;
            left = null;
            right = null;
        }
    }

    private int getHeight(Node<K, V> p) {
        if (p == null) {
            return -1;
        } else {
            return p.height;
        }
    }

    private int getBalance(Node<K, V> p) {
        if (p == null) {
            return 0;
        } else {
            return getHeight(p.right) - getHeight(p.left);
        }
    }

    @Override
    public V insert(K key, V value) {
        root = insertR(key, value, root);
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    private Node<K, V> insertR(K key, V value, Node<K, V> p) {
        if (p == null) {
            p = new Node(key, value);
            oldValue = null;
        } else if (key.compareTo(p.key) < 0) {
            p.left = insertR(key, value, p.left);
        } else if (key.compareTo(p.key) > 0) {
            p.right = insertR(key, value, p.right);
            // Schlüssel bereits vorhanden; mache nichts;
        } else {
            oldValue = value;
            p.value = value;          
            
        }
        p = balance(p);
        return p;
    }

    private Node<K, V> balance(Node<K, V> p) {
        if (p == null) {
            return null;
        }
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        if (getBalance(p) == -2) {
            if (getBalance(p.left) <= 0) {
                p = rotateRight(p);
            } else {
                p = rotateLeftRight(p);
            }
        } else if (getBalance(p) == +2) {
            if (getBalance(p.right) >= 0) {
                p = rotateLeft(p);
            } else {
                p = rotateRightLeft(p);
            }
        }
        return p;
    }

    private Node<K, V> rotateRight(Node<K, V> p) {
        assert p.left != null;
        Node<K, V> q = p.left;
        p.left = q.right;
        q.right = p;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        q.height = Math.max(getHeight(q.left), getHeight(q.right)) + 1;
        return q;
    }

    private Node<K, V> rotateLeft(Node<K, V> p) {
        assert p.right != null;
        Node<K, V> q = p.right;
        p.right = q.left;
        q.left = p;
        p.height = Math.max(getHeight(p.right), getHeight(p.left)) + 1;
        q.height = Math.max(getHeight(q.right), getHeight(q.left)) + 1;
        return q;
    }

    private Node<K, V> rotateLeftRight(Node<K, V> p) {
        assert p.left != null;
        p.left = rotateLeft(p.left);
        return rotateRight(p);
    }

    private Node<K, V> rotateRightLeft(Node<K, V> p) {
        assert p.right != null;
        p.right = rotateRight(p.right);
        return rotateLeft(p);
    }

    @Override
    public V search(K key) {
        return searchR(key, root);
    }

    private V searchR(K key, Node<K, V> p) {
        if (p == null) {
            return null;
        } else if (key.compareTo(p.key) < 0) {
            return searchR(key, p.left);
        } else if (key.compareTo(p.key) > 0) {
            return searchR(key, p.right);
        } else {
            return p.value;
        }
    }

    public V remove(K key) {
        root = removeR(key, root);
        return oldValue;
    }

    private Node<K, V> removeR(K key, Node<K, V> p) {
        if (p == null) {
            oldValue = null;
        } else if (key.compareTo(p.key) < 0) {
            p.left = removeR(key, p.left);
        } else if (key.compareTo(p.key) > 0) {
            p.right = removeR(key, p.right);
        } else {
            oldValue = p.value;
            if (p.left == null || p.right == null) {
                // p hat ein oder kein Kind:
                p = (p.left != null) ? p.left : p.right;
            } else {
                // p hat zwei Kinder:
                Entry<K, V> min = new Entry<K, V>();
                p.right = getRemMinR(p.right, min);
                p.key = min.key;
                p.value = min.value;
            }
        }
        p = balance(p);
        return p;
    }

    private Node<K, V> getRemMinR(Node<K, V> p, Entry<K, V> min) {
        assert p != null;
        if (p.left == null) {
            min.key = p.key;
            min.value = p.value;
            p = p.right;
        } else {
            p.left = getRemMinR(p.left, min);
        }
        p = balance(p);
        return p;
    }

    private static class Entry<K, V> {

        private K key;
        private V value;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("TreeDictionary:\r\n\r\n");
        appendR(s, root);
        s.append("\r\nEinträge: ").append(size);
        size = 0;
        return s.toString();
    }

    private static void appendR(StringBuilder s, Node p) {
        if (p != null) {
            appendR(s, p.left);
            s.append("\t").append(p.key).append(" = ").append(p.value).append("\r\n");
            size++;
            appendR(s, p.right);
        }
    }
}
