package com.masum_billah.musical;

public class Music {
    private String mTitle;
    private String mArtist;
    private String mAlbum;
    private String mGenre;
    private String mDuration;
    private int mSongImageResourceId;

    public Music(String title, String artist, String album, String genre,
                 String duration, int songImageResourceId) {
        this.mTitle = title;
        this.mArtist = artist;
        this.mAlbum = album;
        this.mGenre = genre;
        this.mDuration = duration;
        this.mSongImageResourceId = songImageResourceId;
    }

    public String getTitle(){
        return mTitle;
    }
    public String getArtist(){
        return mArtist;
    }
    public int getSongImageResourceId(){
        return mSongImageResourceId;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String getGenre() {return mGenre;}

    public String getDuration() {
        return mDuration;
    }
}
