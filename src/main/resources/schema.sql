-- -----------------------------------------------------
-- Table "USERS"
-- -----------------------------------------------------
CREATE TABLE  USERS (
  "user_id" SERIAL NOT NULL,
  "username" VARCHAR(45) NOT NULL,
  "password" VARCHAR(100) NOT NULL,
  PRIMARY KEY ("user_id"));

-- -----------------------------------------------------
-- Table "CATEGORIES"
-- -----------------------------------------------------
CREATE TABLE  CATEGORIES (
  "category_id" SERIAL NOT NULL,
  "description" VARCHAR(45) NOT NULL,
  "state" BOOLEAN NOT NULL,
  PRIMARY KEY ("category_id"));


-- -----------------------------------------------------
-- Table "PRODUCTS"
-- -----------------------------------------------------
CREATE TABLE  PRODUCTS (
  "product_id" SERIAL NOT NULL,
  "name" VARCHAR(45) NULL,
  "category_id" INT NOT NULL,
  "barcode" VARCHAR(150) NULL,
  "price" DECIMAL(16,2) NULL,
  "stock_quantity" INT NOT NULL,
  "state" BOOLEAN NULL,
  PRIMARY KEY ("product_id"),
  CONSTRAINT "fk_PRODUCTS_CATEGORIES"
    FOREIGN KEY ("category_id")
    REFERENCES CATEGORIES ("category_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "CLIENTS"
-- -----------------------------------------------------
CREATE TABLE  CLIENTS (
  "id" VARCHAR(20) NOT NULL,
  "name" VARCHAR(40) NULL,
  "surnames" VARCHAR(100) NULL,
  "cellphone" NUMERIC NULL,
  "address" VARCHAR(80) NULL,
  "email" VARCHAR(70) NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "PURCHASES"
-- -----------------------------------------------------
CREATE TABLE  PURCHASES (
  "purchase_id" SERIAL NOT NULL,
  "client_id" VARCHAR(20) NOT NULL,
  "date" TIMESTAMP NULL,
  "payment_method" CHAR(1) NULL,
  "comment" VARCHAR(300) NULL,
  "state" CHAR(1) NULL,
  PRIMARY KEY ("purchase_id"),
  CONSTRAINT "fk_PURCHASES_CLIENTS1"
    FOREIGN KEY ("client_id")
    REFERENCES CLIENTS ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "PURCHASES_PRODUCTS"
-- -----------------------------------------------------
CREATE TABLE  PURCHASES_PRODUCTS (
  "purchase_id" INT NOT NULL,
  "product_id" INT NOT NULL,
  "quantity" INT NULL,
  "total" DECIMAL(16,2) NULL,
  "state" BOOLEAN NULL,
  PRIMARY KEY ("purchase_id", "product_id"),
  CONSTRAINT "fk_PURCHASES_PRODUCTS_PRODUCTS1"
    FOREIGN KEY ("product_id")
    REFERENCES PRODUCTS ("product_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_PURCHASES_PRODUCTS_PURCHASES1"
    FOREIGN KEY ("purchase_id")
    REFERENCES PURCHASES ("purchase_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
