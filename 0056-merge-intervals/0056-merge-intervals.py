class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res: List[List[int]] = []
        intervals.sort()
        cur: List[int] = intervals[0]
        for i in range(1, len(intervals)):
            if(intervals[i][0] <= cur[1]):
                cur[1] = max(cur[1], intervals[i][1])
            else:
                res.append(cur)
                cur = intervals[i]
        res.append(cur)
        return res
        