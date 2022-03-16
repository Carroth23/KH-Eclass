select * from member;

update member set pw = '4321', name = 'joee', phone = '123454423' where id = 'joetheblack';

update member set pw = ?, name = ?, phone = ?, email = ?, zipcode = ?, address1 = ?, address2 = ? where id = ?;

create table board(
    seq number primary key,
    writer varchar2(20) not null,
    title varchar(300) not null,
    contents varchar2(4000) not null,
    write_date date default sysdate not null,
    view_count number default 0 not null
);
create sequence cafe_menu_seq start with 1004 increment by 1 nomaxvalue nocache;
create sequence board_seq start with 1 increment by 1 nomaxvalue nocache;