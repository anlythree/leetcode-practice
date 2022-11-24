package com.anlythree.subject;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 2022-04-23
 * 安装栅栏
 * 描述：
 * 在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/erect-the-fence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ErectFence {

    public int[][] outerTrees(int[][] trees) {
        // 找出左下角的点在数组中的下标
        int bottomIndex = 0;
        for (int i = 0; i < trees.length; i++) {
            if((trees[bottomIndex][1] > trees[i][1]) ||
                    trees[bottomIndex][1] == trees[i][1] && trees[bottomIndex][0] > trees[i][0]){
                bottomIndex = i;
            }
        }
        // 交换数组中左下角点和数组0位置的元素
        swap(trees,0,bottomIndex);
        // 按极角逆时针(距离由近及远)排序
        Arrays.sort(trees,1,trees.length,(a,b)->{
            int cross = cross(trees[0], a, b);
            if(cross == 0){
                return distance(trees[0],a)-distance(trees[0],b);
            }else {
                return cross;
            }
        });
        System.out.println("排序完成------------------");
        for (int[] anInt : trees) {
            System.out.println(anInt[0]+","+anInt[1]);
        }
        System.out.println("排序完成------------------");
        int r = trees.length - 1;
        while (r >= 0 && cross(trees[0], trees[trees.length - 1], trees[r]) == 0) {
            r--;
        }
        for (int l = r + 1, h = trees.length - 1; l < h; l++, h--) {
            swap(trees, l, h);
        }

        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        stack.push(1);
        for (int i = 2; i <trees.length; i++) {
            int top = stack.pop();
            while (!stack.isEmpty() && cross(trees[top],trees[i],trees[stack.peek()]) > 0){
                top = stack.pop();
            }
            stack.push(top);
            stack.push(i);
        }
        int size = stack.size();
        int[][] res = new int[stack.size()][2];
        for (int i = 0; i < size; i++) {
            res[i] = trees[stack.pop()];
        }
        return res;
    }

    /**
     * 计算向量积 p q，r
     * @param p
     * @param q
     * @param r
     * @return
     */
    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

    /**
     * 返回两点之间距离的平方
     * @param p
     * @param q
     * @return
     */
    public int distance(int[]p , int[]q){
        return (p[0]-q[0])*(p[0]-q[0])+(p[1]-q[1])*(p[1]-q[1]);
    }

    /**
     * 交换数组中的两个位置的元素
     * @param trees
     * @param i
     * @param j
     */
    public void swap(int[][] trees, int i, int j) {
        int temp0 = trees[i][0], temp1 = trees[i][1];
        trees[i][0] = trees[j][0];
        trees[i][1] = trees[j][1];
        trees[j][0] = temp0;
        trees[j][1] = temp1;
    }

    /**
     * [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
     */
    @Test
    public void mainTest() {
        int[][] trees = new int[][]{
                new int[]{1,1},
                new int[]{2,2},
                new int[]{2,0},
                new int[]{2,4},
                new int[]{3,3},
                new int[]{4,2}
        };
        int[][] ints = outerTrees(trees);
        for (int[] anInt : ints) {
            System.out.println(anInt[0]+","+anInt[1]);
        }
    }

    @Test
    public void test1(){
        int cross = new ErectFence().cross(new int[]{2,0}, new int[]{1,1}, new int[]{2,2});
        if(cross == 0){
            System.out.println( new ErectFence().distance(new int[]{2,0},new int[]{1,1})-new ErectFence().distance(new int[]{2,0},new int[]{2,2}));
        }else {
            System.out.println(cross);
        }
    }

    /**
     * 2,0
     * 1,1
     * 2,2
     * 2,4
     * 3,3
     * 4,2
     */
    @Test
    public void test2(){
        //[[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4],[1,3],[1,2],[2,1],[4,2],[0,3]]
        int[][] trees = new int[][]{
                new int[]{2,0},
                new int[]{2,2},
                new int[]{1,1},
                new int[]{2,4},
                new int[]{3,3},
                new int[]{4,2}
        };

        for (int[] anInt : trees) {
            System.out.println(anInt[0]+","+anInt[1]);
        }
        Arrays.sort(trees,1,trees.length,(a,b)->{
            int cross = cross(trees[0], a, b);
            if(cross == 0){
                return distance(trees[0],a)-distance(trees[0],b);
            }else {
                return cross;
            }
        });
        System.out.println("------------------");
        for (int[] anInt : trees) {
            System.out.println(anInt[0]+","+anInt[1]);
        }
    }

    @Test
    public void test13(){
        String a = "[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4],[1,3],[1,2],[2,1],[4,2],[0,3]";
        a.replaceAll("[","{");
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '['){
                chars[i] = '{';
            }
        }
        a=String.copyValueOf(chars);
        System.out.println(a);
    }

    @Test
    public void test14(){
        String a = "[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4],[1,3],[1,2],[2,1],[4,2],[0,3]";
        String replace = StringUtils.replace(a, "[", "{");
        System.out.println(replace);
    }

    @Test
    public void test15(){
        Pattern.compile("[");
    }


}
