select board.*, row_number() over(order by seq desc) AS rn from board; -- seq로 뽑으면 안되니까 row라는 새 번호를 줌
-- select *, row_number() over(order by seq desc) from board; 이건 에러남. *은 모든것인데 모든것 뒤에 또 뭐가 붙을수없음
-- 그래서 board.*을 해줌. 게시판과 모든것

select * from (select board.*, row_number() over(order by seq desc) rn from board) where rn between 1 and 10;