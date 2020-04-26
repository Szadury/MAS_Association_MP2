package com.pjwstk.MAS.beerapp;

import java.time.LocalDate;

public class Event {
    private String name;
    private Bar bar;
    private LocalDate startTime;
    private LocalDate endTime;

    public Event(String name, Bar bar, LocalDate startTime, LocalDate endTime) {
        this.name = name;
        this.bar = bar;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", bar=" + bar +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
