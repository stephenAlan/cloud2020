/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : seata_account

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-01-17 20:51:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL COMMENT '总额度',
  `used` decimal(10,0) DEFAULT NULL COMMENT '已用额度',
  `residue` decimal(10,0) DEFAULT NULL COMMENT '剩余额度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES ('1', '1001', '1000', '0', '1000');
