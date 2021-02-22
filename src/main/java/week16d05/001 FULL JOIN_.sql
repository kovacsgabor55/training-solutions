-- UNION két kompatibilis SELECT táblájának az egyesítése
-- a megkötésekre figyeljünk.

-- UNION ALL az ismétlődő recordokat is mutatja majd.	

-- FULL OUTER JOIN nincs mysql-en, de UNIONnal lehet szimulálni
USE `pizzeria`;

SELECT *
	FROM `pizza` AS p RIGHT JOIN `order` AS o 
			ON p.pizza_id = o.pizza_id
UNION
SELECT *
	FROM `pizza` AS p LEFT JOIN  `order` AS o
			ON p.pizza_id = o.pizza_id;
			
SELECT * FROM `order` WHERE customer_id > 9007
	UNION
		SELECT *	FROM `order` WHERE order_id BETWEEN 3004 AND 3008;

			