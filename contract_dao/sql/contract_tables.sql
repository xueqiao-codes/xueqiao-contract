
## contract online db##
## 雪橇商品信息 ##
DROP TABLE IF EXISTS t_sled_commodity;
CREATE TABLE t_sled_commodity(
	Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '内部唯一数字id',
	Fexchange_mic VARCHAR(32) NOT NULL COMMENT 'ISO标准的交易所代号',
	Fsled_commodity_type SMALLINT UNSIGNED NOT NULL COMMENT '雪橇商品类型',
	Fsled_commodity_code VARCHAR(32) NOT NULL COMMENT '雪橇商品代号',
	Frelate_commodity_ids VARCHAR(64) NOT NULL DEFAULT "" COMMENT '关联商品',
	Ftrade_currency VARCHAR(8) NOT NULL DEFAULT "" COMMENT '交易币种',
	Fcontract_size DOUBLE UNSIGNED NOT NULL DEFAULT 0.0 COMMENT '合约每手乘数',
	Ftick_size DOUBLE UNSIGNED NOT NULL DEFAULT 0.0 COMMENT '最小变动价位',
	Fdenominator INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '报价分母',
	Fcmb_direct SMALLINT NOT NULL DEFAULT 0 COMMENT '组合方向',
	Fcommodity_state SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品状态',
	Feng_name VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品英文名称',
	Fcn_name VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品简体中文名称',
	Ftc_name VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品繁体中文名称',
	Feng_acronym VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品英文简称',
	Fcn_acronym VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品简体中文简称',
	Ftc_acronym VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品繁体中文简称',
	Fzone_id VARCHAR(64) NOT NULL DEFAULT '' COMMENT '所在时区id',
	Fsled_commodity_config text NOT NULL DEFAULT "" COMMENT '商品配置信息',
	Fis_also_support_sim SMALLINT UNSIGNED NOT NULL COMMENT '是否同时支持模拟盘：0，否；1，是',
	Factive_start_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃开始时间点',
	Factive_end_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃结束时间点',
	Fedit_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品编辑状态',
	Fworking_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品使用状态',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fsled_commodity_id),
	UNIQUE KEY(Fexchange_mic,Fsled_commodity_type,Fsled_commodity_code)
	) CHARSET=utf8mb4, ENGINE=InnoDb;

alter table t_sled_commodity add column Feng_acronym VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品英文简称';
alter table t_sled_commodity add column Fcn_acronym VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品简体中文简称';
alter table t_sled_commodity add column Ftc_acronym VARCHAR(128) NOT NULL DEFAULT "" COMMENT '商品繁体中文简称';

## 雪橇合约信息 ##
DROP TABLE IF EXISTS t_sled_contract;
CREATE TABLE t_sled_contract(
	Fsled_contract_id INT UNSIGNED NOT NULL COMMENT '雪橇合约内部唯一数字id',
	Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '雪橇商品id',
	Fsled_contract_code VARCHAR(64) NOT NULL COMMENT '雪橇合约编码',
	Ftech_platform_env SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '技术平台环境, 实盘/模拟盘合约',
	Frelate_contract_ids VARCHAR(32) NOT NULL DEFAULT "" COMMENT '交易所组合合约的关联合约',
	Fsled_tag VARCHAR(16) NOT NULL DEFAULT "" COMMENT '雪橇合约别名，标识',
	Fcontract_eng_name VARCHAR(128) NOT NULL DEFAULT "" COMMENT '合约英文名称',
	Fcontract_cn_name VARCHAR(128) NOT NULL DEFAULT "" COMMENT '合约简体中文名称',
	Fcontract_tc_name VARCHAR(128) NOT NULL DEFAULT "" COMMENT '合约繁体中文名称',
	Fcontract_exp_date INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '合约到期日',
	Flast_trade_date INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后交易日',
	Ffirst_notice_date INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '首次通知日',
	Fedit_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '合约编辑状态',
	Fworking_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '合约使用状态',
	Factive_start_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃开始时间点',
	Factive_end_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃结束时间点',
	Fcontract_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '合约活跃状态',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fsled_contract_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;


alter table t_sled_commodity modify Feng_name VARCHAR(128) NOT NULL DEFAULT '' COMMENT '商品英文名称';
alter table t_sled_commodity modify Fcn_name VARCHAR(128) NOT NULL DEFAULT '' COMMENT '商品简体中文名称';
alter table t_sled_commodity modify Ftc_name VARCHAR(128) NOT NULL DEFAULT '' COMMENT '商品繁体中文名称';
alter table t_sled_commodity modify Fis_also_support_sim SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否同时支持模拟盘：0，否；1，是';
alter table t_sled_commodity add column Fis_also_support_sim SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否同时支持模拟盘：0，否；1，是';

alter table t_sled_contract modify Fcontract_eng_name VARCHAR(128) NOT NULL DEFAULT '' COMMENT '合约英文名称';
alter table t_sled_contract modify Fcontract_cn_name VARCHAR(128) NOT NULL DEFAULT '' COMMENT '合约简体中文名称';
alter table t_sled_contract modify Fcontract_tc_name VARCHAR(128) NOT NULL DEFAULT '' COMMENT '合约繁体中文名称';

set names utf8;
alter table t_sled_contract add column Fis_subscribe_xq_quote SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否订阅雪橇行情：0，否；1，是';


##根据 broker_entry_id 分表
DROP TABLE IF EXISTS t_commodity_mapping_0;
CREATE TABLE t_commodity_mapping_0(
	Fmapping_id INT UNSIGNED NOT NULL COMMENT '映射id',
	Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '雪橇商品id',
	Ftech_platform SMALLINT UNSIGNED NOT NULL COMMENT '技术平台',
	Fplatform_exchange VARCHAR(32) NOT NULL DEFAULT "" COMMENT '技术平台交易所代号',
	Fplatform_commodity_type VARCHAR(16) NOT NULL DEFAULT "" COMMENT '技术平台商品类型',
	Fplatform_commodity_code VARCHAR(32) NOT NULL DEFAULT "" COMMENT '技术平台商品代号',
	Fmoney_ratio DOUBLE UNSIGNED NOT NULL DEFAULT 1.0 COMMENT '价格转换比率 雪橇/平台',
	Fbroker_id INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '券商id',
	Factive_start_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃开始时间点',
	Factive_end_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃结束时间点',
	Fedit_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '映射编辑状态',
	Fworking_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '映射使用状态',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fmapping_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;

DROP TABLE IF EXISTS t_sled_exchange;
CREATE TABLE t_sled_exchange(
	Fsled_exchange_id INT UNSIGNED NOT NULL COMMENT '雪橇交易所唯一数字id',
	Fexchange_mic VARCHAR(32) NOT NULL COMMENT 'ISO标准的交易所代号，唯一',
	Fcountry VARCHAR(32) NOT NULL DEFAULT "" COMMENT '交易所所在国家',
	Fcountry_code VARCHAR(32) NOT NULL DEFAULT "" COMMENT '国家代号',
	Foperating_mic VARCHAR(32) NOT NULL DEFAULT "" COMMENT '实际发生交易的交易所代号',
	Fexchange_operating_mic_type SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '实际发生交易的交易所归属类型',
	Fname_institution VARCHAR(128) NOT NULL DEFAULT "" COMMENT '交易所英文名称',
	Facronym VARCHAR(32) NOT NULL DEFAULT "" COMMENT '交易所英文简称',
	Fcity VARCHAR(32) NOT NULL DEFAULT "" COMMENT '交易所所在城市',
	Fwebsite VARCHAR(32) NOT NULL DEFAULT "" COMMENT '交易所网站',
	Fcn_name VARCHAR(32) NOT NULL DEFAULT "" COMMENT '交易所中文名称',
	Fcn_acronym VARCHAR(32) NOT NULL DEFAULT "" COMMENT '交易所中文简称',
	Fzone_id VARCHAR(64) NOT NULL DEFAULT '' COMMENT '所在时区id',
	Factive_start_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃开始时间点',
	Factive_end_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃结束时间点',
	Ftime_lag_ms BIGINT NOT NULL DEFAULT 0 COMMENT '雪橇与交易所的延时',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fsled_exchange_id),
	UNIQUE KEY(Fexchange_mic)
	) CHARSET=utf8mb4, ENGINE=InnoDb;

alter table t_sled_exchange add column Ftime_lag_ms BIGINT NOT NULL DEFAULT 0 COMMENT '雪橇与交易所的延时';

## 整体合约版本号控制 ##
DROP TABLE IF EXISTS t_contract_version;
CREATE TABLE t_contract_version(
	Fversion INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Ffile_md5 VARCHAR(256) NOT NULL DEFAULT "",
	Ffile_path VARCHAR(256) NOT NULL DEFAULT "",
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Fversion)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;


## 同步商品映射任务 ##  有疑问，对于行情接口，需要哪些数据。新合约，新商品，新商品映射
DROP TABLE IF EXISTS t_sync_contract_map_task;
CREATE TABLE t_sync_contract_map_task(
	Ftask_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fsync_target_id INT UNSIGNED NOT NULL,
	Fplatform_env SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Ftask_type SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Fstatus SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Ftask_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 商品属性变化记录 ##
DROP TABLE IF EXISTS t_sled_commodity_change;
CREATE TABLE t_sled_commodity_change(
	Fsled_commodity_id INT UNSIGNED NOT NULL,
	Fexchange_mic VARCHAR(8) NOT NULL COMMENT 'ISO标准的交易所代号',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Fsled_commodity_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;

DROP TABLE IF EXISTS t_platform_commodity;
CREATE TABLE t_platform_commodity(
	Ftech_platform_commodity_id INT UNSIGNED NOT NULL COMMENT '平台商品信息id' AUTO_INCREMENT,
	Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '雪橇商品id',
	Ftech_platform SMALLINT UNSIGNED NOT NULL COMMENT '技术平台',
	Fplatform_exchange VARCHAR(32) NOT NULL DEFAULT "" COMMENT '技术平台交易所代号',
	Fplatform_commodity_type VARCHAR(16) NOT NULL DEFAULT "" COMMENT '技术平台商品类型',
	Fplatform_commodity_code VARCHAR(32) NOT NULL DEFAULT "" COMMENT '技术平台商品代号',
	Fcontent text  NOT NULL DEFAULT "" COMMENT '技术平台商品序列化信息',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Ftech_platform_commodity_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 券商与雪橇的商品映射文件信息 ##
DROP TABLE IF EXISTS t_broker_commodity_mapping_file;
CREATE TABLE t_broker_commodity_mapping_file(
	Ffile_info_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fbroker_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fversion INT UNSIGNED NOT NULL DEFAULT 1,
	Ftech_platform SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Ffile_md5 VARCHAR(256) NOT NULL DEFAULT "",
	Ffile_path VARCHAR(256) NOT NULL DEFAULT "",
	Fstatus SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Ffile_info_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 数据库锁库信息表 ##
DROP TABLE IF EXISTS t_db_locking_info;
CREATE TABLE t_db_locking_info(
	Fid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Flocked_by VARCHAR(64) NOT NULL DEFAULT "",
	Flock_area VARCHAR(256) NOT NULL DEFAULT "",
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Fstart_locked_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Fid)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 一般交易时间信息 ##
DROP TABLE IF EXISTS t_sled_commodity_trade_time;
CREATE TABLE t_sled_commodity_trade_time(
	Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '雪橇商品id',
	Fstandard_week_trade_times text NOT NULL DEFAULT "" COMMENT '冬令时一星期交易时间段',
	Fdst_week_trade_times text NOT NULL DEFAULT "" COMMENT '夏令时一星期交易时间段',
	Fzone_id VARCHAR(64) NOT NULL DEFAULT '' COMMENT '所在时区id',
	Fdst_exists SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品是否存在夏令时',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fsled_commodity_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;


## 夏令时切换规则设置记录 ##
DROP TABLE IF EXISTS t_dst_transfer_config;
CREATE TABLE t_dst_transfer_config(
	Fdst_transfer_config_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fexchange_mics VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '交易所编号',
	Fsled_commodity_types VARCHAR(512) NOT NULL DEFAULT '' COMMENT '商品类型编号',
	Fsled_commodity_codes VARCHAR(2048) NOT NULL DEFAULT '' COMMENT '商品类型编号',
	Fsled_commodity_ids text NOT NULL DEFAULT "" COMMENT '雪橇商品id',
	Fstandard2dst_offset_min INT NOT NULL DEFAULT 0 COMMENT '冬令时转换夏令时分钟偏移量',
	Fcustom SMALLINT NOT NULL DEFAULT 0 COMMENT '是否是自定义：0，否；1，是',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fdst_transfer_config_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 特殊交易时间设置记录 ##
DROP TABLE IF EXISTS t_spec_trade_time;
CREATE TABLE t_spec_trade_time(
	Fspec_trade_time_id INT UNSIGNED NOT NULL,
	Fexchange_mic VARCHAR(16) NOT NULL DEFAULT "",
	Fsled_commodity_ids text NOT NULL DEFAULT "" COMMENT '雪橇商品id',
	Fnon_trade_start_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '非交易时间段开始时间点',
	Fnon_trade_end_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '非交易时间段结束时间点',
	Fnext_trade_open_type SMALLINT NOT NULL DEFAULT 0 COMMENT '下次开盘方式',
	Fzone_id VARCHAR(64) NOT NULL DEFAULT "" COMMENT '所在时区id',
	Fsled_commodity_types VARCHAR(512) NOT NULL DEFAULT "" COMMENT '商品类型编号',
	Fsled_commodity_codes VARCHAR(2048) NOT NULL DEFAULT "" COMMENT '商品类型编号',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fspec_trade_time_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;

## 商品特殊交易时间信息 ##
DROP TABLE IF EXISTS t_sled_commodity_spec_trade_time;
CREATE TABLE t_sled_commodity_spec_trade_time(
	Fid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '雪橇商品id',
	Fspec_trade_time_id INT UNSIGNED NOT NULL,
	Fnon_trade_start_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '非交易时间段开始时间点',
	Fnon_trade_end_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '非交易时间段结束时间点',
	Fnext_trade_open_type SMALLINT NOT NULL DEFAULT 0 COMMENT '下次开盘方式',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fid),
	UNIQUE KEY(Fsled_commodity_id, Fspec_trade_time_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 最近10天交易时间信息 ##
DROP TABLE IF EXISTS t_sled_commodity_trade_time_tmp;
CREATE TABLE t_sled_commodity_trade_time_tmp(
	Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '雪橇商品id',
	Ftmp_trade_times blob NOT NULL DEFAULT "" COMMENT '一段时间内的交易时间段',
	Fzone_id VARCHAR(64) NOT NULL DEFAULT "" COMMENT '所在时区id',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fsled_commodity_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;


## 交易所映射 ##
DROP TABLE IF EXISTS t_sled_exchange_mapping;
CREATE TABLE t_sled_exchange_mapping(
	Fmapping_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fexchange_mic VARCHAR(32) NOT NULL DEFAULT '' COMMENT '交易所编号',
	Ftech_platform INT NOT NULL DEFAULT 0 COMMENT '技术平台',
	Fplatform_exchange VARCHAR(32) NOT NULL DEFAULT '' COMMENT '技术平台交易所代号',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fmapping_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 商品类型映射 ##
DROP TABLE IF EXISTS t_sled_commodity_type_mapping;
CREATE TABLE t_sled_commodity_type_mapping(
	Fmapping_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fsled_commodity_type INT NOT NULL DEFAULT 0 COMMENT '雪橇商品类型',
	Ftech_platform INT NOT NULL DEFAULT 0 COMMENT '技术平台',
	Fplatform_commodity_type VARCHAR(32) NOT NULL DEFAULT '' COMMENT '技术平台商品类型代号',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fmapping_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;


## 商品数据来源 ##
DROP TABLE IF EXISTS t_commodity_source;
CREATE TABLE t_commodity_source(
	Fsource_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fexchange_mic text NOT NULL DEFAULT '' COMMENT '交易所编号',
	Ftech_platform SMALLINT NOT NULL DEFAULT 0 COMMENT '技术平台',
	Ftech_platform_env SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '技术平台环境, 实盘/模拟盘',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fsource_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 雪橇管理后台可使用的账号信息 ##
DROP TABLE IF EXISTS t_commodity_source_account;
CREATE TABLE t_commodity_source_account(
	Faccount_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Ftech_platform SMALLINT NOT NULL DEFAULT 0 COMMENT '技术平台',
	Ftech_platform_env SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '技术平台环境, 实盘/模拟盘',
	Faccount_name VARCHAR(32) NOT NULL DEFAULT '' COMMENT '交易所编号',
	Faccount_pwd VARCHAR(32) NOT NULL DEFAULT '' COMMENT '交易所编号',
	Fbroker_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fbroker_access_id INT UNSIGNED NOT NULL DEFAULT 0,
	Faccount_properties text NOT NULL DEFAULT "" COMMENT '账号扩展信息',
	Faccount_state SMALLINT NOT NULL DEFAULT 0 COMMENT '账号接入的状态',
	Finvalid_reason VARCHAR(128) NOT NULL DEFAULT '' COMMENT '账号不可用的原因',
	Fapi_ret_code INT UNSIGNED NOT NULL DEFAULT 0 COMMENT 'api返回的错误码',
	Fip_address VARCHAR(64) NOT NULL DEFAULT '' COMMENT 'ip',
	Fport INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '端口',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Faccount_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb, AUTO_INCREMENT=1;

## 雪橇币种管理信息 ##
DROP TABLE IF EXISTS t_sled_currency;
CREATE TABLE t_sled_currency(
	Fcurrency_code VARCHAR(32) NOT NULL DEFAULT '' COMMENT '代号：CNY,USD,等等',
	Fcn_name VARCHAR(32) NOT NULL DEFAULT '' COMMENT '中文名称',
	Feng_name VARCHAR(32) NOT NULL DEFAULT '' COMMENT '英文名称',
	Fcurrency_type SMALLINT NOT NULL DEFAULT 0 COMMENT '货币类型 1：基础货币，0：普通货币',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fcurrency_code)
	) CHARSET=utf8mb4, ENGINE=InnoDb;

## 雪橇币种汇率管理信息 ##
DROP TABLE IF EXISTS t_sled_exchange_rate;
CREATE TABLE t_sled_exchange_rate(
	Fcurrency_code VARCHAR(32) NOT NULL COMMENT '代号：CNY,USD,等等',
	Frelated_currency_code VARCHAR(32) NOT NULL COMMENT '代号：CNY,USD,等等',
	Frate DOUBLE NOT NULL DEFAULT 0.0 COMMENT '汇率',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Fcurrency_code,Frelated_currency_code)
	) CHARSET=utf8mb4, ENGINE=InnoDb;


## 一般trading session时间信息 ##
DROP TABLE IF EXISTS t_sled_trading_session;
CREATE TABLE t_sled_trading_session(
	Ftrading_session_id BIGINT UNSIGNED NOT NULL,
	Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '雪橇商品id',
	Fzone_id VARCHAR(64) NOT NULL DEFAULT '' COMMENT '所在时区id',
	Ftime_spans text NOT NULL DEFAULT "" COMMENT 'trading session的时间段Id',
	Ftime_system SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '冬夏令时制',
	Ftrading_day SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '交易日',
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Ftrading_session_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;

DROP TABLE IF EXISTS t_sled_trading_session_time_span;
CREATE TABLE t_sled_trading_session_time_span(
	Ftime_span_id BIGINT UNSIGNED NOT NULL,
	Fstart_day SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '时间段开始星期几',
	Fend_day SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '时间段结束星期几',
	Fstart_time VARCHAR(64) NOT NULL DEFAULT '' COMMENT '时间段开始时间，HH:mm:ss',
	Fend_time VARCHAR(64) NOT NULL DEFAULT '' COMMENT '时间段结束时间，HH:mm:ss',
	Ftime_span_state SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '时间段的状态，例如开市状态',
	Ftrading_session_id BIGINT UNSIGNED NOT NULL DEFAULT 0,
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',
	PRIMARY KEY(Ftime_span_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;