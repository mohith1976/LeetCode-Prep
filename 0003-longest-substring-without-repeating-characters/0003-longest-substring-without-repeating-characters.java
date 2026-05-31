class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int Maxlen =0; int left=0;

        HashMap<Character,Integer> hm = new HashMap<>();

       for(int right=0; right< s.length();right++)
       {
            char c = s.charAt(right);
            
              if(hm.containsKey(c) && hm.get(c)>= left)
              {
                  left = hm.get(c) +1 ;
              }


            hm.put(c,right);
            Maxlen = Math.max(Maxlen,right-left+1);
       }
       
       return Maxlen;
        
    }
}