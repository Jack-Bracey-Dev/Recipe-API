package com.jackbracey.recipeapi.POJOs.BBC;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jackbracey.recipeapi.Entities.RecipeOverviewEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeOverviewBBC implements Serializable {

    public int headingStyledSize;

    /* Values: recipe */
    public String postType;

    public String title;

    public boolean showTitleIcon;

    public boolean showOverlayIcon;

    public Object contentType;

    public Object theme;

    public String id;

    /* Values: null */
    public Object label;

    /* Values: null */
    public Object kicker;

    /* Values: standard | video */
    public String postFormat;

    public RecipeOverviewRatingBBC rating;

    public String url;

    public boolean isPremium;

    /* Values: null | default */
    public String subscriptionExperience;

    public RecipeOverviewImageBBC image;

    public Object description;

    public ArrayList<Object> terms;

    public RecipeOverviewMetaBBC postMeta;

    public String sponsor;

    public RecipeOverviewBBC(int headingStyledSize, String postType, String title, boolean showTitleIcon,
                             boolean showOverlayIcon, Object contentType, Object theme, String id, Object label,
                             Object kicker, String postFormat, RecipeOverviewRatingBBC rating, String url,
                             boolean isPremium, String subscriptionExperience, RecipeOverviewImageBBC image,
                             Object description, ArrayList<Object> terms, RecipeOverviewMetaBBC postMeta, String sponsor) {
        this.headingStyledSize = headingStyledSize;
        this.postType = postType;
        this.title = title;
        this.showTitleIcon = showTitleIcon;
        this.showOverlayIcon = showOverlayIcon;
        this.contentType = contentType;
        this.theme = theme;
        this.id = id;
        this.label = label;
        this.kicker = kicker;
        this.postFormat = postFormat;
        this.rating = rating;
        this.url = url;
        this.isPremium = isPremium;
        this.subscriptionExperience = subscriptionExperience;
        this.image = image;
        this.description = description;
        this.terms = terms;
        this.postMeta = postMeta;
        this.sponsor = sponsor;
    }

    public RecipeOverviewBBC() {
    }

    public static List<RecipeOverviewEntity> convertToEntities(List<RecipeOverviewBBC> recipes) {
        return recipes.stream().map(recipe -> RecipeOverviewEntity.POJOToEntity(recipe.title, recipe.url,
                recipe.postFormat, recipe.id, recipe.image != null ? recipe.image.url : null, false))
                .collect(Collectors.toList());
    }

    public RecipeOverviewEntity convertToEntity() {
        return RecipeOverviewEntity.POJOToEntity(title, url,
                postFormat, id, image != null ? image.url : null, false);
    }

    public int getHeadingStyledSize() {
        return headingStyledSize;
    }

    public void setHeadingStyledSize(int headingStyledSize) {
        this.headingStyledSize = headingStyledSize;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShowTitleIcon() {
        return showTitleIcon;
    }

    public void setShowTitleIcon(boolean showTitleIcon) {
        this.showTitleIcon = showTitleIcon;
    }

    public boolean isShowOverlayIcon() {
        return showOverlayIcon;
    }

    public void setShowOverlayIcon(boolean showOverlayIcon) {
        this.showOverlayIcon = showOverlayIcon;
    }

    public Object getContentType() {
        return contentType;
    }

    public void setContentType(Object contentType) {
        this.contentType = contentType;
    }

    public Object getTheme() {
        return theme;
    }

    public void setTheme(Object theme) {
        this.theme = theme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public Object getKicker() {
        return kicker;
    }

    public void setKicker(Object kicker) {
        this.kicker = kicker;
    }

    public String getPostFormat() {
        return postFormat;
    }

    public void setPostFormat(String postFormat) {
        this.postFormat = postFormat;
    }

    public RecipeOverviewRatingBBC getRating() {
        return rating;
    }

    public void setRating(RecipeOverviewRatingBBC rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public String getSubscriptionExperience() {
        return subscriptionExperience;
    }

    public void setSubscriptionExperience(String subscriptionExperience) {
        this.subscriptionExperience = subscriptionExperience;
    }

    public RecipeOverviewImageBBC getImage() {
        return image;
    }

    public void setImage(RecipeOverviewImageBBC image) {
        this.image = image;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public ArrayList<Object> getTerms() {
        return terms;
    }

    public void setTerms(ArrayList<Object> terms) {
        this.terms = terms;
    }

    public RecipeOverviewMetaBBC getPostMeta() {
        return postMeta;
    }

    public void setPostMeta(RecipeOverviewMetaBBC postMeta) {
        this.postMeta = postMeta;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
}
