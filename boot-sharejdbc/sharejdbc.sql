CREATE TABLE `t_udict`  (
                            `dictid` bigint(20) NOT NULL,
                            `ustatus` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                            `uvalue` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                            PRIMARY KEY (`dictid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;
CREATE TABLE `t_user0` (
                           `id` bigint(20) NOT NULL,
                           `name` varchar(64) DEFAULT NULL COMMENT '名称',
                           `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
                           `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_user1` (
                           `id` bigint(20) NOT NULL,
                           `name` varchar(64) DEFAULT NULL COMMENT '名称',
                           `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
                           `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;