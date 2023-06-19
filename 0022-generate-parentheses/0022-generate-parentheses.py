class Solution:
    def generate(self, res: List[str], cur: str, n: int, _open: int):
        if(n == 0 and _open == 0):
            res.append(cur)
            # return
        if(n > 0):
            self.generate(res, cur + "(", n-1, _open+1)
        if(_open > 0):
            self.generate(res, cur + ")", n, _open-1)

    def generateParenthesis(self, n: int) -> List[str]:
        res: List[str] = []
        self.generate(res, "", n, 0)
        return res