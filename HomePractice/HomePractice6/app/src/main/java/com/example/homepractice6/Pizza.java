package com.example.homepractice6;

public class Pizza {
    private String name;
    private String ingredints;
    private String instructions;

    public Pizza(String name, String ingredints, String instructions) {
        this.name = name;
        this.ingredints = ingredints;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", ingredints='" + ingredints + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredints() {
        return ingredints;
    }

    public void setIngredints(String ingredints) {
        this.ingredints = ingredints;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
