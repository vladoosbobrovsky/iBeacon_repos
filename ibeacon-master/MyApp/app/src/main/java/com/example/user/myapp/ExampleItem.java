package com.example.user.myapp;

public class ExampleItem {
    private String mMedia;
    private String mImageUrl;
    private String mImageUrl1;
    private String mCreator;
    private String mLikes;
    private String mContent;

    public ExampleItem(String imageUrl, String creator, String likes , String content,String imageUrl1,String media) {
        mImageUrl = imageUrl;
        mImageUrl1 = imageUrl1;
        mCreator = creator;
        mLikes = likes;
        mMedia = media;
        mContent = content;
    }

    public String getmContent() {
        return mContent;
    }
    public String getImageUrl() {
        return mImageUrl;
    }
    public String getImageUrl1() {
        return mImageUrl1;
    }

    public String getCreator() {
        return mCreator;
    }

    public String getLikeCount() {
        return mLikes;
    }
    public String getmMedia(){
        return mMedia;
    }
}