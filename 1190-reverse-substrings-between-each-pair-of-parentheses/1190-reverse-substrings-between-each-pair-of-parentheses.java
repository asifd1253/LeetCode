class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch != ')'){
                stack.push(ch);
            }else{
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
                // if(stack.isEmpty()){
                //     str.append(sb.toString());
                // }
                for(char c : sb.toString().toCharArray()){
                    stack.push(c);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}