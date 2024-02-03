package com.jackbracey.recipeapi.Entities;

import jakarta.persistence.*;

@Entity(name = "recipe_overview")
public class RecipeOverviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String url;

    @Column(name = "post_format")
    private String postFormat;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "image_url")
    private String imageUrl;

    private Boolean scraped;

    private Boolean ignore;

    public RecipeOverviewEntity(Integer id, String name, String url, String postFormat, String externalId,
                                String imageUrl, Boolean scraped, Boolean ignore) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.postFormat = postFormat;
        this.externalId = externalId;
        this.imageUrl = imageUrl;
        this.scraped = scraped;
        this.ignore = ignore;
    }

    public RecipeOverviewEntity() {
    }

    public static RecipeOverviewEntity POJOToEntity(String name, String url, String postFormat, String externalId,
                                                    String imageUrl, Boolean scraped) {
        RecipeOverviewEntity entity = new RecipeOverviewEntity();
        entity.setName(name);
        entity.setUrl(url);
        entity.setPostFormat(postFormat);
        entity.setExternalId(externalId);
        entity.setImageUrl(imageUrl);
        entity.setScraped(scraped);
        return entity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPostFormat() {
        return postFormat;
    }

    public void setPostFormat(String postFormat) {
        this.postFormat = postFormat;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getScraped() {
        return scraped;
    }

    public void setScraped(Boolean scraped) {
        this.scraped = scraped;
    }

    public Boolean getIgnore() {
        return ignore;
    }

    public void setIgnore(Boolean ignore) {
        this.ignore = ignore;
    }
}
