
package com.k2thend.gamesapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("data")
    @Expose
    private List<DataGames> data = null;

    public List<DataGames> getData() {
        return data;
    }

    public void setData(List<DataGames> data) {
        this.data = data;
    }

}
