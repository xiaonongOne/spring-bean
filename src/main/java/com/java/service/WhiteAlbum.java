package com.java.service;

public class WhiteAlbum  implements CompactDisc {

    private String title = "White. Album's Lonely Hearts Club Band";
    private String artist = "The White";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
