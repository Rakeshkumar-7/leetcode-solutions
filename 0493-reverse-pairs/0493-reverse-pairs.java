class Solution {
    private int merge(int[] nums, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        
        int count = 0;
        for(int i=low; i<=mid; i++){
            while(right <= high && nums[i] > 2*(long)nums[right]){
                count += mid - i + 1;
                right++;
            }
        }
        right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]);
            }else{
                temp.add(nums[right++]);
            }
        } 

        while(left <= mid){
            temp.add(nums[left++]);
        }
        while(right <= high){
            temp.add(nums[right++]);
        }

        for(int i=low; i<=high; i++){
            nums[i] = temp.get(i-low);
        }

        return count;
    }    
    private int mergeSort(int[] nums, int low, int high){
        int count = 0;
        if(high > low){
            int mid = (low + high)/2;

            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid+1, high);

            count += merge(nums, low, mid, high);
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}