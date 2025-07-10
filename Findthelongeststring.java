class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
        String word = null;
    }

    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
        node.word = word;
    }

    public String longestString(String[] words) {
        for (String word : words) {
            insert(word);
        }

        String[] result = new String[]{""};
        dfs(root, result);
        return result[0];
    }

    private void dfs(TrieNode node, String[] result) {
        if (node != root && !node.isEnd) return;

        if (node.word != null) {
            if (node.word.length() > result[0].length() || 
               (node.word.length() == result[0].length() && node.word.compareTo(result[0]) < 0)) {
                result[0] = node.word;
            }
        }

        for (char ch : node.children.keySet()) {
            dfs(node.children.get(ch), result);
        }
    }
}
