-- -------------------------------------------
-- BookInsert (등록)
-- -------------------------------------------
-- 
select * from book;

--  조건을 만족하는 레코드를 삭제
delete from book
where book_id = 9;

-- 연속적인 일렬번호 현재값을 조회할때
SELECT LAST_INSERT_ID();

-- 연속적인 일렬번호를 변경할때
alter table book auto_increment = 9;

insert into book
values (null, '신곡', '동서문화사', '2016-06-09', '7');


-- -------------------------------------------
-- BookDelete (삭제)
-- -------------------------------------------
select * from book;

delete from book
where book_id = 7;


-- -------------------------------------------
-- BookUpdate (수정)
-- -------------------------------------------
update book
set title = '미움받을용기' 
	, pubs = '인플루엔셜'
    , pub_date = '2014-11-17'
    , author_id = 7
where book_id = 9;


-- -------------------------------------------
-- BookSelect (책 전체리스트)
-- -------------------------------------------
select * from book;

select 	book_id
		, title 
		, pubs 
		, pub_date 
		, author_id 
from book;


-- -------------------------------------------
-- BookSelectOne (책 1권정보(책정보+작가정보))
-- -------------------------------------------
select 	b.book_id
		, b.title 
		, b.pubs 
		, b.pub_date 
		, b.author_id 
        , a.author_name
        , a.author_desc
from book b
left join author a
on b.author_id = a.author_id
where b.book_id = 2;

-- -------------------------------------------
-- BookSelectALL (책 전체리스트(책정보+작가정보))
-- -------------------------------------------

select 	b.book_id
		, b.title 
		, b.pubs 
		, b.pub_date 
		, b.author_id 
        , a.author_name
        , a.author_desc
from book b
left join author a
on b.author_id = a.author_id;


-- ---------------------------------------------