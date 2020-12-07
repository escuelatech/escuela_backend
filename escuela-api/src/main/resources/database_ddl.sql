CREATE SCHEMA `escuela`;

CREATE TABLE `user_registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `contact_form` (
  `id` int(11) NOT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  `phoneNumber` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `skills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `skill_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `skill_fid_idx` (`skill_id`),
  KEY `user_fid_idx` (`user_id`),
  CONSTRAINT `skill_fid` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_fid` FOREIGN KEY (`user_id`) REFERENCES `user_registration` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `user_profile` (
  `user_id` int(11) NOT NULL,
  `user_file` blob,
  `user_profile_pic` blob,
  `linkedIn_link` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `video_details` (
  `video_id` int(11) NOT NULL,
  `link` varchar(200) DEFAULT NULL,
  `watch` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`video_id`)
);

