package medium;

public class Solution105 {

    public static void main(String[] args) {
        System.out.println(new Solution105());
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        return buildTree(0, 0, preorder.length);
    }

    int[] pre, in;

    TreeNode buildTree(int ps, int is, int len) {
        if (len == 0) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int pos = is;
        while (pre[ps] != in[pos]) ++pos;
        root.left = buildTree(++ps, is, pos -= is);
        root.right = buildTree(ps + pos++, is + pos, len - pos);
        return root;
    }
}

