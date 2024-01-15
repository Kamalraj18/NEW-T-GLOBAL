create OR REPLACE view  vw_all_details as
select distinct actors.actor_id id,
actors.first_name||' '||actors.last_name actor_name,
directors.first_name||' '||directors.last_name director_name,
movies.movie_name,movies_revenues.revenue_domestic,
movies_revenues.revenue_international
from actors INNER JOIN movies_actors on actors.actor_id=movies_actors.actor_id
INNER JOIN movies ON movies_actors.movie_id = movies.movie_id 
inner join movies_revenues ON movies.movie_id=movies_revenues.movie_id
INNER JOIN directors on movies.director_id=directors.director_id where revenue_domestic is not null and revenue_international is not null;
/

create table movies_actors(
actor_id int references actors(actor_id),
movie_id int references movies(movie_id),
primary key(actor_id,movie_id)
)
/

select * from vw_all_details;
/
desc actors;