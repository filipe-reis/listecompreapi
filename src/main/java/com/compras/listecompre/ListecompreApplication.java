package com.compras.listecompre;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListecompreApplication {
	
    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));   // It will set UTC timezone
        System.out.println("TimeZone: " + new Date());
    }

	public static void main(String[] args) {
		SpringApplication.run(ListecompreApplication.class, args);
	}
}
