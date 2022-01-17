package com.example.spotify.Model;



public class CategoryItems {
    // Image Urls

    Integer itemId;
    Integer imageUrl;
    String singersName;

    public CategoryItems(Integer itemId, Integer imageUrl) {
        this.itemId = itemId;
        this.imageUrl = imageUrl;
    }
    public CategoryItems(String singersName)
    {
        this.singersName = singersName;
    }
    public CategoryItems(){}

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }


    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSingersName() {
        return singersName;
    }

    public void setSingersName(String singersName) {
        this.singersName = singersName;
    }
}
