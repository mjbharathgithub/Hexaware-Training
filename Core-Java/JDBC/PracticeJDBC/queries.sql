
delimiter $$

create procedure getTechiesName()
begin 
		select employeeName from employee;
end $$

delimiter ;        

delimiter $$

create procedure getTechieNameByid(in id int)
begin 
		select * from employee where employeeid = id;
end $$

delimiter ;        

delimiter $$
create procedure getTechiesDomain(in id int, out domain varchar(255) )
begin 
		select employeedomain into domain from employee where employeeid = id;
end $$

delimiter ; 
