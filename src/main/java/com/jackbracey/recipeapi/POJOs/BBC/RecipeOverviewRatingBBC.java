package com.jackbracey.recipeapi.POJOs.BBC;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeOverviewRatingBBC implements Serializable {

    public int ratingValue;

    public int ratingCount;

    public String ratingTypeLabel;

    public boolean hasRatingCount;

    public boolean isHalfStar;

    public RecipeOverviewRatingBBC(int ratingValue, int ratingCount, String ratingTypeLabel, boolean hasRatingCount, boolean isHalfStar) {
        this.ratingValue = ratingValue;
        this.ratingCount = ratingCount;
        this.ratingTypeLabel = ratingTypeLabel;
        this.hasRatingCount = hasRatingCount;
        this.isHalfStar = isHalfStar;
    }

    public RecipeOverviewRatingBBC() {
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getRatingTypeLabel() {
        return ratingTypeLabel;
    }

    public void setRatingTypeLabel(String ratingTypeLabel) {
        this.ratingTypeLabel = ratingTypeLabel;
    }

    public boolean isHasRatingCount() {
        return hasRatingCount;
    }

    public void setHasRatingCount(boolean hasRatingCount) {
        this.hasRatingCount = hasRatingCount;
    }

    public boolean isHalfStar() {
        return isHalfStar;
    }

    public void setHalfStar(boolean halfStar) {
        isHalfStar = halfStar;
    }
}
