package com.llh.recyclerviewonclick;

/**
 * 项目名:    RecyclerViewOnClick
 * 包名:      com.llh.recyclerviewonclick
 * 文件名:    Song
 * 创建者:    LLH
 * 创建时间:  2019/8/9 9:55
 * 描述:      TODO
 */
public class Song {
    //头像，歌名，歌手
    private int headerId;
    private String songName;
    private String singer;
    //构造函数
    public Song(int headerId,String songName,String singer){
        this.headerId = headerId;
        this.songName = songName;
        this.singer = singer;
    }

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
