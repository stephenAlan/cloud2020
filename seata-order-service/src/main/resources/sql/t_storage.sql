/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : seata_storage

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-01-17 20:50:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_storage
-- ----------------------------
DROP TABLE IF EXISTS `t_storage`;
CREATE TABLE `t_storage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `total` int(11) DEFAULT NULL COMMENT '总数量',
  `used` int(11) DEFAULT NULL COMMENT '已使用数量',
  `residue` int(11) DEFAULT NULL COMMENT '剩余数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_storage
-- ----------------------------
INSERT INTO `t_storage` VALUES ('1', '1', '100', '0', '100');
