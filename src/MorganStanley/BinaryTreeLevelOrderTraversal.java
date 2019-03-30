package MorganStanley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayList<TreeNode> greyNodes = new ArrayList<>();
            HashMap<TreeNode, Integer> d = new HashMap<>();
            ArrayList<TreeNode> q = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            result.add(new ArrayList<>());
            result.get(0).add(root.val);
            d.put(root, 0);
            q.add(root);
            greyNodes.add(root);
            while (!q.isEmpty()) {
                TreeNode u = q.remove(0);
                ArrayList<TreeNode> children = new ArrayList<>();
                if (u.left != null) children.add(u.left);
                if (u.right != null) children.add(u.right);
                for (TreeNode node : children)
                    if (!greyNodes.contains(node)) {
                        greyNodes.add(node);
                        int level = d.get(u) + 1;
                        if (result.size() <= level) {
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            arrayList.add(node.val);
                            result.add(arrayList);
                        } else result.get(level).add(node.val);
                        d.put(node, level);
                        q.add(node);
                    }
            }
            return result;
        }
    }
}
