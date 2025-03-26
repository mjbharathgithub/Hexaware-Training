-- hackerRank Problems 

-- Joins
select sum(ct.population)
from city ct
inner join country cnt
on ct.countrycode=cnt.code
where continent='Asia';


select cnt.continent,floor(avg(ct.population))
from city ct
inner join country cnt
on ct.countrycode=cnt.code
group by(continent);

-- The report
select 
case 
when grade>=8 then name
else 'NULL'
end,grade,marks
from students ,grades 
where marks>=min_mark and marks<=max_mark
order by grade desc,name asc,marks;

-- Top Competitors
select h.hacker_id,h.name
from submissions sub
 join hackers h on h.hacker_id=sub.hacker_id
 join challenges ch on ch.challenge_id=sub.challenge_id
 join difficulty diff on ch.difficulty_level=diff.difficulty_level
where diff.score=sub.score
group by h.hacker_id,h.name
having count(h.hacker_id)>1
order by count(h.hacker_id) desc,h.hacker_id asc;
