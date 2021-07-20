class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()==0) return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(s);
        boolean flag=false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<q.size();i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag=true;
                    result.add(curr); 
                }
                
                if(!flag){
                    for(int k=0;k<curr.length();k++){
                        if(Character.isLetter(curr.charAt(k))) continue;
                        String child=curr.substring(0,k)+curr.substring(k+1,curr.length());
                        if(!visited.contains(child)){
                            q.add(child);
                        }
                        visited.add(child);
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count=0;
        for(int j=0;j<s.length();j++){
            if(Character.isLetter(s.charAt(j))) continue;
            if(s.charAt(j)==')'){
                if(count==0) return false;
                count--;
            }else if(s.charAt(j)=='('){
                count=count+1;
            }
        }
        return count==0;
    }
}