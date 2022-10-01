package com.cxxj.model;

public class ExamRoom {
    private Long examRoomId;

    private String name;

    private String stuNum;

    private Integer roomNum;

    private String examNum;

    private String remarks;

    public Long getExamRoomId() {
        return examRoomId;
    }

    public void setExamRoomId(Long examRoomId) {
        this.examRoomId = examRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getExamNum() {
        return examNum;
    }

    public void setExamNum(String examNum) {
        this.examNum = examNum == null ? null : examNum.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}