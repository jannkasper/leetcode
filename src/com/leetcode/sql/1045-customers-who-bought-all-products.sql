SELECT customer_id
FROM (
    SELECT DISTINCT customer_id, product_key
    FROM Customer
    GROUP BY customer_id, product_key
    )
GROUP BY customer_id
HAVING COUNT(*) = (SELECT DISTINCT product_key FROM Product);


SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(DISTINCT product_key) FROM Product);

-- Write an SQL query for a report that provides the customer ids from the Customer table that bought all the products in the Product table.
--
-- For example:
--
-- Customer table:
-- +-------------+-------------+
-- | customer_id | product_key |
-- +-------------+-------------+
-- | 1           | 5           |
-- | 2           | 6           |
-- | 3           | 5           |
-- | 3           | 6           |
-- | 1           | 6           |
-- +-------------+-------------+
--
-- Product table:
-- +-------------+
-- | product_key |
-- +-------------+
-- | 5           |
-- | 6           |
-- +-------------+
--
-- Result table:
-- +-------------+
-- | customer_id |
-- +-------------+
-- | 1           |
-- | 3           |
-- +-------------+
-- The customers who bought all the products (5 and 6) are customers with id 1 and 3.