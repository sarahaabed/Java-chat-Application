-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User_Table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User_Table` (
  `user_Email` VARCHAR(45) NULL,
  `user_Name` VARCHAR(45) NULL,
  `password` VARCHAR(20) NULL,
  `gender` VARCHAR(20) NULL,
  `status` VARCHAR(10) NULL,
  `first_Name` VARCHAR(45) NULL,
  `last_Name` VARCHAR(45) NULL,
  PRIMARY KEY (`user_Email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`conversation_Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`conversation_Room` (
  `room_Id` INT NULL,
  `conversation_xml` VARBINARY(1000) NULL,
  `seen` TINYINT(1) NULL,
  PRIMARY KEY (`room_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Room_User_Table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Room_User_Table` (
  `room_Id` INT NULL,
  `user_Email` VARCHAR(45) NULL,
  INDEX `fk_Room_User_Table_User_Table1_idx` (`user_Email` ASC),
  PRIMARY KEY (`room_Id`, `user_Email`),
  CONSTRAINT `fk_Room_User_Table_User_Table1`
    FOREIGN KEY (`user_Email`)
    REFERENCES `mydb`.`User_Table` (`user_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Room_User_Table_conversation_Room1`
    FOREIGN KEY (`room_Id`)
    REFERENCES `mydb`.`conversation_Room` (`room_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ads_Table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ads_Table` (
  `user_Email` VARCHAR(45) NULL,
  `ads_Image` VARBINARY(1000) NULL,
  INDEX `fk_Ads_Table_User_Table1_idx` (`user_Email` ASC),
  CONSTRAINT `fk_Ads_Table_User_Table1`
    FOREIGN KEY (`user_Email`)
    REFERENCES `mydb`.`User_Table` (`user_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User_list_Table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User_list_Table` (
  `contact_Email` VARCHAR(45) NULL,
  `user_Email` VARCHAR(45) NULL,
  PRIMARY KEY (`contact_Email`, `user_Email`),
  INDEX `fk_User_list_Table_User_Table_idx` (`user_Email` ASC),
  CONSTRAINT `fk_User_list_Table_User_Table`
    FOREIGN KEY (`user_Email`)
    REFERENCES `mydb`.`User_Table` (`user_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_list_Table_User_Table1`
    FOREIGN KEY (`contact_Email`)
    REFERENCES `mydb`.`User_Table` (`user_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User_Request_Table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User_Request_Table` (
  `request_Id` INT NULL,
  `user_Email` VARCHAR(45) NULL,
  `receiver_Email` VARCHAR(45) NULL,
  PRIMARY KEY (`request_Id`),
  INDEX `fk_User_Request_Table_User_Table1_idx` (`user_Email` ASC),
  INDEX `fk_User_Request_Table_User_Table2_idx` (`receiver_Email` ASC),
  CONSTRAINT `fk_User_Request_Table_User_Table1`
    FOREIGN KEY (`user_Email`)
    REFERENCES `mydb`.`User_Table` (`user_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Request_Table_User_Table2`
    FOREIGN KEY (`receiver_Email`)
    REFERENCES `mydb`.`User_Table` (`user_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
