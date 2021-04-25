DROP TABLE IF EXISTS t_broker;
CREATE TABLE t_broker(
	Fbroker_id INT UNSIGNED NOT NULL,
	Feng_name VARCHAR(64) NOT NULL DEFAULT "",
	Fcn_name VARCHAR(64) NOT NULL DEFAULT "",
	Fnote VARCHAR(2048) NOT NULL DEFAULT "",
	Ftech_platform_env_flag VARCHAR(64) NOT NULL DEFAULT "",
	Ftech_platform_flag VARCHAR(64) NOT NULL DEFAULT "",
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Fbroker_id),
	UNIQUE KEY(Feng_name),
	UNIQUE KEY(Fcn_name)
	) CHARSET=utf8mb4, ENGINE=InnoDb;


DROP TABLE IF EXISTS t_broker_access;
CREATE TABLE t_broker_access(
	Faccess_id INT UNSIGNED NOT NULL,
	Fbroker_id INT UNSIGNED NOT NULL,
	Fplatform SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Faccess_name VARCHAR(64) NOT NULL DEFAULT "",
	Ftrade_address text NOT NULL DEFAULT "",
	Fquota_address text NOT NULL DEFAULT "",
	Faccess_info_map text NOT NULL DEFAULT "",
	Fstatus SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Fworking_status SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Ftech_platform_env SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Faccess_id)
	) CHARSET=utf8mb4, ENGINE=InnoDb;
