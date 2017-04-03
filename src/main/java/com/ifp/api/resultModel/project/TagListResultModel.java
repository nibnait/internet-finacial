package com.ifp.api.resultModel.project;

import java.util.List;

public class TagListResultModel {
    private List<String> tags;

    public TagListResultModel(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
