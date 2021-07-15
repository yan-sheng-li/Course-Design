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

 Date: 15/07/2021 17:32:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_stack
-- ----------------------------
DROP TABLE IF EXISTS `book_stack`;
CREATE TABLE `book_stack`  (
  `ISBN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ISBN码',
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书名',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `markprice` decimal(10, 2) NULL DEFAULT NULL COMMENT '标价',
  PRIMARY KEY (`ISBN`) USING BTREE,
  INDEX `bookname`(`bookname`) USING BTREE,
  INDEX `num`(`num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
