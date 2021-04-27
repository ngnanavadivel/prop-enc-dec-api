package com.experiments.propencdecapi.cfg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.experiments.propencdecapi.util.JsonLoader;

@Component
@PropertySource(name = "creds-cfg", value = "file:./appresources/creds/pwd.json", factory = JsonLoader.class)
@ConfigurationProperties
public class CredConfig {
	private String mysqlPassword;

	public String getMysqlPassword() {
		return mysqlPassword;
	}

	public void setMysqlPassword(String mysqlPassword) {
		this.mysqlPassword = mysqlPassword;
	}

	@Override
	public String toString() {
		return String.format("CredConfig [mysqlPassword=%s]", mysqlPassword);
	}

}
