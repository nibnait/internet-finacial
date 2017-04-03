package com.ifp.db.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "project", schema = "ifp", catalog = "")
public class ProjectEntity {
    private String projectId;
    private String title;   //项目名称
    private String description; //描述
    private Integer applyAmount; //申请金额
    private Integer bought;  //已买金额
    private String tags;  //标签
    private Date beginDate;
    private Date endDate;
    private double interest;    //利息
    private Integer minBought;   //最低买入金额
    private String userId;

    @Id
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Integer applyAmount) {
        this.applyAmount = applyAmount;
    }

    public Integer getBought() {
        return bought;
    }

    public void setBought(Integer bought) {
        this.bought = bought;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public Integer getMinBought() {
        return minBought;
    }

    public void setMinBought(Integer minBought) {
        this.minBought = minBought;
    }
}
