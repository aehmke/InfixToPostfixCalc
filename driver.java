import java.util.Scanner;
import java.util.EmptyStackException;

public class driver {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
Stacks Stacks = new Stacks();
System.out.println("Welcome to my calculator!");
System.out.println("Enter an infix expression:");
char redo ='y';
while (redo == 'y') {
String expression = scan.nextLine();
if (expression.length() == 0) {
throw new EmptyStackException();
}
String postfix = Stacks.convertToPostfix(expression);
System.out.println(Stacks.evaluation(postfix));
System.out.println("Evaluate another infix expression? (y/n)");
Scanner  scanner = new Scanner(System.in);
redo = scanner.nextLine().charAt(0);
}
}
}