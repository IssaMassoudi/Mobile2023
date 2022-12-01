package com.example.stage;

public class offreStage
{

    private String title,name,description;

    public offreStage(String title ,String name, String description)
    {
        this.title=title;
        this.name=name;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

//********************************************************************

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "offreStage{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
