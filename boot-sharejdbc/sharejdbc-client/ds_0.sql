/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3308
 Source Schema         : ds_0

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 10/09/2022 21:02:30
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
INSERT INTO `t_user0` VALUES (1011320215742844930, 'test7', 2, '2022-08-22 17:05:29');
INSERT INTO `t_user0` VALUES (1011320216019668994, 'test8', 2, '2022-08-22 17:05:29');
INSERT INTO `t_user0` VALUES (1011320220637597698, 'test17', 2, '2022-08-22 17:05:30');
INSERT INTO `t_user0` VALUES (1011320225750454274, 'test30', 2, '2022-08-22 17:05:31');
INSERT INTO `t_user0` VALUES (1011320228573220866, 'test38', 2, '2022-08-22 17:05:32');
INSERT INTO `t_user0` VALUES (1011320230179639298, 'test42', 2, '2022-08-22 17:05:32');
INSERT INTO `t_user0` VALUES (1011320233182760962, 'test49', 2, '2022-08-22 17:05:33');

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
INSERT INTO `t_user1` VALUES (1011320215428272130, 'test6', 1, '2022-08-22 17:05:29');
INSERT INTO `t_user1` VALUES (1011320218548834306, 'test12', 1, '2022-08-22 17:05:30');
INSERT INTO `t_user1` VALUES (1011320219006013442, 'test13', 1, '2022-08-22 17:05:30');
INSERT INTO `t_user1` VALUES (1011320219970703362, 'test15', 1, '2022-08-22 17:05:30');
INSERT INTO `t_user1` VALUES (1011320220985724930, 'test18', 1, '2022-08-22 17:05:30');
INSERT INTO `t_user1` VALUES (1011320221300297730, 'test19', 1, '2022-08-22 17:05:30');
INSERT INTO `t_user1` VALUES (1011320221824585730, 'test20', 1, '2022-08-22 17:05:30');
INSERT INTO `t_user1` VALUES (1011320222671835138, 'test22', 1, '2022-08-22 17:05:31');
INSERT INTO `t_user1` VALUES (1011320222940270594, 'test23', 1, '2022-08-22 17:05:31');
INSERT INTO `t_user1` VALUES (1011320223338729474, 'test24', 1, '2022-08-22 17:05:31');
INSERT INTO `t_user1` VALUES (1011320225050005506, 'test28', 1, '2022-08-22 17:05:31');
INSERT INTO `t_user1` VALUES (1011320228292202498, 'test37', 1, '2022-08-22 17:05:32');
INSERT INTO `t_user1` VALUES (1011320230812979202, 'test44', 1, '2022-08-22 17:05:32');
INSERT INTO `t_user1` VALUES (1011320231442124802, 'test45', 1, '2022-08-22 17:05:33');
INSERT INTO `t_user1` VALUES (1011320232184516610, 'test47', 1, '2022-08-22 17:05:33');
INSERT INTO `t_user1` VALUES (1011320232562003970, 'test48', 1, '2022-08-22 17:05:33');

SET FOREIGN_KEY_CHECKS = 1;
