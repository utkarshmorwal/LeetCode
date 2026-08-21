class Solution {
    public int reverse(int x) {
        if(x==Integer.MIN_VALUE) return 0;
        boolean negative=false;
        if(x<0) {
            negative=true;
            x=-1*x;
        }

        StringBuffer s=new StringBuffer();
        s.append(x);
        s.reverse();

        long num=Long.valueOf(s.toString());

        if(negative) num=num*-1;

        if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE) return 0;

        return (int)num;
    }
}