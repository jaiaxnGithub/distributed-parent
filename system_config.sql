/*
 Navicat MySQL Data Transfer

 Source Server         : jaiaxn
 Source Server Type    : MySQL

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : utf-8

 Date: 04/01/2019 20:26:38 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `system_config`
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `conf_id` varchar(32) NOT NULL COMMENT '属性ID',
  `conf_value` varchar(64) NOT NULL COMMENT '属性值',
  `conf_status` varchar(3) NOT NULL COMMENT '属性状态，00A可用、00X不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
