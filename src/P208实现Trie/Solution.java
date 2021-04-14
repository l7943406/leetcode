package P208实现Trie;


class Trie {
    Tree root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Tree();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Tree root = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.tree[c - 'a'] == null) {
                Tree newNode = new Tree();
                root.tree[c - 'a'] = newNode;
                root = newNode;
            } else {
                root = root.tree[c - 'a'];
            }
        }
        root.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Tree ans = getNode(word);
        return ans != null && ans.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    public Tree getNode(String word) {
        Tree root = this.root;
        for (int i = 0; i < word.length(); i++) {
            if(root.tree[word.charAt(i) - 'a'] == null){
                return null;
            }
            root = root.tree[word.charAt(i) - 'a'];
        }
        return root;
    }


    class Tree{
        Tree[] tree = new Tree[26];
        boolean isWord;
    }
}