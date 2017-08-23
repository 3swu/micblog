CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user_password` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user_nickname` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user_status` int(11) NOT NULL DEFAULT '1',
  `user_regtime` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_userid` int(11) NOT NULL DEFAULT '0',
  `item_time` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `item_str` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `item_star` int(11) DEFAULT '0',
  `item_staridstr` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `follow` (
  `follow_id` int(11) NOT NULL AUTO_INCREMENT,
  `follow_userid` int(11) NOT NULL DEFAULT '0',
  `follow_followuserid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`follow_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin