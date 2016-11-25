-- 회원기본
CREATE TABLE BOARD (
	MNO      INTEGER      NOT NULL COMMENT '회원일련번호', -- 회원일련번호
	MNAME    VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	TEXT     VARCHAR(4000) COMMENT '글 내용',
	CRE_DATE DATETIME     NOT NULL COMMENT '글작성시각' -- 글작성시각

)
COMMENT '게시판';

-- 회원기본
ALTER TABLE BOARD
	ADD CONSTRAINT PK_MEMBERS -- 회원기본 기본키
		PRIMARY KEY (
			MNO -- 회원일련번호
		);

ALTER TABLE BOARD
	MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원일련번호';
	
INSERT INTO BOARD(MNO,MNAME,TEXT,CRE_DATE)
VALUES (1,'홍길동','첫번쨰 글입니다',NOW());



SELECT * FROM BOARD;