/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100308
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 100308
 File Encoding         : 65001

 Date: 23/08/2018 20:30:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `stu_number` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `gender` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `password` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `stu_mobile` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `par_name` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `par_mobile` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `create_time` date NOT NULL,
  `is_delete` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (2, '1', '1', 1, 1, '', '', '', '', '2018-08-10', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
