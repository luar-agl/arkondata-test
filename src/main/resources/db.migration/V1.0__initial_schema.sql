
drop table  if exists vehicle;
drop table  if exists town_hall;

create table town_hall(
                          id bigserial primary key not null,
                          id_provided bigint not null,
                          full_text text,
                          name varchar(100) not null,
                          cve_mun integer,
                          cve_ent integer,
                          cve_geo integer,
                          gid integer,
                          geo_point_2d varchar (150) not null,
                          geo_shape text not null

);

create table vehicle(
    id bigserial primary key not null,
    id_provided bigint not null,
    full_text varchar(255),
    date_updated timestamp not null,
    vehicle_id bigint not null,
    vehicle_label varchar(255),
    vehicle_current_status integer,
    position_latitude double precision not null,
    position_longitude double precision not null,
    geographic_point varchar not null,
    position_speed integer,
    position_odometer integer,
    trip_schedule_relationship integer,
    trip_route_id integer,
    town_hall_id bigint not null,
    foreign key(town_hall_id) references town_hall(id)
);

