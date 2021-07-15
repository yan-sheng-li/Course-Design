/*
 Navicat MySQL Data Transfer

 Source Server         : 1761
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : book_management

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 15/07/2021 17:33:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for new_book_in
-- ----------------------------
DROP TABLE IF EXISTS `new_book_in`;
CREATE TABLE `new_book_in`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '顺序码',
  `ISBN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ISBN码',
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书名',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '进价',
  `num` int(10) NULL DEFAULT NULL COMMENT '数量',
  `time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进书时间',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `ISBN`(`ISBN`) USING BTREE,
  INDEX `bookname`(`bookname`) USING BTREE,
  INDEX `num`(`num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
