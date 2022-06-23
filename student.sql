
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `stu`
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `name` VARCHAR(20) NOT NULL,
  `sex` VARCHAR(20) NOT NULL,
  `age` VARCHAR(20) NOT NULL,
  `grade` VARCHAR(20) NOT NULL,
  `number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=INNODB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO stu VALUES('����','��','13','1','2');
INSERT INTO stu VALUES('�Ž�','��','11','1','3');
INSERT INTO stu VALUES('���','��','10','1','5');
INSERT INTO stu VALUES('�����','��','62','1','11');
INSERT INTO stu VALUES('��ʢ','��','25','1','12');
INSERT INTO stu VALUES('��è��','��','52','1','13');
INSERT INTO stu VALUES('С��','��','30','1','14');
INSERT INTO stu VALUES('����','��','12','1','15');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` VARCHAR(20) CHARACTER SET utf8 COLLATE gb2312_chinese_ci NOT NULL DEFAULT '0',
  `account` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `start` VARCHAR(20) CHARACTER SET utf8 COLLATE gb2312_chinese_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`account`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('�ܲ�', 'admin', 'admin', '0');
INSERT INTO `user` VALUES ('����', 'root', 'root', '1');
INSERT INTO `user` VALUES ('��Ȩ', 'studeng', 'student', '0');