package com.apress.prospring5.ch2.common;

/**
 * Created by iuliana.cosmina on 4/2/17.
 * 有天赋的歌手接口，扩展歌手接口，有一个play方法，参数是吉他，演奏吉他
 */
public interface GiftedSinger extends Singer {
    void play(Guitar guitar);
}
