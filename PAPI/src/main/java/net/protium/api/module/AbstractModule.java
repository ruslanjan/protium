/*
 * Copyright (C) 2017 - Protium - Ussoltsev Dmitry, Jankurazov Ruslan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package net.protium.api.module;

import net.protium.api.agents.ModuleManager;
import net.protium.api.http.Request;
import net.protium.api.http.Response;

public abstract class AbstractModule implements IModule {

	static ModuleManager moduleManager = null;

	public static ModuleManager getModuleManager( ) {
		return moduleManager;
	}

	public static void setModuleManager(ModuleManager moduleManager) {
		AbstractModule.moduleManager = moduleManager;
	}

	@Override
	public abstract Response onRequest(Request request);
}
