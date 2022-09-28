/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3308
 Source Schema         : ds_1

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 10/09/2022 21:02:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_udict
-- ----------------------------
DROP TABLE IF EXISTS `t_udict`;
CREATE TABLE `t_udict`  (
  `dictid` bigint(0) NOT NULL,
  `ustatus` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `uvalue` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`dictid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user0
-- ----------------------------
DROP TABLE IF EXISTS `t_user0`;
CREATE TABLE `t_user0`  (
  `id` bigint(0) NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user0
-- ----------------------------
INSERT INTO `t_user0` VALUES (1011320187783614465, 'test1', 2, '2022-08-22 17:05:22');
INSERT INTO `t_user0` VALUES (1011320214874624001, 'test4', 2, '2022-08-22 17:05:29');
INSERT INTO `t_user0` VALUES (1011320216283910145, 'test9', 2, '2022-08-22 17:05:29');
INSERT INTO `t_user0` VALUES (1011320217244405761, 'test11', 2, '2022-08-22 17:05:29');
INSERT INTO `t_user0` VALUES (1011320220323024897, 'test16', 2, '2022-08-22 17:05:30');
INSERT INTO `t_user0` VALUES (1011320224034983937, 'test25', 2, '2022-08-22 17:05:31');
INSERT INTO `t_user0` VALUES (1011320224517328897, 'test27', 2, '2022-08-22 17:05:31');
INSERT INTO `t_user0` VALUES (1011320225356189697, 'test29', 2, '2022-08-22 17:05:31');
INSERT INTO `t_user0` VALUES (1011320226790641665, 'test33', 2, '2022-08-22 17:05:31');
INSERT INTO `t_user0` VALUES (1011320228061515777, 'test36', 2, '2022-08-22 17:05:32');
INSERT INTO `t_user0` VALUES (1011320228954902529, 'test39', 2, '2022-08-22 17:05:32');
INSERT INTO `t_user0` VALUES (1011320229877649409, 'test41', 2, '2022-08-22 17:05:32');

-- ----------------------------
-- Table structure for t_user1
-- ----------------------------
DROP TABLE IF EXISTS `t_user1`;
CREATE TABLE `t_user1`  (
  `id` bigint(0) NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user1
-- ----------------------------
INSERT INTO `t_user1` VALUES (1011320204795711489, 'test2', 1, '2022-08-22 17:05:26');
INSERT INTO `t_user1` VALUES (1011320214484553729, 'test3', 1, '2022-08-22 17:05:29');
INSERT INTO `t_user1` VALUES (1011320215147253761, 'test5', 1, '2022-08-22 17:05:29');
INSERT INTO `t_user1` VALUES (1011320216590094337, 'test10', 1, '2022-08-22 17:05:29');
INSERT INTO `t_user1` VALUES (1011320219354140673, 'test14', 1, '2022-08-22 17:05:30');
INSERT INTO `t_user1` VALUES (1011320222101409793, 'test21', 1, '2022-08-22 17:05:30');
INSERT INTO `t_user1` VALUES (1011320224211144705, 'test26', 1, '2022-08-22 17:05:31');
INSERT INTO `t_user1` VALUES (1011320225985335297, 'test31', 1, '2022-08-22 17:05:31');
INSERT INTO `t_user1` VALUES (1011320226484457473, 'test32', 1, '2022-08-22 17:05:31');
INSERT INTO `t_user1` VALUES (1011320227289763841, 'test34', 1, '2022-08-22 17:05:32');
INSERT INTO `t_user1` VALUES (1011320227675639809, 'test35', 1, '2022-08-22 17:05:32');
INSERT INTO `t_user1` VALUES (1011320229424664577, 'test40', 1, '2022-08-22 17:05:32');
INSERT INTO `t_user1` VALUES (1011320230506795009, 'test43', 1, '2022-08-22 17:05:32');
INSERT INTO `t_user1` VALUES (1011320231790252033, 'test46', 1, '2022-08-22 17:05:33');

SET FOREIGN_KEY_CHECKS = 1;
