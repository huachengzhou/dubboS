/*
Navicat MySQL Data Transfer

Source Server         : mysql_blake
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : dubbos

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2018-04-25 15:43:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dubbo_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `dubbo_privilege`;
CREATE TABLE `dubbo_privilege` (
  `pid` varchar(100) NOT NULL,
  `privilege_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dubbo_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `dubbo_role`
-- ----------------------------
DROP TABLE IF EXISTS `dubbo_role`;
CREATE TABLE `dubbo_role` (
  `rid` varchar(100) CHARACTER SET latin1 NOT NULL,
  `role_name` varchar(255) DEFAULT NULL COMMENT '瑙掕壊鎻忚堪 example:teacher',
  `description` varchar(255) DEFAULT NULL COMMENT '瑙掕壊鎻忚堪 example:鏁欏笀',
  `available` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dubbo_role
-- ----------------------------
INSERT INTO `dubbo_role` VALUES ('8a1d172a-4bd9-4daa-a9c3-3583a6e6a6bc', 'xuesheng', '瀛︾敓', '0');
INSERT INTO `dubbo_role` VALUES ('9ec81eb2-6cb2-4746-b843-84e6f1792349', 'laoshi', '鑰佸笀', '0');

-- ----------------------------
-- Table structure for `dubbo_user`
-- ----------------------------
DROP TABLE IF EXISTS `dubbo_user`;
CREATE TABLE `dubbo_user` (
  `uid` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `username` varchar(100) DEFAULT NULL COMMENT '用户登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `organizationid` varchar(100) DEFAULT NULL COMMENT '公司',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐',
  `lock_User` tinyint(4) DEFAULT NULL COMMENT '是否锁定',
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dubbo_user
-- ----------------------------

-- ----------------------------
-- Table structure for `privilege_role`
-- ----------------------------
DROP TABLE IF EXISTS `privilege_role`;
CREATE TABLE `privilege_role` (
  `rid` varchar(100) DEFAULT NULL COMMENT '鍏宠仈 dubbo_role table',
  `pid` varchar(100) DEFAULT NULL COMMENT '鍏宠仈 dubbo_privilege table',
  `id` int(25) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of privilege_role
-- ----------------------------
INSERT INTO `privilege_role` VALUES ('9b4b14cf-fe0a-4690-bd8c-b2c0f0725f07', 'e56e0ac9-12f7-4389-8abe-bb19d56e8991', '1');
INSERT INTO `privilege_role` VALUES ('8a1d172a-4bd9-4daa-a9c3-3583a6e6a6bc', '71954adb-f0ba-4297-adf1-84283716fd61', '26');
INSERT INTO `privilege_role` VALUES ('8a1d172a-4bd9-4daa-a9c3-3583a6e6a6bc', '7cb8db24-207f-46b2-82af-0a47134cf5f5', '27');
INSERT INTO `privilege_role` VALUES ('8a1d172a-4bd9-4daa-a9c3-3583a6e6a6bc', '9065bbc3-e94d-4d57-9ff1-f9201d57de8e', '28');
INSERT INTO `privilege_role` VALUES ('8a1d172a-4bd9-4daa-a9c3-3583a6e6a6bc', 'bdfe9a5e-57be-461b-bac8-8d698b7e9d25', '29');
INSERT INTO `privilege_role` VALUES ('9ec81eb2-6cb2-4746-b843-84e6f1792349', '71954adb-f0ba-4297-adf1-84283716fd61', '30');
INSERT INTO `privilege_role` VALUES ('9ec81eb2-6cb2-4746-b843-84e6f1792349', '7cb8db24-207f-46b2-82af-0a47134cf5f5', '31');
INSERT INTO `privilege_role` VALUES ('9ec81eb2-6cb2-4746-b843-84e6f1792349', '9065bbc3-e94d-4d57-9ff1-f9201d57de8e', '32');
INSERT INTO `privilege_role` VALUES ('9ec81eb2-6cb2-4746-b843-84e6f1792349', 'bdfe9a5e-57be-461b-bac8-8d698b7e9d25', '33');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '涓婚敭',
  `rid` varchar(100) DEFAULT NULL COMMENT '鍏宠仈 dubbo_role table',
  `uid` varchar(100) DEFAULT NULL COMMENT '鍏宠仈 dubbo_user table',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '9ec81eb2-6cb2-4746-b843-84e6f1792349', 'a674ca2e-1c47-4bc3-8c19-d3b98ac2b842');
INSERT INTO `user_role` VALUES ('2', '9ec81eb2-6cb2-4746-b843-84e6f1792349', '5bed0c71-146d-42f3-80e6-30d0d9cf3450');
INSERT INTO `user_role` VALUES ('3', '8a1d172a-4bd9-4daa-a9c3-3583a6e6a6bc', '5bed0c71-146d-42f3-80e6-30d0d9cf3450');
