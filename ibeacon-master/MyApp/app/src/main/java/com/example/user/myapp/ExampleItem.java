package com.example.user.myapp;

public class ExampleItem {
    private String mImageUrl;
    private String mCreator;
    private String mLikes;
    private String mContent;

    public ExampleItem(String imageUrl, String creator, String likes , String content) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
        mContent = content;
    }

    public String getmContent() {
        return mContent;
    }
    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public String getLikeCount() {
        return mLikes;
    }
}