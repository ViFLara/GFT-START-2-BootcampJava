package one.digital_innovation.entities;

import lombok.Data;

@Data
public abstract class Content {

    protected static final double XP_DEFAULT = 10.0;

    private String title;
    private String description;

    public abstract double calculateXp();
}
