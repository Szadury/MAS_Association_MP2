package com.pjwstk.MAS.beerapp;

import java.time.LocalDateTime;

//Asocjacja z kwalifikatorem Event *-1 Bar
public class Event extends ExtensionObject{
    private String name;
    private Bar bar;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Event(String name, Bar bar, LocalDateTime startTime, LocalDateTime endTime) throws Exception {
        super();
        this.name = name;
        this.bar = bar;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bar.addEvent(this);
    }

    public String getName() {
        return name;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) throws Exception {
        if(this.bar != bar) {
            this.bar.deleteEvent(name);
            this.bar = bar;
            this.bar.addEvent(this);
        }
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
