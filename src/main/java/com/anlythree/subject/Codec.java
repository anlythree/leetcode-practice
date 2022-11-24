package com.anlythree.subject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(null == root){
            return null;
        }
        List<Integer> list = new LinkedList<>();
        postOrder(root,list);
        String s = list.toString();
        return s.substring(1,s.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(null == data){
            return null;
        }
        List<String> list = Arrays.asList(data.split(","));
        return construct(list);
    }

    private TreeNode construct(List<String> list) {
        TreeNode treeNode = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        treeNode.left = construct(list);
        treeNode.right = construct(list);
        return treeNode;
    }

    /**
     * 复制二叉树至list中
     * @param root
     * @param list
     */
    private void postOrder(TreeNode root, List list) {
        if(null == root){
            return;
        }
        list.add(root);
        postOrder(root.left,list);
        postOrder(root.right,list);
    }




}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
