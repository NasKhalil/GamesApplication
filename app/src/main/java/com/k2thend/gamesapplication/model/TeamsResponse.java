
package com.k2thend.gamesapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamsResponse {

    @SerializedName("data")
    @Expose
    private List<DataTeam> dataTeams = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<DataTeam> getDataTeams() {
        return dataTeams;
    }

    public void setDataTeams(List<DataTeam> dataTeams) {
        this.dataTeams = dataTeams;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
