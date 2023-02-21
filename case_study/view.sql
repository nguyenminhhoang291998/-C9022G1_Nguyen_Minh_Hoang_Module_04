use md4_case_study_furama;

CREATE VIEW select_all_contract_dto as
select c.id as id, f.name as facility_name, cus.name as customer_name, 
c.start_date as start_date, c.end_date as end_date, c.deposit as deposit,
   (ifnull(f.cost,0) + sum( ifnull(cd.quantity , 0)* ifnull(af.cost,0))) as total_cost
 from contract c 
left join facility f on c.facility_id = f.id
left join customer cus on c.customer_id = cus.id
left join contract_detail cd on c.id = cd.contract_id
left join attach_facility af on af.id = cd.attach_facility_id
group by c.id;

CREATE VIEW select_contract_detail as
select cd.id ,c.id as contract_id , af.name as attach_facility_name, cd.quantity
from contract c 
join contract_detail cd on c.id = cd.contract_id
left join attach_facility af on af.id = cd.attach_facility_id;
