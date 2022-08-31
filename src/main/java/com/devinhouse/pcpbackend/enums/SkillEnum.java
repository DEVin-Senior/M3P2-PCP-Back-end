package com.devinhouse.pcpbackend.enums;

public enum SkillEnum {

    C_SHARP("C#"),
    DOT_NET(".NET"),
    SQL("SQL"),
    JAVA("JAVA"),
    SPRING("SPRING"),
    PRIMEFACES("PRIMEFACES"),
    HTML("HTML"),
    CSS("CSS"),
    JAVASCRIPT("JAVASCRIPT");

    private final String skillDescription;

    SkillEnum(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillDescription(){
        return this.skillDescription;
    }

}
