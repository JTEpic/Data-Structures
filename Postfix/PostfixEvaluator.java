 /**
 * Write a description of class PostfixEvaluator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Stack;
public class PostfixEvaluator
{
    public static int evaluate(String expression) throws PostfixException {
        Stack<Integer> stack=new Stack<Integer>();
        Scanner scan=new Scanner(expression);
        int value,operand1,operand2,result=0;
        String operator;
        while(scan.hasNext()){
            if(scan.hasNextInt()){
                value=scan.nextInt();
                //if(stack.isFull())
                //throw new PostfixException("bruh");
                stack.push(value);
                } else{
                operator=scan.next();
                if(!(operator.equals("/")||operator.equals("*")||operator.equals("+")||operator.equals("-")))
                throw new PostfixException("illegal");
                if(stack.isEmpty())
                throw new PostfixException("STOP");
                operand2=stack.peek();
                stack.pop();
                if(stack.isEmpty())
                throw new PostfixException("STOP");
                operand1=stack.peek();
                stack.pop();
                if(operator.equals("/"))
                result=operand1/operand2;
                else if(operator.equals("*"))
                result=operand1*operand2;
                else if(operator.equals("+"))
                result=operand1+operand2;
                else if(operator.equals("-"))
                result=operand1-operand2;
                stack.push(result);
            }
        }
        if(stack.isEmpty())
        throw new PostfixException("AHFEUVADK");
        result=stack.peek();
        stack.pop();
        if(!stack.isEmpty())
        throw new PostfixException("no");
        return result;
    }
}