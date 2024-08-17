SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`orders` (
  `ORDER_NO` INT(11) NOT NULL AUTO_INCREMENT ,
  `CUSTOMER` VARCHAR(45) NULL DEFAULT NULL ,
  `TOTAL_PRICE` INT(11) NULL DEFAULT NULL ,
  `TIMESTAMP` TIMESTAMP NULL ,
  PRIMARY KEY (`ORDER_NO`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`products`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`products` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NULL DEFAULT NULL ,
  `GENRE` VARCHAR(45) NULL DEFAULT NULL ,
  `PRICE` VARCHAR(45) NULL DEFAULT NULL ,
  `STOCK` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`order_items`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`order_items` (
  `ORDER_ID` INT(11) NOT NULL ,
  `PRODUCT_ID` INT(11) NOT NULL ,
  PRIMARY KEY (`ORDER_ID`, `PRODUCT_ID`) ,
  INDEX `order_no_idx` (`ORDER_ID` ASC) ,
  INDEX `ID_idx` (`PRODUCT_ID` ASC) ,
  CONSTRAINT `order_no`
    FOREIGN KEY (`ORDER_ID` )
    REFERENCES `mydb`.`orders` (`ORDER_NO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ID`
    FOREIGN KEY (`PRODUCT_ID` )

    REFERENCES `mydb`.`products` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user` (
  `EMAIL` VARCHAR(45) NOT NULL ,
  `FIRST_NAME` VARCHAR(40) NULL DEFAULT NULL ,
  `LAST_NAME` VARCHAR(45) NULL DEFAULT NULL ,
  `CONTACT_NUMBER` VARCHAR(45) NULL DEFAULT NULL ,
  `PASSWORD` VARCHAR(45) NULL DEFAULT NULL ,
  `SECRET_QUESTION` VARCHAR(100) NULL DEFAULT NULL ,
  `SECRET_ANSWER` VARCHAR(100) NULL DEFAULT NULL ,
  `ROLE` VARCHAR(45) NULL ,
  PRIMARY KEY (`EMAIL`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`staff`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`staff` (
  `Email` VARCHAR(45) NOT NULL ,
  `NAME` VARCHAR(45) NULL ,
  `CONTACT` MEDIUMTEXT NULL ,
  PRIMARY KEY (`Email`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`QUESTIONS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`QUESTIONS` (
  `QUESTION_ID` INT NOT NULL ,
  `QUESTION` VARCHAR(200) NULL ,
  PRIMARY KEY (`QUESTION_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FEEDBACKS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`FEEDBACKS` (
  `FEEDBACK_ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_EMAIL` VARCHAR(45) NULL ,
  `Q1_ANS` INT NULL ,
  `Q2_ANS` INT NULL ,
  `Q3_ANS` INT NULL ,
  PRIMARY KEY (`FEEDBACK_ID`) ,
  INDEX `USER_ID_idx` (`USER_EMAIL` ASC) ,
  CONSTRAINT `USER_ID`
    FOREIGN KEY (`USER_EMAIL` )
    REFERENCES `mydb`.`user` (`EMAIL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
