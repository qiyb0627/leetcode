package xin.qicloud.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author qiyb
 * @version 1.0
 * @date 2019/9/10 19:45
 */
public class IsValid {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:     输入: "()"      输出: true
     * 示例 2:    输入: "()[]{}"   输出: true
     * 示例 3:   输入: "(]"     输出: false
     * 示例 4:   输入: "([)]"   输出: false
     * 示例 5:   输入: "{[]}"  输出: true
     */

    private HashMap<Character, Character> mappings;

    public IsValid() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public Boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != this.mappings.get(c)){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid iv = new IsValid();
        System.out.println(iv.isValid("([]){}"));
    }
}
