package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateRPNExpressions {
    public static int eval(String RPNExpression) {
        Deque<Integer> intermediateRessults = new LinkedList<>();
        String delimiter = ",";
        String[] symbols = RPNExpression.split(delimiter);

        for(String token : symbols) {
            if(token.length() == 1 && "+-*/".contains(token)) {
                final int y = intermediateRessults.removeFirst();
                final int x = intermediateRessults.removeFirst();
                switch (token.charAt(0)) {
                    case '+':
                        intermediateRessults.addFirst(x + y);
                        break;
                    case '-':
                        intermediateRessults.addFirst(x - y);
                        break;
                    case '*':
                        intermediateRessults.addFirst(x * y);
                        break;
                    case '/':
                        intermediateRessults.addFirst(x / y);
                        break;
                    default:
                        throw new IllegalStateException("Malformed RPN at:" + token);
                }
            }else {
                intermediateRessults.addFirst(Integer.parseInt(token));
            }
        }
        return intermediateRessults.removeFirst();
    }
}
