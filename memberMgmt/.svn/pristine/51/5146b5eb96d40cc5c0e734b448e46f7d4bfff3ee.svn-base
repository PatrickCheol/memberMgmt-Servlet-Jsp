CREATE TABLE MESSAGE (
	MNO      INTEGER      NOT NULL COMMENT '받는사람번호', -- 받는사람 번호
	DELNO    INTEGER	  auto_increment COMMENT '지우기번호', -- 지우기번호
	TITLE    VARCHAR(100) COMMENT '쪽지제목', -- 쪽지제목
	CONTENT  VARCHAR(4000) COMMENT '쪽지내용', -- 쪽지내용
	MNAME    VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	CRE_DATE DATETIME     NOT NULL COMMENT '쪽지보낸날짜', -- 쪽지보낸날짜
	primary key(DELNO)
);
COMMENT '메세지기본';

INSERT INTO message(MNO,TITLE,CONTENT,MNAME,CRE_DATE)
VALUES (1,'s1@test.com','1111','홍길동',NOW());