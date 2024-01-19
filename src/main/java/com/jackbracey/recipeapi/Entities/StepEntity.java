package com.jackbracey.recipeapi.Entities;

import jakarta.persistence.*;

@Entity(name = "recipe_steps")
public class StepEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private RecipeEntity recipe;

    @Column(name = "step_number")
    private Integer stepNumber;

    @Column(name = "step_text")
    private String text;

    public StepEntity(Integer id, RecipeEntity recipe, Integer stepNumber, String text) {
        this.recipe = recipe;
        this.stepNumber = stepNumber;
        this.text = text;
    }

    public StepEntity(RecipeEntity recipe, Integer stepNumber, String text) {
        this.recipe = recipe;
        this.stepNumber = stepNumber;
        this.text = text;
    }

    public StepEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
