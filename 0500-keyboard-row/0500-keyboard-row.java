class Solution {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for(String word:words){
            String temp=word.toLowerCase();
            char chars[]=temp.toCharArray();
            int a=0,b=0,c=0;
            for(char ch:chars){
                if (ch == 'q' || ch == 'w' || ch == 'e' || ch == 'r' || ch == 't' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'p'){
                    a++;
                }
                else if (ch == 'a' || ch == 's' || ch == 'd' || ch == 'f' || ch == 'g' || ch == 'h' || ch == 'j' || ch == 'k' || ch == 'l'){
                    b++;
                }
                else if (ch == 'z' || ch == 'x' || ch == 'c' || ch == 'v' || ch == 'b' || ch == 'n' || ch == 'm'){
                    c++;
                }
            }
            int n=word.length();
            if(a==n || b==n || c==n){
                list.add(word);
            }
        }
        String res[]=new String[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}