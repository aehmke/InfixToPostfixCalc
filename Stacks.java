import java.util.Stack;

public class Stacks extends driver {

String expression;

public static boolean isOperator(char c)
{
return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'
|| c == '(' || c == ')';
}

private static int getPrecedence(char ch) {
switch (ch) {
case '+':
case '-':
return 1;

case '*':
case '/':
return 2;
}
return -1;
}
public String convertToPostfix(String infix) {
expression = infix;
Stack<Character> stack = new Stack<Character>();
        StringBuffer postfix = new StringBuffer(infix.length());
        char c;

        for (int i = 0; i < infix.length(); i++) {
        c = infix.charAt(i);

        if (Character.isDigit(c)) {
        postfix.append(c);
        for (int j = i + 1; j < infix.length(); j++) {

        if (Character.isDigit(infix.charAt(j))) {
        postfix.append(infix.charAt(j));
        i++;
        } else {
        postfix.append(".");
        break;
        }
        }
        if (Character.isDigit(postfix.charAt(postfix.length() - 1))) {
        postfix.append(".");
        }
        } else if (c == '(') {
        stack.push(c);
        } else if (c == ')') {

        while (!stack.isEmpty() && stack.peek() != '(') {
        postfix.append(stack.pop());
        }
        if (!stack.isEmpty() && stack.peek() != '(') {
        return null;
        } else if (!stack.isEmpty()) {
        stack.pop();
        }
        } else if (isOperator(c)) {
        if (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
        postfix.append(stack.pop());
        postfix.append(".");
        }
        stack.push(c);
        }
        }

        while (!stack.isEmpty()) {
        postfix.append(stack.pop());
        }
        return postfix.toString();
        }

        public Integer evaluation(String postfix) {
        postfix += ".";
        int result = 0;
        Stack<Integer> resultStack = new Stack<Integer>();
                while (!postfix.isEmpty()) {
                int dotPos = postfix.indexOf(".");
                String m = postfix.substring(0, dotPos);
                postfix = postfix.substring(1 + dotPos, postfix.length());
                if (Character.isDigit(m.charAt(0))) {
                Integer n = Integer.parseInt(m);
                resultStack.push(n);
                } else if (isOperator(m.charAt(0))) {
                for (int i = 0; i < m.length(); i++) {
                int op2 = resultStack.pop();
                int op1 = resultStack.pop();
                if (m.charAt(i) == ('*')) {
                result = +op1 * op2;
                } else if (m.charAt(i) == ('/')) {
                result = +op1 / op2;
                } else if (m.charAt(i) == ('+')) {
                result = +op1 + op2;
                } else {
                result = +op1 - op2;
                }
                resultStack.push(result);
                }
                }
                }
                return result;
                }

                }