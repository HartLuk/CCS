/*
 Navicat Premium Data Transfer

 Source Server         : Public
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : goclass

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 14/10/2019 14:09:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, 'ROLE_USER');
INSERT INTO `tb_role` VALUES (2, 'ROLE_ADMIN');
INSERT INTO `tb_role` VALUES (3, 'ROLE_DBA');

-- ----------------------------
-- Table structure for tb_timer
-- ----------------------------
DROP TABLE IF EXISTS `tb_timer`;
CREATE TABLE `tb_timer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `timer_num` int(11) NULL DEFAULT NULL COMMENT '一天的上课数量，即多少节课',
  `timer_schedul` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间安排表',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间表名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_timer
-- ----------------------------
INSERT INTO `tb_timer` VALUES (1, 1, '[{\"end\":\"9：00\",\"start\":\"9：40\"}]', '上课时间表');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accounts` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '校园帐号',
  `role_id` int(11) NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户状态，0正常，1停用',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐加密，加密字段',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'user', '9A376F158E339B47DCAEB1257C64F3EC', '123', 1, '0', '1752489258923602');
INSERT INTO `tb_user` VALUES (2, 'admin', '9A376F158E339B47DCAEB1257C64F3EC', '20160310235', 2, '0', '1752489258923602');
INSERT INTO `tb_user` VALUES (3, 'dba', '9A376F158E339B47DCAEB1257C64F3EC', '456', 3, '0', '1752489258923602');

SET FOREIGN_KEY_CHECKS = 1;
