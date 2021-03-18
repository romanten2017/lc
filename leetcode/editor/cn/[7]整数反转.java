//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2612 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        boolean flag = false;
        if(str.charAt(0) == '-'){ //indexOf 查找字符出现的位置
            str = str.substring(1,str.length()); //结束索引不包括
            flag = true;
        }
        char[] arr = str.toCharArray();
        int len = arr.length/2;
        if(arr.length%2 != 0) len += 1;
        for(int i=0;i<len;++i) { //1234
            char tmp = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[i];
            arr[i] = tmp;
        }
        String ans = String.valueOf(arr);//arr.toString() 数组输出为类名@HashCode
        if(flag == true) ans = "-" + ans;
        try{
            return Integer.parseInt(ans);
        }catch(Exception e){
            return 0;
        }
    }
    /*
    public int reverse(int x) {
        long n = 0;
        while(x!=0){
            n = n*10 + x%10;
            x /= 10;
        }
        return (int)n==n? (int)n:0;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
