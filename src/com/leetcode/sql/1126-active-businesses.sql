SELECT business_id
FROM Events
JOIN (SELECT event_type, AVG(occurences) AS 'average'
    FROM Events
    GROUP BY event_type) AS TEMP ON TEMP.event_type = Events.event_type AND Events.occurences > TEMP.average
GROUP BY business_id
HAVING COUNT(DISTINCT Events.event_type) > 1;

-- Write an SQL query to find all active businesses.
--
-- An active business is a business that has more than one event type with occurences greater
-- than the average occurences of that event type among all businesses.
--
-- The query result format is in the following example:
--
-- Events table:
-- +-------------+------------+------------+
-- | business_id | event_type | occurences |
-- +-------------+------------+------------+
-- | 1           | reviews    | 7          |
-- | 3           | reviews    | 3          |
-- | 1           | ads        | 11         |
-- | 2           | ads        | 7          |
-- | 3           | ads        | 6          |
-- | 1           | page views | 3          |
-- | 2           | page views | 12         |
-- +-------------+------------+------------+
--
-- Result table:
-- +-------------+
-- | business_id |
-- +-------------+
-- | 1           |
-- +-------------+
-- Average for 'reviews', 'ads' and 'page views' are (7+3)/2=5, (11+7+6)/3=8, (3+12)/2=7.5 respectively.
-- Business with id 1 has 7 'reviews' events (more than 5) and 11 'ads' events (more than 8) so it is an active business.