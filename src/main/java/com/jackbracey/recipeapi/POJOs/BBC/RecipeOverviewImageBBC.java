package com.jackbracey.recipeapi.POJOs.BBC;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeOverviewImageBBC implements Serializable {

    @JsonProperty("@id")
    public String id;

    @JsonProperty("@type")
    public String type;

    public String alt;

    public String aspectRatio;

    public int height;

    public String title;

    public String url;

    public int width;

    public String sourceUrl;

    public ArrayList<Integer> crop;

    public RecipeOverviewImageBBC(String id, String type, String alt, String aspectRatio, int height, String title,
                                  String url, int width, String sourceUrl, ArrayList<Integer> crop) {
        this.id = id;
        this.type = type;
        this.alt = alt;
        this.aspectRatio = aspectRatio;
        this.height = height;
        this.title = title;
        this.url = url;
        this.width = width;
        this.sourceUrl = sourceUrl;
        this.crop = crop;
    }

    public RecipeOverviewImageBBC() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public ArrayList<Integer> getCrop() {
        return crop;
    }

    public void setCrop(ArrayList<Integer> crop) {
        this.crop = crop;
    }
}
