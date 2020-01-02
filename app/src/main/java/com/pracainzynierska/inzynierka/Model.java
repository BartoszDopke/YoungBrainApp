package com.pracainzynierska.inzynierka;

import java.util.Date;

public class Model {

    private Date date;
    private int fapScore;
    private int mcScore;
    private int gScore;
    private int fttScore;

    public Model(Date date, int fapScore, int mcScore, int gScore, int fttScore) {
        this.date = date;
        this.fapScore = fapScore;
        this.mcScore = mcScore;
        this.gScore = gScore;
        this.fttScore = fttScore;
    }

    public Date getDate() {
        return date;
    }

    public int getFapScore() {
        return fapScore;
    }

    public int getMcScore() {
        return mcScore;
    }

    public int getgScore() {
        return gScore;
    }

    public int getFttScore() {
        return fttScore;
    }
}
