class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res=new ArrayList<>();
         findsol(s,wordDict,"",res);
         return res;
        
    }
    public static void findsol(String s, List<String> dict,String temp, List<String> res){
        if(s.length()==0){
            res.add(temp.trim());
        }
        for(int i=1;i<=s.length();i++){
            String sub=s.substring(0,i);
            if(dict.contains(sub)){
                findsol(s.substring(i),dict,temp+" "+sub,res);
            }
        }
    }
}