class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();

        String words[] = path.split("/");

        for(String word:words){
            if(word.isEmpty() || word.equals(".")){
                continue;
            }

            if(word.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(word);
            }
        }

        String res="";

        for(String curName:st){
            res = res+"/"+curName;
        }

        return res.length()==0 ? "/" : res;
    }
}