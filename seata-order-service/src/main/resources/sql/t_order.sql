/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : seata_order

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-01-17 20:50:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `money` decimal(10,0) DEFAULT NULL COMMENT '金额',
  `status` tinyint(1) DEFAULT '0' COMMENT '0-创建中，1-已完成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------
