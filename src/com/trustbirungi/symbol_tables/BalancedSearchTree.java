package com.trustbirungi.symbol_tables;

public class BalancedSearchTree<Key extends Comparable<Key>, Value> {
    private Node root; // root of the BST

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count; // the number of nodes root at this node

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    // client method of put()
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // server method that encapsulates the implementation of the BST's insertion operation
    private Node put(Node node, Key key, Value value) {
        int compare = key.compareTo(node.key);

        if(node == null) {
            return new Node(key, value);
        } else if(compare < 0) {
            node.left = put(node.left, key, value);
        } else if(compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        // increment the count for the number of nodes rooted at this node
        node.count = 1 + size(node.left) + size(node.right);

        return node;
    }

    public Value get(Key key) {
        Node currentNode = root;

        while(currentNode != null) {
            int compare = key.compareTo(currentNode.key);

            if(compare < 0) {
                currentNode = currentNode.left;
            } else if(compare > 0) {
                currentNode = currentNode.right;
            } else {
                return currentNode.value;
            }
        }

        return null;
    }


    public void delete(Key key) {}

    public Iterable<Key> iterator() {}

    // find and return the smallest key in the BST
    public Key min(Node root) {
        /**
        if(root == null) {
            return root.key;
        } else {
            root = root.left;
            min(root);
        }**/

        while (root != null){
            root = root.left;
            min(root);
        }

        return root.key;
    }

    // find and return the largest key in the BST
    public Key max(Node root) {
        return root.key;
    }

    // find and return the largest key that is <= to a given key
    /*public Key floor(Node root, Key targetKey) {
        int compare = targetKey.compareTo(root.key);

        if(compare == 0) {
            return root.key;
        } else if(compare < 0) {
            root = root.left;
            floor(root, targetKey);
        } else if(compare > 0 && root.right.key.compareTo(targetKey) <= 0) {
            root = root.right;
            floor(root, targetKey);
        }

        return root.key;
    }

    // find and return the smallest key that is >= to a given key
    public Key ceiling(Node root, Key targetKey){
        int compare = targetKey.compareTo(root.key);

        if(compare == 0) {
            return root.key;
        } else if(compare > 0){
            root =
        }
    } */

    // client method for the floor() implementation
    public Key floor(Key key) {
        Node node = floor(root, key);

        if(node == null) {
            return null;
        }

        return node.key;
    }

    //server method that encapsulates the implementation of the BST's floor() operation
    private Node floor(Node root, Key targetKey) {
        if(root == null) {
            return null;
        }

        int compare = targetKey.compareTo(root.key);

        if(compare == 0) {
            return root;
        }

        if(compare < 0) {
            return floor(root.left, targetKey);
        }

        Node node = floor(root.right, targetKey);

        if(node != null) {
            return node;
        } else {
            return root;
        }
    }

    // client method for the size() operation
    public int size() {
        return size(root);
    }

    // server method that encapsulates the implementation of the BST's size() operation
    // compute and return the number of nodes rooted at the given node
    private int size(Node node) {
        if(node == null) {
            return 0;
        }

        return node.count;
    }


    // client method for the rank() operation
    public int rank(Key key) {
        return rank(key, root);
    }

    // server method that encapsulates the implementation of the BST's rank() operation
    // compute and return the number of keys that are less than the given key
    private int rank(Key targetKey, Node node) {
        if(node == null) {
            return 0;
        }

        int compare = targetKey.compareTo(node.key);

        if(compare < 0) {
            return rank(targetKey, node.left);
        } else if(compare > 0) {
            return 1 + size(node.left) + rank(targetKey, node.right);
        } else {
            return size(node.left);
        }
    }

    // returns all the keys in the BST in ascending order
    public Iterable<Key> keys() {
        Queue<Key> keysQueue = new Queue<Key>();

        inorder(root, keysQueue);

        return keysQueue;
    }


    // traverses the left subtree starting from the bottom-most node, then adds the node at the root of the BST,
    // then traverses the right subtree starting from the top-most node.
    // this results into the BST's keys being placed in ascending order
    private void inorder(Node node, Queue<Key> keyQueue) {
        if(node == null) {
            return;
        }

        inorder(node.left, keyQueue);

        inorder(node.right, keyQueue);
    }



}
