class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;
        int i = 0;
        int j = n-1;
        int max_area = 0;

        while(i<j)
        {
            if(height[i]>height[j])
            {
                max_area = Math.max(Math.min(height[i],height[j])*(j-i), max_area);
                j--;
                
                 
            }else 
            {
                max_area = Math.max(Math.min(height[i],height[j])*(j-i), max_area);
                i++;
                
            }
           
             

           
        }
        return max_area;
    }
}