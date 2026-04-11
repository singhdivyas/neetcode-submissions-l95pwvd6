class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str: tokens){
            if(isNumeric(str)){
                stack.push(Integer.parseInt(str));
            }else {

                int a = stack.pop();
                int b = stack.pop();
                int result = operate(b, a, str);
                stack.push(result);
            }
        }
        return stack.peek();
    }

    public static boolean isNumeric(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
   }

   public static int operate(int a, int b, String op) {
    return switch (op) {
        case "*" -> a * b;
        case "+" -> a + b;
        case "-" -> a - b;
        case "/" -> a / b;
        default -> throw new IllegalArgumentException("Unknown operator: " + op);
    };
}

}

