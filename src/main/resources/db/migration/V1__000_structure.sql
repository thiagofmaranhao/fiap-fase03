create table assistances
(
    id          bigint auto_increment
        primary key,
    description varchar(300) not null,
    name        varchar(100) not null
);

create table order_location
(
    id        bigint auto_increment
        primary key,
    date      date not null,
    latitude  int  not null,
    longitude int  not null
);

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

create table orders_assistances
(
    order_id       bigint not null,
    assistances_id bigint not null,
    constraint FK7yrpsl4pjmo5w1qatt4wryiks
        foreign key (assistances_id) references assistances (id),
    constraint FKr4g2lq1smaie715447ff8cqvp
        foreign key (order_id) references orders (id)
);

create table tb_livro
(
    id                 bigint auto_increment
        primary key,
    isbn               varchar(255) null,
    data_de_publicacao datetime(6) null,
    descricao          varchar(255) null,
    preco              double null,
    titulo             varchar(255) null
);

create table tb_user
(
    id       bigint auto_increment
        primary key,
    password varchar(255) null,
    username varchar(255) null
);

