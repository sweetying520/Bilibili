package com.dream.bilibili.model.data;

/**
 * Created by Administrator on 2018/6/13.
 */

public class BannerData {

    private String banner_item_id;
    private String title;
    private String image_url;
    private String link_url;

    public String getBanner_item_id() {
        return banner_item_id;
    }

    public void setBanner_item_id(String banner_item_id) {
        this.banner_item_id = banner_item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }
}
