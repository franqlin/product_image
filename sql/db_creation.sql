USE productimage;

DROP TABLE IF EXISTS image;
DROP TABLE IF EXISTS product;

CREATE TABLE product (
	id int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	parent_product_id int(10) UNSIGNED,
	name varchar(200) NOT NULL,
	description varchar(200),
	PRIMARY KEY (id),
	UNIQUE (name),
	FOREIGN KEY (parent_product_id) REFERENCES product(id)
);

CREATE TABLE image (
	id int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	product_id int(10) UNSIGNED NOT NULL,
	type varchar(20) NOT NULL,
	location varchar(200) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (product_id) REFERENCES product(id)
);