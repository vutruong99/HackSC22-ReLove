package com.example.relove;

public class StoreItem {
    String imageURL;
    String busiName;
    String count;

    public StoreItem(String imageURL, String busiName, String count) {
        this.imageURL = imageURL;
        this.busiName = busiName;
        this.count = count;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
