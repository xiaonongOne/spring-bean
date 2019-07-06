package com.java.service;

public class CDPlayer {

	private CompactDisc cd;

	public CDPlayer() {

	}

	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	public void setCd(CompactDisc cd) {
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}
}
