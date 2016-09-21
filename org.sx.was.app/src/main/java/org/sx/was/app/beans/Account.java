package org.sx.was.app.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String value = "to jest text2";
	
	public Account() {
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("--------------------------------postConstruct" + this);
	}
	
	@PreDestroy
	public void preDestroy(){
		System.out.println("--------------------------------preDestroy" + this);
	}
}
