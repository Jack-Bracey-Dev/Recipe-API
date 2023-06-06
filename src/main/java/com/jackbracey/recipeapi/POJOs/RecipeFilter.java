package com.jackbracey.recipeapi.POJOs;

import com.jackbracey.recipeapi.Helpers.Response;

import java.util.List;

public class RecipeFilter {

    private Long id;

    private List<Long> ids;

    private String name;

    private String source;

    private String url;

    private Integer prepTimeMin;
    private Integer prepTimeMax;

    private Integer cookTimeMin;
    private Integer cookTimeMax;

    private String difficulty;

    private Integer servesMin;
    private Integer servesMax;

    private String description;

    private Integer caloriesMin;
    private Integer caloriesMax;

    private Integer fatMin;
    private Integer fatMax;

    private Integer saturatesMin;
    private Integer saturatesMax;

    private Integer carbsMin;
    private Integer carbsMax;

    private Integer sugarsMin;
    private Integer sugarsMax;

    private Integer fibreMin;
    private Integer fibreMax;

    private Integer proteinMin;
    private Integer proteinMax;

    private Integer saltMin;
    private Integer saltMax;

    private Integer pageNumber;

    private Integer pageSize;

    public Response checkForMisconfiguration() {
        StringBuilder builder = new StringBuilder();

        if (this.pageNumber == null) {
            if (!builder.isEmpty())
                builder.append(" & ");
            builder.append("Missing pageNumber in request body");
        }

        if (this.pageSize == null) {
            if (!builder.isEmpty())
                builder.append(" & ");
            builder.append("Missing pageSize in request body");
        }

        if (this.pageSize != null && this.pageSize > 50) {
            if (!builder.isEmpty())
                builder.append(" & ");
            builder.append("pageSize cannot be more than 50");
        }

        return new Response(null, builder.isEmpty() ? 200 : 400, builder.toString());
    }

    public RecipeFilter() {
    }

    public RecipeFilter(Long id, List<Long> ids, String name, String source, String url, Integer prepTimeMin,
                        Integer prepTimeMax, Integer cookTimeMin, Integer cookTimeMax, String difficulty,
                        Integer servesMin, Integer servesMax, String description, Integer caloriesMin,
                        Integer caloriesMax, Integer fatMin, Integer fatMax, Integer saturatesMin,
                        Integer saturatesMax, Integer carbsMin, Integer carbsMax, Integer sugarsMin, Integer sugarsMax,
                        Integer fibreMin, Integer fibreMax, Integer proteinMin, Integer proteinMax, Integer saltMin,
                        Integer saltMax, Integer pageNumber, Integer pageSize) {
        this.id = id;
        this.ids = ids;
        this.name = name;
        this.source = source;
        this.url = url;
        this.prepTimeMin = prepTimeMin;
        this.prepTimeMax = prepTimeMax;
        this.cookTimeMin = cookTimeMin;
        this.cookTimeMax = cookTimeMax;
        this.difficulty = difficulty;
        this.servesMin = servesMin;
        this.servesMax = servesMax;
        this.description = description;
        this.caloriesMin = caloriesMin;
        this.caloriesMax = caloriesMax;
        this.fatMin = fatMin;
        this.fatMax = fatMax;
        this.saturatesMin = saturatesMin;
        this.saturatesMax = saturatesMax;
        this.carbsMin = carbsMin;
        this.carbsMax = carbsMax;
        this.sugarsMin = sugarsMin;
        this.sugarsMax = sugarsMax;
        this.fibreMin = fibreMin;
        this.fibreMax = fibreMax;
        this.proteinMin = proteinMin;
        this.proteinMax = proteinMax;
        this.saltMin = saltMin;
        this.saltMax = saltMax;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Integer getPaginationMin() {
        return ((this.pageNumber * this.pageSize) - this.pageSize);
    }

    public Integer getPaginationMax() {
        return (this.pageNumber * this.pageSize);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPrepTimeMin() {
        return prepTimeMin;
    }

    public void setPrepTimeMin(Integer prepTimeMin) {
        this.prepTimeMin = prepTimeMin;
    }

    public Integer getPrepTimeMax() {
        return prepTimeMax;
    }

    public void setPrepTimeMax(Integer prepTimeMax) {
        this.prepTimeMax = prepTimeMax;
    }

    public Integer getCookTimeMin() {
        return cookTimeMin;
    }

    public void setCookTimeMin(Integer cookTimeMin) {
        this.cookTimeMin = cookTimeMin;
    }

    public Integer getCookTimeMax() {
        return cookTimeMax;
    }

    public void setCookTimeMax(Integer cookTimeMax) {
        this.cookTimeMax = cookTimeMax;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getServesMin() {
        return servesMin;
    }

    public void setServesMin(Integer servesMin) {
        this.servesMin = servesMin;
    }

    public Integer getServesMax() {
        return servesMax;
    }

    public void setServesMax(Integer servesMax) {
        this.servesMax = servesMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCaloriesMin() {
        return caloriesMin;
    }

    public void setCaloriesMin(Integer caloriesMin) {
        this.caloriesMin = caloriesMin;
    }

    public Integer getCaloriesMax() {
        return caloriesMax;
    }

    public void setCaloriesMax(Integer caloriesMax) {
        this.caloriesMax = caloriesMax;
    }

    public Integer getFatMin() {
        return fatMin;
    }

    public void setFatMin(Integer fatMin) {
        this.fatMin = fatMin;
    }

    public Integer getFatMax() {
        return fatMax;
    }

    public void setFatMax(Integer fatMax) {
        this.fatMax = fatMax;
    }

    public Integer getSaturatesMin() {
        return saturatesMin;
    }

    public void setSaturatesMin(Integer saturatesMin) {
        this.saturatesMin = saturatesMin;
    }

    public Integer getSaturatesMax() {
        return saturatesMax;
    }

    public void setSaturatesMax(Integer saturatesMax) {
        this.saturatesMax = saturatesMax;
    }

    public Integer getCarbsMin() {
        return carbsMin;
    }

    public void setCarbsMin(Integer carbsMin) {
        this.carbsMin = carbsMin;
    }

    public Integer getCarbsMax() {
        return carbsMax;
    }

    public void setCarbsMax(Integer carbsMax) {
        this.carbsMax = carbsMax;
    }

    public Integer getSugarsMin() {
        return sugarsMin;
    }

    public void setSugarsMin(Integer sugarsMin) {
        this.sugarsMin = sugarsMin;
    }

    public Integer getSugarsMax() {
        return sugarsMax;
    }

    public void setSugarsMax(Integer sugarsMax) {
        this.sugarsMax = sugarsMax;
    }

    public Integer getFibreMin() {
        return fibreMin;
    }

    public void setFibreMin(Integer fibreMin) {
        this.fibreMin = fibreMin;
    }

    public Integer getFibreMax() {
        return fibreMax;
    }

    public void setFibreMax(Integer fibreMax) {
        this.fibreMax = fibreMax;
    }

    public Integer getProteinMin() {
        return proteinMin;
    }

    public void setProteinMin(Integer proteinMin) {
        this.proteinMin = proteinMin;
    }

    public Integer getProteinMax() {
        return proteinMax;
    }

    public void setProteinMax(Integer proteinMax) {
        this.proteinMax = proteinMax;
    }

    public Integer getSaltMin() {
        return saltMin;
    }

    public void setSaltMin(Integer saltMin) {
        this.saltMin = saltMin;
    }

    public Integer getSaltMax() {
        return saltMax;
    }

    public void setSaltMax(Integer saltMax) {
        this.saltMax = saltMax;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
