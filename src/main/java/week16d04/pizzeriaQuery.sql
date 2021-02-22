SELECT * FROM customers ORDER BY customer_name DESC;
SELECT customer_name FROM customers;
SELECT * FROM pizza ORDER BY pizza_price;
SELECT * FROM pizza WHERE pizza_price = (SELECT MAX(pizza_price) FROM pizza);
SELECT AVG(pizza_price) AS average_price FROM `order` INNER JOIN pizza ON `order`.pizza_id = pizza.pizza_id;
SELECT COUNT(*) FROM customers WHERE customer_name LIKE '%a%';
SELECT * FROM pizza WHERE pizza_price>1000 OR pizza_name LIKE '%a%';
SELECT customer_name,order_date FROM customers INNER JOIN `order` ON customers.customer_id = `order`.customer_id;
SELECT order_date,pizza_name FROM `order` INNER JOIN pizza ON `order`.pizza_id = pizza.pizza_id;

