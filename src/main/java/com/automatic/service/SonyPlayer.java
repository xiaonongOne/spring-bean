package com.automatic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SonyPlayer implements Player {
	
	private Tape tape;
	
	@Autowired
	public SonyPlayer (Tape tape) {
		this.tape = tape;
	}

	public void play() {
		System.out.println("----start----");
		tape.play();
		System.out.println("----end----");
	}

}
