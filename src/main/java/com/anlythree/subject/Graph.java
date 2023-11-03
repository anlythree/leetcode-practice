package com.anlythree.subject;


import java.util.*;

/**
 * 链表类型结构的深度优先遍历和广度优先遍历
 */
public class Graph {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        // 栈顶永远是当前正在处理的节点 ，栈内从顶到根部就是当前
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();//确保不重复
        stack.add(node);
        set.add(node);
        System.out.println(node.value);//处理行为
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);//栈永远保持深度优先的路径
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);//处理行为
                    break;//注意break
                }
            }
        }
    }

    public static void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        Set<Node> sets = new HashSet<>();
        queue.add(node);
        sets.add(node);
        // 遍历操作
        System.out.println("遍历节点:"+node.value);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            for (Node next :poll.nexts){
                if(sets.contains(next)){
                    continue;
                }
                queue.add(node);
                queue.add(next);
                sets.add(node);
                //  遍历操作
                System.out.println("遍历节点:"+next.value);
                break;
            }
        }

    }


    public static class Node{
        private String value;

        private List<Node> nexts;


        public Node(String value, List<Node> nexts) {
            this.value = value;
            this.nexts = nexts;
        }

        public String getValue() {
            return value;
        }

        public List<Node> getNexts() {
            return nexts;
        }
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.add("a"));
        System.out.println(stack.push("b"));
    }

}
