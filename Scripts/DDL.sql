-- coffee_management
DROP SCHEMA IF EXISTS coffee_management;

-- coffee_management
CREATE SCHEMA coffee_management;

-- 제품
CREATE TABLE coffee_management.product (
	code CHAR(4)     NOT NULL COMMENT '제품코드', -- 제품코드
	name VARCHAR(20) NOT NULL COMMENT '제품명' -- 제품명
)
COMMENT '제품';

-- 제품
ALTER TABLE coffee_management.product
	ADD CONSTRAINT
		PRIMARY KEY (
			code -- 제품코드
		);

-- 판매
CREATE TABLE coffee_management.sale (
	no         INT(11) NOT NULL COMMENT '번호', -- 번호
	code       CHAR(4) NULL     COMMENT '제품코드', -- 제품코드
	price      INT(11) NOT NULL COMMENT '제품단가', -- 제품단가
	saleCnt    INT(11) NOT NULL COMMENT '판매수량', -- 판매수량
	marginRate INT(11) NOT NULL COMMENT '마진율' -- 마진율
)
COMMENT '판매';

-- 판매
ALTER TABLE coffee_management.sale
	ADD CONSTRAINT
		PRIMARY KEY (
			no -- 번호
		);

ALTER TABLE coffee_management.sale
	MODIFY COLUMN no INT(11) NOT NULL AUTO_INCREMENT COMMENT '번호';

ALTER TABLE coffee_management.sale
	AUTO_INCREMENT = 1;

-- 판매
ALTER TABLE coffee_management.sale
	ADD CONSTRAINT FK_product_TO_sale -- FK_product_TO_sale
		FOREIGN KEY (
			code -- 제품코드
		)
		REFERENCES ncs_product.product ( -- 제품
			code -- 제품코드
		)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,
	ADD INDEX FK_product_TO_sale (
		code -- 제품코드
	);