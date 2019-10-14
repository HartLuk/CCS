package com.goclass.pojo;

public class TbTimer {
    private Long id;

    private Integer timerNum;

    private String timerSchedul;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTimerNum() {
        return timerNum;
    }

    public void setTimerNum(Integer timerNum) {
        this.timerNum = timerNum;
    }

    public String getTimerSchedul() {
        return timerSchedul;
    }

    public void setTimerSchedul(String timerSchedul) {
        this.timerSchedul = timerSchedul == null ? null : timerSchedul.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}