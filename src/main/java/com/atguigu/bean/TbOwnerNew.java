package com.atguigu.bean;

public class TbOwnerNew {
    private Integer newId;

    private String newName;

    private Integer newGrade;

    private String newCreatetime;

    private String newMotifytime;

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName == null ? null : newName.trim();
    }

    public Integer getNewGrade() {
        return newGrade;
    }

    public void setNewGrade(Integer newGrade) {
        this.newGrade = newGrade;
    }

    public String getNewCreatetime() {
        return newCreatetime;
    }

    public void setNewCreatetime(String newCreatetime) {
        this.newCreatetime = newCreatetime == null ? null : newCreatetime.trim();
    }

    public String getNewMotifytime() {
        return newMotifytime;
    }

    public void setNewMotifytime(String newMotifytime) {
        this.newMotifytime = newMotifytime == null ? null : newMotifytime.trim();
    }
}