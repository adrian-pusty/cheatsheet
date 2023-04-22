-- table1
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| col_z         | varchar |
+---------------+---------+
-- table2
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| col_a         | varchar |
+---------------+---------+

select table2.col_a, table1.col_z
from table1
left join table2 on table1.id=table2.id;

select id from table1 where length(col_z) > 15;
