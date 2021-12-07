create table files(
    seq number primary key,
    oriname varchar2(255) not null,
    sysname varchar2(255) not null,
    parentSeq number not null
);
create table files(
    seq number,
    oriname varchar2(255),
    sysname varchar2(255),
    parentSeq number
);
drop table files;
commit;
create sequence files_seq start with 1 increment by 1 nocache nomaxvalue;
select * from files;
commit;
delete from files where seq in(3,4,5);
commit;
desc files;
SELECT * FROM (SELECT board.*, row_number() over(order by seq desc) AS rn FROM board) WHERE rn between 1 and 10 and title like '%ÆÄÀÏ%';

