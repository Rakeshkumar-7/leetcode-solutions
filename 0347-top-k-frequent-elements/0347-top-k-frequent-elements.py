class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        frequency_dict = {}
        for num in nums:
          frequency_dict[num] = frequency_dict.get(num, 0) +1

        frequency_dict = dict(sorted(frequency_dict.items(),key=lambda a: (a[1]), reverse=True))
        res =[]
        c=k
        for key,n in frequency_dict.items():
            if c==0:
                break
            res.append(key)
            c=c-1
        return res