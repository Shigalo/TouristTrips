CREATE SCHEMA `touristTrips` ;

use touristTrips;

CREATE TABLE `touristTrips`.`user_role` (
  user_id INT NOT NULL,
  roles VARCHAR(45) NULL DEFAULT NULL);

CREATE TABLE `touristTrips`.`user` (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  active boolean NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `touristTrips`.`tour` (
  id INT NOT NULL AUTO_INCREMENT,
  target VARCHAR(45) NOT NULL,
  name varchar(45) NOT NULL
  complete boolean DEFAULT false,
  PRIMARY KEY (`id`));
CREATE TABLE `touristTrips`.`flight` (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  outp varchar(45) NOT NULL,
  target varchar(45) NOT NULL,
  departure datetime NOT NULL,
  arrival datetime NOT NULL,
  tickets int DEFAULT 0,
  places int NOT NULL);

CREATE TABLE `touristTrips`.`request` (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  tour_id int NOT NULL,
  user_id int NOT NULL,
  flight_id int NOT NULL,
  cost double NOT NULL,
  CONSTRAINT request_tour FOREIGN KEY (tour_id) REFERENCES tour (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT request_user FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT request_flight FOREIGN KEY (flight_id) REFERENCES flight (id) ON DELETE CASCADE ON UPDATE CASCADE);