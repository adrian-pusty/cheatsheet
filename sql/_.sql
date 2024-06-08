select customer.email, rental.inventory_id
from rental
left join customer on rental.customer_id = customer.customer_id;

select film_id from film where length(title) > 15;

SELECT customer_id, count(distinct inventory_id) as count
FROM rental
GROUP BY customer_id;

select rental_rate, special_features, count(distinct rating) as unique_ratings, count(distinct length) as unique_lengths
from film
group by rental_rate, special_features;