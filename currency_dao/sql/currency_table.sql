DROP TABLE IF EXISTS t_sled_currency;
CREATE TABLE t_sled_currency(
	Fcurrency_code VARCHAR(64) NOT NULL DEFAULT "" COMMENT '货币编号',
	Fen_name VARCHAR(64) NOT NULL DEFAULT "" COMMENT '英文名称',
	Fcn_name VARCHAR(64) NOT NULL DEFAULT "" COMMENT '中文名称',
	Fcurrency_symbol VARCHAR(16) NOT NULL DEFAULT "" COMMENT '货币符号',
	Fis_base_currency SMALLINT UNSIGNED NOT NULL COMMENT '是否为基准货币：0，否；1，是',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fcurrency_code)
	) CHARSET=utf8mb4, ENGINE=InnoDb;


DROP TABLE IF EXISTS t_sled_exchange_rate;
CREATE TABLE t_sled_exchange_rate(
	Fbase_currency VARCHAR(64) NOT NULL DEFAULT "" COMMENT '基准货币',
	Ftarget_currency VARCHAR(64) NOT NULL DEFAULT "" COMMENT '兑换目标货币',
	Fexchange_rate_name VARCHAR(64) NOT NULL DEFAULT "" COMMENT '汇率名称',
	Fexchange_rate DOUBLE UNSIGNED NOT NULL DEFAULT 0.0 COMMENT '汇率值',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fbase_currency, Ftarget_currency)
	) CHARSET=utf8mb4, ENGINE=InnoDb;

DROP TABLE IF EXISTS t_sled_exchange_rate_history;
CREATE TABLE t_sled_exchange_rate_history(
	Fhistory_id BIGINT UNSIGNED NOT NULL,
	Fbase_currency VARCHAR(64) NOT NULL DEFAULT "" COMMENT '基准货币',
	Fcontent TEXT COMMENT '序列化后的汇率记录',
	Fcreate_timestamp BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fhistory_id,Fbase_currency)
	) CHARSET=utf8mb4, ENGINE=InnoDb;