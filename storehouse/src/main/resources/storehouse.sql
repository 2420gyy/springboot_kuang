/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : localhost:3306
 Source Schema         : storehouse

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 03/12/2021 16:27:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `goods_source` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `goods_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `supply` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `supply_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `put_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_id` int(255) NULL DEFAULT NULL,
  `number` int(255) NULL DEFAULT 0,
  `company` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `state` int(1) NULL DEFAULT 1 COMMENT '0.未激活 1.激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (2, '鹅卵石', '子豪石材', 'upload/2.jpg', '子豪', '17343382222', '2020-11-16 09:53:58', '美观，精致', 1, 1010, 'kg', 1);
INSERT INTO `t_goods` VALUES (3, '大米', '老刘米厂', 'upload/3.jpg', '老刘', '17343383333', '2020-11-15 16:18:49', '东北大米', 1, 1000, 'kg', 1);
INSERT INTO `t_goods` VALUES (4, '花生油', '吕总百货', 'upload/4.jpg', '吕总', '17343384315', '2020-11-11 19:42:48', '非转基因', 1, 1010, 'kg', 1);
INSERT INTO `t_goods` VALUES (5, '盐', '吕总百货', 'upload/5.jpg', '吕总', '17343384315', '2020-11-16 10:45:48', '精品食盐', 1, 200, '包', 1);
INSERT INTO `t_goods` VALUES (6, '海飞丝', '吕总百货', 'upload/6.jpg', '吕总', '17343384315', '2020-11-12 10:12:23', '去屑实力派', 1, 60, '瓶', 1);
INSERT INTO `t_goods` VALUES (7, '飘柔', '吕总百货', 'upload/7.jpg', '吕总', '17343384315', '2020-11-11 11:38:07', '唐僧洗头用飘柔', 1, 66, '瓶', 1);
INSERT INTO `t_goods` VALUES (8, '灯泡', '吕总百货', 'upload/8.jpg', '吕总', '17343384315', '2020-11-11 11:39:05', '亮晶晶', 1, 20, '个', 1);
INSERT INTO `t_goods` VALUES (9, '手电筒', '吕总百货', 'upload/9.jpg', '吕总', '17343384315', '2020-11-16 09:54:33', '探索黑暗', 1, 40, '个', 1);
INSERT INTO `t_goods` VALUES (10, '六个核弹', '吕总百货', 'upload/64dd07c4901e4661863d130f1aafb112_22.jpeg', '吕总', '17343381111', '2020-11-15 16:22:25', '有营养的核弹', 1, 0, '瓶', 0);
INSERT INTO `t_goods` VALUES (11, 'test', 'test', 'img/goods.jpg', 'test', '17388888888', '2020-11-15 16:22:35', 'test', 1, 0, 't', 0);
INSERT INTO `t_goods` VALUES (13, 'test', 'sss', 'img/goods.jpg', 'sss', 'ss', '2020-11-15 16:19:59', 'ss', 1, 0, 'kg', 0);
INSERT INTO `t_goods` VALUES (15, '六个核弹', 'test', 'upload/a494ecb2d03d4b5b83d272292efdd7d9_22.jpeg', 'test', '17388888888', '2020-11-16 10:00:37', 'sss', 1, 0, 'sss', 1);

-- ----------------------------
-- Table structure for t_goods_title
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_title`;
CREATE TABLE `t_goods_title`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `title_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_goods_title
-- ----------------------------
INSERT INTO `t_goods_title` VALUES (1, 'goodsName', '货物名');
INSERT INTO `t_goods_title` VALUES (2, 'goodsSource', '来源');
INSERT INTO `t_goods_title` VALUES (3, 'supply', '供货人');
INSERT INTO `t_goods_title` VALUES (4, 'supplyTel', '供货人电话');
INSERT INTO `t_goods_title` VALUES (5, 'number', '库存数量');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT 'img/nullUserPhoto.jpg',
  `state` int(1) NULL DEFAULT 0 COMMENT '0.未激活 1.激活',
  `role` int(1) NULL DEFAULT 1 COMMENT '0.admin 1.user',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '123456', '17343384315', '湖北省武汉市东湖学院', 'upload/89c6f3011d554da7b259bf643b4bb898_IMG_E0745.JPG', 1, 0);
INSERT INTO `t_user` VALUES (2, 'tony2', '123456', '88888888', '湖北省武汉市武软', 'upload/1a151052f5fe40e58d453343007c0061_u=1194131577,2954769920&fm=26&gp=0.jpg', 1, 0);
INSERT INTO `t_user` VALUES (3, '李四', '123456', '17343381111', '湖北省武汉市东武大', 'img/nullUserPhoto.jpg', 0, 1);
INSERT INTO `t_user` VALUES (5, 'user3', '123456', '17343382222', '湖北省武汉市东湖学院', 'upload/3fa61e21b0c64a27b09eb00a4266fdbb_u=1573233926,1810809582&fm=111&gp=0.jpg', 0, 1);
INSERT INTO `t_user` VALUES (6, 'user4', '123456', '88888888', '湖北省武汉市东湖学院', 'img/nullUserPhoto.jpg', 0, 1);
INSERT INTO `t_user` VALUES (9, 'user10', '123456', '17343382222', '中国', 'img/nullUserPhoto.jpg', NULL, NULL);
INSERT INTO `t_user` VALUES (11, 'ppp', '123456', '17343384444', '中国', 'upload/486244208358461f98567933fc5d6900_u=1573233926,1810809582&fm=111&gp=0.jpg', 1, 1);

-- ----------------------------
-- Table structure for t_user_title
-- ----------------------------
DROP TABLE IF EXISTS `t_user_title`;
CREATE TABLE `t_user_title`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `title_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_title
-- ----------------------------
INSERT INTO `t_user_title` VALUES (1, 'id', 'ID');
INSERT INTO `t_user_title` VALUES (2, 'userName', '用户名');
INSERT INTO `t_user_title` VALUES (4, 'tel', '电话号码');
INSERT INTO `t_user_title` VALUES (5, 'address', '地址');

SET FOREIGN_KEY_CHECKS = 1;
