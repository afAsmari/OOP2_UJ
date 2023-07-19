public class Node {
    public String expression;
    char operator;
    StringBuilder rightExp;
    Integer result;
    public Node(String expression){
        this.expression = expression.replaceAll(" ", "");
        rightExp = new StringBuilder();
    }

    public Integer Calculate() throws NumberFormatException{

        // case number 1
        if(!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/") && !expression.contains("q")){
            return Integer.parseInt(expression);
        }
        // case number 2
        else if((expression.contains("+") || expression.contains("-")) & (expression.contains("*") || expression.contains("/"))){
            for(int i = expression.length() - 1; i>= 0; i--){
                char c = expression.charAt(i);
                if(c == '+' || c == '-'){
                    operator = c;
                    return result = OperationSwitch(new Node(expression.substring(0, i)), new Node(rightExp.reverse().toString()), operator);
                }else if(Character.isDigit(c) || c == '*' || c == '/' || c == 'q'){
                    rightExp.append(c);
                }else {
                    System.out.println("invalid character");
                }
            }
        }
        // case number 3 it either contains + and - OR * and /
        else{
            for (int i = expression.length() - 1; i >= 0; i--){
                char c = expression.charAt(i);
                if(c == '+' || c == '-' || c == '*' || c == '/'){
                    operator = c;
                    return result = OperationSwitch(new Node(expression.substring(0, i)), new Node(rightExp.reverse().toString()), operator);
                }/*else if (c == 'q'){
                    operator = c;
                    rightExp = evalSqrt(new Node(rightExp.reverse().toString()), operator);g
                }*/
                else if (Character.isDigit(c)){
                    rightExp.append(c);
                }else {
                    System.out.println("invalid character");
                }
            }
        }

        return result;
    }

    /*private StringBuilder evalSqrt(Node right, char operator) {
        StringBuilder sb = new StringBuilder();
        result = Integer.parseInt(Double.toString(Math.sqrt(Double.parseDouble(Integer.toString(right.Calculate())))));

        return sb.append(result);
    }
*/
    private Integer OperationSwitch(Node left, Node right, char operator)throws NumberFormatException {
        switch (operator) {
            case '+' -> result = left.Calculate() + right.Calculate();
            case '-' -> result = left.Calculate() - right.Calculate();
            case '*' -> result = left.Calculate() * right.Calculate();
            case '/' -> result = Math.toIntExact(Math.round((double) left.Calculate() / (double) right.Calculate()));
        }
        return result;
    }



}
