package com.experiments.propencdecapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.experiments.propencdecapi.cfg.CredConfig;
import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor;

@SpringBootApplication
public class PropEncDecApiApplication implements CommandLineRunner {
	
	@Value("${jasypt.encryptor.password}")
	private String encPwd;
	
	@Autowired
	private CredConfig cfg;
	
	@Autowired
	private DefaultLazyEncryptor encryptor;
	
	public static void main(String[] args) {
		SpringApplication.run(PropEncDecApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Encryptor Password : " + encPwd);
		System.out.println("mysqlPassword : " + cfg.getMysqlPassword());
		
		String encryptedValue = encryptor.encrypt(args[0]);
		System.out.println("Encrypting " + args[0] + " >> " + encryptedValue);
		
		System.out.println("Decrypting " + encryptedValue + " >> " + encryptor.decrypt(encryptedValue));
	}

}
