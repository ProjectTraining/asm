/*
Navicat MySQL Data Transfer

Source Server         : zyf
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : asm

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2016-04-23 13:01:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_asset`
-- ----------------------------
DROP TABLE IF EXISTS `t_asset`;
CREATE TABLE `t_asset` (
  `assetId` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `assetCode` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `assetName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `parentId` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `parentName` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'pid 资产类别id\r\npcode 资产类别编码\r\npname资产类别名称\r\nspid 上级资产类型id\r\nspname 上级资产类型名',
  PRIMARY KEY (`assetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_asset
-- ----------------------------

-- ----------------------------
-- Table structure for `t_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `deptId` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `deptName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`deptId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `t_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `t_parameter`;
CREATE TABLE `t_parameter` (
  `parameterId` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `parameterName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `parameterValue` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `groupId` int(11) NOT NULL,
  `groupName` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'pid 参数信息id\r\npname 参数名称\r\npvalue 参数值\r\nspid 所属参数类型id\r\nspname 所属参数类型名',
  PRIMARY KEY (`parameterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `roleId` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deptId` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `state` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', null, null, 'admin', '8ffe76f6ea2f704cc35e275adc1674d4', '1', '1');
INSERT INTO `t_user` VALUES ('bbcd6c93543d61e101543d8a8a240001', null, null, 'zhangyufeng', '8ffe76f6ea2f704cc35e275adc1674d4', '0', '0');
INSERT INTO `t_user` VALUES ('bbcd6c93543d61e101543d9c75ff0002', null, null, 'zhangyufeng1', '8ffe76f6ea2f704cc35e275adc1674d4', '1', '1');
INSERT INTO `t_user` VALUES ('bbcd6c93543d61e101543da137030003', null, null, 'zhangyufeng2', '8ffe76f6ea2f704cc35e275adc1674d4', '1', '1');
INSERT INTO `t_user` VALUES ('bbcd6c93543d61e101543da55e450004', null, null, 'zhangyufeng3', '8ffe76f6ea2f704cc35e275adc1674d4', '1', '1');
INSERT INTO `t_user` VALUES ('bbcd6c93543dceb301543dddae400001', null, null, 'bbbbbbbb', 'zyf123456', '1', '1');
INSERT INTO `t_user` VALUES ('bbcd6c93544132a70154417cc3fe0002', null, null, 'hgfhwfg', 'zyf123456', '1', '1');
