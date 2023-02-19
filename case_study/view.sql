use md4_furama;

-- DELIMITER $$
-- create procedure select_all_contract_dto(out id int, out facility_name varchar(100),
-- out customer_name varchar(100), out start_date date, out end_date date, out deposit double, out total_cost double)
-- begin
-- select c.id, f.name, cus.name ,c.start_date, c.end_date, c.deposit, (ifnull(f.cost,0) + sum( ifnull(cd.quantity , 0)* ifnull(af.cost,0))) 
-- into  id, facility_name,  customer_name, start_date, end_date, deposit, total_cost
--  from contract c 
-- left join facility f on c.facility_id = f.id
-- left join customer cus on c.customer_id = cus.id
-- left join contract_detail cd on c.id = cd.contract_id
-- left join attach_facility af on af.id = cd.attach_facility_id
-- group by c.id
-- order by c.id;
-- end $$
-- DELIMITER ;

CREATE VIEW select_all_contract_dto as
select c.id as id, f.name as facility_name, cus.name as customer_name, 
c.start_date as start_date, c.end_date as end_date, c.deposit as deposit,
   (ifnull(f.cost,0) + sum( ifnull(cd.quantity , 0)* ifnull(af.cost,0))) as total_cost
 from contract c 
left join facility f on c.facility_id = f.id
left join customer cus on c.customer_id = cus.id
left join contract_detail cd on c.id = cd.contract_id
left join attach_facility af on af.id = cd.attach_facility_id
group by c.id
order by c.id;


CREATE VIEW select_attach_facility1 as
select cd.id ,c.id as contract_id , af.id as attach_facility_id ,cd.quantity
from contract c 
join contract_detail cd on c.id = cd.contract_id
left join attach_facility af on af.id = cd.attach_facility_id;


CREATE VIEW select_attach_facility as
select cd.id ,c.id as contract_id , af.name as attach_facility_name, cd.quantity
from contract c 
join contract_detail cd on c.id = cd.contract_id
left join attach_facility af on af.id = cd.attach_facility_id;

-- DELIMITER $$
-- create procedure select_all_contract_dto()
-- begin
-- select c.id as id, f.name as facility_name, cus.name as customer_name, 
-- c.start_date as start_date, c.end_date as end_date, c.deposit as deposit,
--    (ifnull(f.cost,0) + sum( ifnull(cd.quantity , 0)* ifnull(af.cost,0))) as total_cost
--  from contract c 
-- left join facility f on c.facility_id = f.id
-- left join customer cus on c.customer_id = cus.id
-- left join contract_detail cd on c.id = cd.contract_id
-- left join attach_facility af on af.id = cd.attach_facility_id
-- group by c.id
-- order by c.id;
-- end $$
-- DELIMITER ;



-- DELIMITER $$
-- create procedure count_all(out css int)
-- begin
-- select count(*) from facility into css;
-- end $$
-- DELIMITER ;

-- call count_all();

-- DELIMITER $$
-- create procedure select_attach_facility_by_id(id int)
-- begin
-- select c.id as contract_id , af.name as attach_facility_name, af.cost as attach_facility_cost ,cd.quantity
-- from contract c 
-- join contract_detail cd on c.id = cd.contract_id
-- left join attach_facility af on af.id = cd.attach_facility_id
-- where c.id = id;
-- end $$
-- DELIMITER ;