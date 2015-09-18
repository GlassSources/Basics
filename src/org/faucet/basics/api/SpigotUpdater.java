/*
 * Copyright 2015 Marvin Schäfer (inventivetalent). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */

package org.faucet.basics.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.faucet.basics.DataResources;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SpigotUpdater extends Thread {

	private final Plugin	plugin;
	private final int		id;
	private final boolean	log;

	private boolean			enabled	= true;

	private URL				url;


	public SpigotUpdater(Plugin plugin, int resourceID) throws IOException {
		this(plugin, resourceID, true);
	}

	public SpigotUpdater(Plugin plugin, int resourceID, boolean log) throws IOException {
		if (plugin == null) throw new IllegalArgumentException("Plugin cannot be null");
		if (resourceID == 0) throw new IllegalArgumentException("Resource ID cannot be null (0)");

		this.plugin = plugin;
		this.id = resourceID;
		this.log = log;
		this.url = new URL("http://api.inventivetalent.org/spigot/resource/" + resourceID);


		this.enabled = true;

		super.start();
	}

	@Override
	public synchronized void start() {
		// Override so the Thread doesn't run multiple times
	}

	@Override
	public void run() {
		if (!this.plugin.isEnabled()) return;
		if (!this.enabled) return;
		if (this.log) {
			this.plugin.getLogger().info("[Basics] Searching for updates...");
		}
		HttpURLConnection connection = null;

		try {
			connection = (HttpURLConnection) this.url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String content = "";
			String line = null;
			while ((line = in.readLine()) != null) {
				content += line;
			}
			in.close();

			org.json.simple.JSONObject json = null;
			try {
				json = (org.json.simple.JSONObject) new JSONParser().parse(content);
			} catch (ParseException e) {
			}

			String currentVersion = null;

			if (json != null && json.containsKey("version")) {
				String version = (String) json.get("version");
				if (version != null && !version.isEmpty()) {
					currentVersion = version;
				}
			}
			if (currentVersion == null) {
				if (this.log) {
					this.plugin.getLogger().warning("[Basics] Basics couldn't search for updates successfully.");
				}
				return;
			}

			if (!currentVersion.equals(this.plugin.getDescription().getVersion())) {
				this.plugin.getLogger().info("[Basics] Found a new version: " + currentVersion + "! (Your version is " + this.plugin.getDescription().getVersion() + ")");
				this.plugin.getLogger().info("[Basics] Download it here: http://www.spigotmc.org/resources/" + this.id);
			}
			if(currentVersion.equals(this.plugin.getDescription().getVersion())){
                this.plugin.getLogger().info("[Basics] Basics " + DataResources.VERSION + " is at the latest version!");
            }
		} catch (IOException e) {
			if (this.log) {
				if (connection != null) {
					try {
						int code = connection.getResponseCode();
						this.plugin.getLogger().warning("[Basics] API connection returned response code " + code);
					} catch (IOException e1) {
					}
				}
				e.printStackTrace();
			}
		}
	}
}
