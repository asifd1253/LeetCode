class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String directories[] = path.split("/");

        for(String directory : directories){
            if(directory.isEmpty() || directory.equals(".")){
                continue;
            }

            if(directory.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(directory);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String curDir : st){
            sb.append("/").append(curDir);
        }

        return (sb.length() == 0)?"/":sb.toString();
    }
}