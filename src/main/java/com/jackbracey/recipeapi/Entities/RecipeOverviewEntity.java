package com.jackbracey.recipeapi.Entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

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

    @Column(name = "scraped")
    private Boolean scraped;

    @Column(name = "last_scraped")
    private Timestamp lastScraped;

    @Column(name = "extra_scraping_info")
    private String extraScrapingInfo;

    @Column(name = "source")
    private String source;

    public RecipeOverviewEntity(Integer id,
                                String name,
                                String url,
                                String postFormat,
                                String externalId,
                                String imageUrl,
                                Boolean scraped,
                                Timestamp lastScraped,
                                String extraScrapingInfo,
                                String source) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.postFormat = postFormat;
        this.externalId = externalId;
        this.imageUrl = imageUrl;
        this.scraped = scraped;
        this.lastScraped = lastScraped;
        this.extraScrapingInfo = extraScrapingInfo;
        this.source = source;
    }

    public RecipeOverviewEntity() {
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

    public Timestamp getLastScraped() {
        return lastScraped;
    }

    public void setLastScraped(Timestamp lastScraped) {
        this.lastScraped = lastScraped;
    }

    public String getExtraScrapingInfo() {
        return extraScrapingInfo;
    }

    public void setExtraScrapingInfo(String extraScrapingInfo) {
        this.extraScrapingInfo = extraScrapingInfo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}