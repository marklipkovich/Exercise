import java.util.Stack;

public class Parentheses {
    public boolean isValid(String s) {
        Character chStack;
        Stack <Character> stack = new Stack();
        for(char ch : s.toCharArray()) {
            if("({[".contains(String.valueOf(ch))){
                stack.push(ch);
            }
            else {
                if (stack.empty())return false;
                chStack = stack.pop();
                switch(ch) {
                    case ')':
                        if (chStack !='(') return false;
                        break;
                    case '}':
                        if (chStack !='{') return false;
                        break;
                    case ']':
                        if (chStack !='[') return false;
                        break;
                }
            }
        }
        return stack.empty();
    }

    public  static void main(String arg[]) {
        Parentheses parentheses = new Parentheses();
        String s = "()[]{}";
        System.out.println(parentheses.isValid(s));
    }
}
