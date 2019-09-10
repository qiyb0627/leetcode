package xin.qicloud.array;

import java.util.Arrays;

/**
 * @author qiyb
 * @version 1.0
 * @date 2019/9/9 14:48
 */
public class PublicPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * <p>
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     */

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null && strs.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int len = strs.length;
        //排序
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len - 1].length();
        //排序后，取第一个和最后一个比较，循环两个中，最短的长度的次数
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static String longestCommonPrefixPart2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s) != 0) {
                //查看后一个字符，是否包含s，不包含就把s截掉最后一位，再比较
                s = s.substring(0, s.length() - 1);
                if (s.isEmpty()) {
                    return "";
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] strs = { "caustomer", "car", "cabt"};
        System.out.println(PublicPrefix.longestCommonPrefixPart2(strs));
    }
}
