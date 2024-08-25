create table Taco (
    id number(15) not null,
    name varchar(50) not null,
    taco_order number(15) not null,
    taco_order_key number(15) not null,
    created_at Date not null
);

alter table Taco add (constraint id_constr Primary key(id));

create sequence taco_seq start with 1;

CREATE OR REPLACE TRIGGER taco_trigg
BEFORE INSERT ON Taco
FOR EACH ROW

BEGIN
  SELECT taco_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/


--*****************************

create table if not exists Taco_Order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(2) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
);




create table if not exists Ingredient_Ref (
    ingredient varchar(4) not null,
    taco bigint not null,
    taco_key bigint not null
);

create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);

alter table Taco
 add foreign key (taco_order) references Taco_Order(id);
alter table Ingredient_Ref
 add foreign key (ingredient) references Ingredient(id);