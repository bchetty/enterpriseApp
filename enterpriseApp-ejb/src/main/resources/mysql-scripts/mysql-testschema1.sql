-- MySQL Script generated by MySQL Workbench
-- 08/06/14 11:10:31
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema testschema1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `testschema1` DEFAULT CHARACTER SET utf8mb4 ;
USE `testschema1` ;

-- -----------------------------------------------------
-- Table `testschema1`.`continent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testschema1`.`continent` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `testschema1`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testschema1`.`country` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(250) NOT NULL,
  `CONTINENT_ID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_CONTINENT_idx` (`CONTINENT_ID` ASC),
  CONSTRAINT `FK_CONTINENT`
    FOREIGN KEY (`CONTINENT_ID`)
    REFERENCES `testschema1`.`continent` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `testschema1`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testschema1`.`person` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `LAST_NAME` VARCHAR(250) NOT NULL,
  `FIRST_NAME` VARCHAR(250) NOT NULL,
  `COUNTRY_ID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_COUNTRY_idx` (`COUNTRY_ID` ASC),
  CONSTRAINT `FK_COUNTRY`
    FOREIGN KEY (`COUNTRY_ID`)
    REFERENCES `testschema1`.`country` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
