create table js_member(
	js_id varchar2(12char)primary key,
	js_pw varchar2(16 char)not null,
	js_name varchar2(10 char)not null,
	js_email varchar2(30 char)not null,
	js_addr varchar2(30 char)not null,
	js_photo varchar2(100 char)not null
);

select * from js_member;

drop table js_member cascade constraint;
-- ----------------------------------------------

create table js_memo(
	js_no number(5)primary key,
	js_txt varchar2(200 char)not null,
	js_writer varchar2(12char)not null,
	js_date date not null,
	js_file varchar2(100 char)not null
);

create sequence js_memo_seq;

delete from sequence js_memo_seq;

drop sequence js_memo_seq;

select * from js_memo order by js_date;

drop table js_memo cascade constraint;

delete from js_memo;

select rownum from js_memo;

select * from (select rownum as rn,js_no,js_txt,js_writer,js_date,js_file from js_memo order by js_date)where rn &lt;= #{start} and rn &gt;= #{end} order by rn desc

select * from(select rownum as rn,js_no,js_txt,js_date from (select * from js_memo order by js_date))where rn >=5 and rn<=10;

select rownum as rn,js_no,js_writer,js_txt,js_date,js_file from (select * from js_memo order by js_date);

select rownum as rn,js_no,js_txt,js_date,js_file from (select * from js_memo order by js_date);

select * from(select rownum as rn,js_no,js_writer,js_txt,js_date,js_file from (select * from js_memo order by js_date))where rn >=30 and rn <= 35 order by rn desc
-- --------------------------------------
create table js_memo_Reply(
	jmr_no number(5)primary key,
	jmr_js_no number(5)not null,
	jmr_writer varchar2(20 char)not null,
	jmr_txt varchar2(100 char)not null,
	jmr_date date not null,
	constraint memo_to_reply foreign key(jmr_js_no) references js_memo(js_no) on delete cascade
);

create sequence js_memo_Reply_seq;

select * from JS_MEMO_REPLY;

-- 이미 만들어진 테이블에 추가하기
alter table  js_memo_Reply add constraint memo_to_reply foreign key(jmr_js_no) references js_memo(js_no) on delete cascade

drop table js_memoReply cascade constraint;




-- --------------------------------------
create table js_man(
	js_no number(5)primary key,
	js_txt varchar2(200 char)not null,
	js_date date not null,
	js_file varchar2(100 char)not null
);
create sequence js_man_seq;

select * from js_man;

drop table js_man cascade constraint;

select rownum,js_no,js_txt,js_date,js_file from js_man order by js_no desc;

select rownum,js_no,js_txt,js_date,js_file from (select rownum as rn,js_no,js_txt,js_date,js_file from js_man order by js_no desc)where rownum>=1 and rownum<=10;

select rownum,js_no,js_txt,js_date,js_file from (select rownum as rn,js_no,js_txt,js_date,js_file from js_man order by js_no desc)where rn>=20 and rn<=25;

select count(*) from js_man;

select * from js_man where js_txt = '울룩불룩';

delete from js_man where js_no = ?;

-- --------------------------------------

create table js_data(
	js_no	number(5)primary key,
	js_uploader varchar2(12 char)not null,
	js_title varchar2(50 char)not null,
	js_cate varchar2(12 char)not null,
	js_file varchar2(100 char)not null,
	js_date date not null
);
drop table js_data cascade constraint;

create sequence js_data_seq;

select * from js_Data;


