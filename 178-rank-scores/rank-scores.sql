# Write your MySQL query statement below

SELECT
    s.score,
    (
        SELECT COUNT(DISTINCT x.score)
        FROM Scores x
        WHERE x.score > s.score
    ) + 1 AS `rank`
FROM Scores s
ORDER BY s.score DESC;