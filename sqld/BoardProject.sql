select board.*, row_number() over(order by seq desc) AS rn from board; -- seq�� ������ �ȵǴϱ� row��� �� ��ȣ�� ��
-- select *, row_number() over(order by seq desc) from board; �̰� ������. *�� �����ε� ���� �ڿ� �� ���� ����������
-- �׷��� board.*�� ����. �Խ��ǰ� ����

select * from (select board.*, row_number() over(order by seq desc) rn from board) where rn between 1 and 10;