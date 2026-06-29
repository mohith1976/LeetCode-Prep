class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_water = 0
        left = 0
        right = len(height) - 1
        
        while left < right:
            # Width is the horizontal distance between the two vertical lines
            width = right - left
            
            # The height of the water is limited by the shorter of the two lines
            current_height = min(height[left], height[right])
            
            # Calculate the area and update max_water if this container holds more
            current_water = width * current_height
            max_water = max(max_water, current_water)
            
            # Strategically move the pointer pointing to the shorter line inward
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
                
        return max_water