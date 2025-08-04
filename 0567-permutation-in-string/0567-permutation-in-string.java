class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l=s1.length();
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String sort = new String(chars);
        System.out.print(sort);
        for(int i=0;i<=s2.length()-l;i++){
            String substr=s2.substring(i,i+l);
            char[] chars2 = substr.toCharArray();
            Arrays.sort(chars2);
            String sortSub = new String(chars2);
            if(sort.equals(sortSub)) return true;
        }
        return false;
    }
}