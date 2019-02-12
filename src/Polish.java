import java.util.Stack;

public class Polish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int a;
        int b;
        for (String s : tokens) {
            if(!"+-*/".contains(s)){
                stack.push(Integer.valueOf(s));
            }
            else {
                a = stack.pop();
                b = stack.pop();
                switch (s){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(b-a);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(b/a);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public  static void main(String arg[]) {
        Polish polish = new Polish();
        String[] s = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(polish.evalRPN(s));
    }
}
