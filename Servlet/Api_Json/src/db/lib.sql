DROP TABLE SEOUL_LIB;

CREATE TABLE SEOUL_LIB(
	GU_CODE NUMBER,					--위치 구분     GU_CODE
	LIB_SEQ NUMBER PRIMARY KEY,		--도서관 번호  LBRRY_SEQ_NO
	LIB_NAME VARCHAR2(4000),		--도서관명      LBRRY_NAME
	ADDR VARCHAR2(4000), 			--주소	  ADRES
	TEL VARCHAR2(4000),				--전화번호      TEL_NO
	HPG	VARCHAR2(4000)				--홈페이지 URL  HMPG_URL
);

SELECT * FROM SEOUL_LIB;