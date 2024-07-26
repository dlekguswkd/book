-- -------------------------------------------
-- AuthorInsert (등록)
-- -------------------------------------------

--  조건을 만족하는 레코드를 삭제
delete from author
where author_id = 9;

-- 연속적인 일렬번호 현재값을 조회할때
SELECT LAST_INSERT_ID();

-- 연속적인 일렬번호를 변경할때
alter table author auto_increment = 7;


-- -------------------------------------------
-- AuthorDelete (삭제)
-- -------------------------------------------

-- 확인하기
select *
from author;

/*
delete from author
where author_name = '';		// key값이 아닌걸로 지우려고하면 안지워줌 (혹시 내가 잘못할까봐)
*/

-- 삭제하기
delete from author
where author_id = 7;


-- -------------------------------------------
-- AuthorUpdate (수정)
-- -------------------------------------------
update author
set author_name = '황일영', 
	author_desc = '개발강사'
where author_id = 7;


-- -------------------------------------------
-- AuthorSelectOne (하나만 뽑기)
-- -------------------------------------------
select * from author;

-- 전체컬럼을 조회할때 *을 쓰지 않고 컬럼명을 모두 쓴다  
select author_id
		, author_name
		, author_desc
from author
where author_id = 1;


-- -------------------------------------------
-- AuthorSelect (전체 뽑기)
-- -------------------------------------------
select * from author;

insert into author
values (null, '강풀', '온라인 만화가 1세대');

select author_id
		, author_name
        , author_desc
from author;

