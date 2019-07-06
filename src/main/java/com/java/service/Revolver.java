package com.java.service;

public class Revolver implements CompactDisc {

	private String title = "Revolver. Revolver's Lonely Hearts Club Band";
	private String artist = "The Revolver";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}
