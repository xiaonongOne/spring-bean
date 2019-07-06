package com.automatic.service;

import org.springframework.stereotype.Component;
import javax.inject.Named;

/**
 * 组件扫描 默认不启用
 * @author XiaoNong
 *
 */
//@Component
@Named("pandaplayer")
public class PandaPlayer implements Tape {

	private String singer = "周杰伦";
	
	private String songName = "双截棍";
	
	public void play() {
		System.out.println("开始播放："+singer+"的"+songName);
	}

}
