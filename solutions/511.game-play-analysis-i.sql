--
-- @lc app=leetcode id=511 lang=mysql
--
-- [511] Game Play Analysis I
--

-- @lc code=start
# Write your MySQL query statement below
SELECT A.player_id, MIN(A.event_date) as first_login FROM Activity A GROUP BY A.player_id;
-- @lc code=end

