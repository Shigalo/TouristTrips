CREATE SCHEMA `touristTrips` ;

use touristTrips;

CREATE TABLE `touristTrips`.`user_role` (
  `user_id` INT NOT NULL,
  `roles` VARCHAR(45) NULL DEFAULT NULL);

CREATE TABLE `touristTrips`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  active boolean NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `touristTrips`.`tour` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `target` VARCHAR(45) NOT NULL,
  `name` varchar(45) NOT NULL
  `complete` boolean NOT NULL DEFAULT false,
  PRIMARY KEY (`id`));

CREATE TABLE `touristTrips`.`request` (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tour_id int NOT NULL,
    user_id int NOT NULL,
    cost double NOT NULL,
    CONSTRAINT request_way FOREIGN KEY (way_id) REFERENCES way (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT request_user FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
);