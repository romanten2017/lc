//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 411 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            List<TreeNode> lis = new ArrayList<>();
            List<Integer> lineLis = new ArrayList<>();
            int cnt = queue.size();
            for(int i=0;i<cnt;++i){
                lis.add(queue.poll());
            }
            if(flag) //只有输出和层序遍历相反
                for(int i=0;i<lis.size();++i){
                    lineLis.add(lis.get(i).val);
                }
            else
                for(int i=lis.size()-1;i>=0;--i){
                    lineLis.add(lis.get(i).val);
                }
            flag = !flag;
            for(TreeNode tmpNode:lis){
                if(tmpNode.left != null) queue.offer(tmpNode.left);
                if(tmpNode.right != null) queue.offer(tmpNode.right);
            }
            ans.add(lineLis);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
