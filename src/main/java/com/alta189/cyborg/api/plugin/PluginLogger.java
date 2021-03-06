/*
 * Copyright (C) 2012 CyborgDev <cyborg@alta189.com>
 *
 * This file is part of Cyborg
 *
 * Cyborg is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cyborg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alta189.cyborg.api.plugin;

import com.alta189.cyborg.CyborgLogger;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class PluginLogger extends Logger {
	private final String tag;

	protected PluginLogger(Plugin plugin) {
		super(plugin.getClass().getCanonicalName(), null);
		setLevel(Level.ALL);
		setParent(CyborgLogger.getLogger());
		tag = "[" + plugin.getDescription().getName() + "] ";
	}

	@Override
	public void log(LogRecord logRecord) {
		logRecord.setMessage(tag + logRecord.getMessage());
		super.log(logRecord);
	}
}
