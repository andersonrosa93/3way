package com.web.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "hello")
public class HelloWorldMb {
	
	private String message;

	@PostConstruct
	public void init() {
		System.out.println(" M�todo init() executado na inicializa��o devido a anota��o @PostConstruct");
	}
	
	public String getMessage() {
		return "Hello World JSF! v5 2";
	}

	public void setMessage(String message) {
		System.out.println(message);
		this.message = message;
	}
	
}
