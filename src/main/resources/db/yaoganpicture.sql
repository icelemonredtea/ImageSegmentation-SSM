/*
 Navicat Premium Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 15/02/2019 13:32:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yaoganpicture
-- ----------------------------
DROP TABLE IF EXISTS `yaoganpicture`;
CREATE TABLE `yaoganpicture`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime(0) NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uploadpictureFileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uploadpictureContentType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 208 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yaoganpicture
-- ----------------------------
INSERT INTO `yaoganpicture` VALUES (198, '2019-02-14 17:22:32', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/3f285ec19cfa4a3d85fa8bd58db994ca.jpg', '3f285ec19cfa4a3d85fa8bd58db994ca.jpg', 'jpg');
INSERT INTO `yaoganpicture` VALUES (199, '2019-02-14 17:24:28', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/b11da12e36d4444bab2fe22592649682.jpg', 'b11da12e36d4444bab2fe22592649682.jpg', 'jpg');
INSERT INTO `yaoganpicture` VALUES (200, '2019-02-15 12:12:20', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/dc42856a69ed41bdb0becb625c11a5e9.jpeg', 'dc42856a69ed41bdb0becb625c11a5e9.jpeg', 'jpeg');
INSERT INTO `yaoganpicture` VALUES (201, '2019-02-15 13:20:17', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/8d26ee6f56cc4d47b1aed3579890e555.jpeg', '8d26ee6f56cc4d47b1aed3579890e555.jpeg', 'jpeg');
INSERT INTO `yaoganpicture` VALUES (202, '2019-02-15 13:20:37', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/3b57982004254b4eb857ef16849b68af.jpg', '3b57982004254b4eb857ef16849b68af.jpg', 'jpg');
INSERT INTO `yaoganpicture` VALUES (203, '2019-02-15 13:22:40', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/342d95cc60c74e43972162a1a921462b.jpg', '342d95cc60c74e43972162a1a921462b.jpg', 'jpg');
INSERT INTO `yaoganpicture` VALUES (204, '2019-02-15 13:24:14', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/ba496f10a1bf4768a45ef2a440803675.jpg', 'ba496f10a1bf4768a45ef2a440803675.jpg', 'jpg');
INSERT INTO `yaoganpicture` VALUES (205, '2019-02-15 13:25:31', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/abb371e571d44f27a55553cc64888345.jpeg', 'abb371e571d44f27a55553cc64888345.jpeg', 'jpeg');
INSERT INTO `yaoganpicture` VALUES (206, '2019-02-15 13:25:31', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/079f96efe99c48ca83d22295bef13e60.jpeg', '079f96efe99c48ca83d22295bef13e60.jpeg', 'jpeg');
INSERT INTO `yaoganpicture` VALUES (207, '2019-02-15 13:30:31', 'K-means', 'D:\\java\\git-workspace\\ImageSegmentation-SSM\\src\\main\\webapp\\upload\\src/430dfeff874e415495cfd295fafe5114.jpg', '430dfeff874e415495cfd295fafe5114.jpg', 'jpg');

SET FOREIGN_KEY_CHECKS = 1;
