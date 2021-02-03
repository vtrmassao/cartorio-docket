create table certificate (id bigint AUTO_INCREMENT, name varchar(255), registry_id bigint, primary key (id));
create table registry (id bigint AUTO_INCREMENT, address varchar(255), name varchar(255), primary key (id));
alter table certificate add constraint fk_registry foreign key (registry_id) references registry(id);
