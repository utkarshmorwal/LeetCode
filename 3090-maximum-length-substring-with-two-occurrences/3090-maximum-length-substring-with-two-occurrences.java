class Solution {
    public int maximumLengthSubstring(String s) {

        Map<Character,Integer> map=new HashMap<>();

        int l=0,r=0;
        int length=1;
        while(r<s.length()){
            char ch=s.charAt(r);

            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch)>2){
                char chl=s.charAt(l);
                map.put(chl,map.getOrDefault(chl,0)-1);
                l++;
            }

            length=Math.max(r-l+1,length);
            r++;
        }

        return length;
    }
}