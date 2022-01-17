package com.example.spotify.Model;

import java.util.List;

public class AllCategory {
    String categoryTitle;
    List<CategoryItems>categoryItemsList;

    // text view name of singers
    List<CategoryItems>categoryItemsListnmSingers;

    public AllCategory(String categoryTitle, List<CategoryItems>categoryItemsList,List<CategoryItems>categoryItemsListnmSingers) {
        this.categoryTitle = categoryTitle;
        this.categoryItemsList = categoryItemsList;
        this.categoryItemsListnmSingers = categoryItemsListnmSingers;
    }

    public List<CategoryItems> getCategoryItemsList() {
        return categoryItemsList;
    }

    public void setCategoryItemsList(List<CategoryItems> categoryItemsList) {
        this.categoryItemsList = categoryItemsList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<CategoryItems> getCategoryItemsListnmSingers() {
        return categoryItemsListnmSingers;
    }

    public void setCategoryItemsListnmSingers(List<CategoryItems> categoryItemsListnmSingers) {
        this.categoryItemsListnmSingers = categoryItemsListnmSingers;
    }
}
