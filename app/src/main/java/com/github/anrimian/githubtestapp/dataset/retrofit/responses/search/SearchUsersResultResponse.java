package com.github.anrimian.githubtestapp.dataset.retrofit.responses.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 15.6.17. It is awesome java class.
 */

public class SearchUsersResultResponse {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;

    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;

    @SerializedName("items")
    @Expose
    private List<UserSearchInfoResponse> items = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public List<UserSearchInfoResponse> getItems() {
        return items;
    }
}
