/*
 * Copyright (C) 2017 - Protium - Ussoltsev Dmitry, Jankurazov Ruslan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package net.protium.modules.pauth.backend.database

import groovy.json.JsonException
import groovy.sql.Sql
import net.protium.api.agents.Config
import net.protium.api.exceptions.ArgumentException
import net.protium.api.exceptions.ConfigException
import net.protium.modules.pauth.backend.utils.C

/**
 * From: protium
 * Pkg: net.protium.core.database
 * At: 11.04.17
 */
class SqlWrapper {


	private Sql sql
	private Config conf
	private def dbc

	SqlWrapper() throws JsonException {
		try {
			conf = new Config(C.DB_CONF, "database")
		} catch (Exception e) {
			throw e
		}
		connect()
	}

	SqlWrapper(String dbcName) throws JsonException {
		try {
			conf = new Config(C.DB_CONF, "database")
		}
		catch (Exception e) {
			throw e
		}
		connect(dbcName)
	}

	void connect() {
		String dbcName = conf.get("profile") ?: "default"
		dbc = conf.get(Config.toPath(["profiles", dbcName] as String[]))
		if (dbc == null)
			throw new ConfigException()
		//noinspection GroovyAssignabilityCheck
		sql = Sql.newInstance(dbc.get("uri"), dbc.get("user"), dbc.get("password"), dbc.get("driver"))
	}

	void connect(String dbcName) {
		dbc = conf.get(Config.toPath(["available", dbcName] as String[]))
		if (dbc == null)
			throw new ArgumentException()
		//noinspection GroovyAssignabilityCheck
		sql = Sql.newInstance(dbc.get("uri"), dbc.get("user"), dbc.get("password"), dbc.get("driver"))
	}

	void reconnect() {
		if (dbc == null)
			throw new RuntimeException()
		//noinspection GroovyAssignabilityCheck
		sql = Sql.newInstance(dbc.get("uri"), dbc.get("user"), dbc.get("password"), dbc.get("driver"))
	}

	Sql getConnector() { sql }
}
