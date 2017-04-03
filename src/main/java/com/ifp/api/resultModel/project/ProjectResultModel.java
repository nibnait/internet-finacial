package com.ifp.api.resultModel.project;

import java.math.BigInteger;
import java.util.List;

public class ProjectResultModel {
    private BigInteger total;
    private Integer limit;
    private Integer offset;
    private List<ProjectModel> projectList;

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<ProjectModel> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectModel> projectList) {
        this.projectList = projectList;
    }
}
