
-- auto-generated definition
create table tb_user
(
    id       bigint auto_increment
        primary key,
    password varchar(255) null,
    username varchar(255) null
);


-- auto-generated definition
create table tb_livro
(
    id                 bigint auto_increment
        primary key,
    isbn               varchar(255) null,
    data_de_publicacao datetime(6)  null,
    descricao          varchar(255) null,
    preco              double       null,
    titulo             varchar(255) null
);

-- auto-generated definition
create table order_location
(
    id        bigint auto_increment
        primary key,
    date      date null,
    latitude  int  null,
    longitude int  null
);

-- auto-generated definition
create table assistances
(
    id          bigint auto_increment
        primary key,
    description varchar(300) not null,
    name        varchar(100) not null
);

-- auto-generated definition
create table orders
(
    id                      bigint auto_increment
        primary key,
    operator_id             bigint not null,
    end_order_location_id   bigint null,
    start_order_location_id bigint null,
    constraint FKjnxv2g46divij3gpd039up3ju
        foreign key (end_order_location_id) references order_location (id),
    constraint FKnddmt7fdipl6osgccfdkcpbl7
        foreign key (start_order_location_id) references order_location (id)
);

-- auto-generated definition
create table orders_services
(
    order_id    bigint not null,
    services_id bigint not null,
    constraint FK37g230wkd5jvxbyx2s7koy21g
        foreign key (services_id) references assistances (id),
    constraint FKq863ndc65lt9lgj0jg1h8ravg
        foreign key (order_id) references orders (id)
);







