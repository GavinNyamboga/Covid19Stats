package com.dev.covid19stats.models;

import com.google.gson.annotations.SerializedName;

public class GlobalResources {
    @SerializedName("cases")
    public Integer cases;

    @SerializedName("deaths")
    public Integer deaths;

    @SerializedName("recovered")
    public Integer recovered;

    @SerializedName("active")
    public Integer active;

    @SerializedName("critical")
    public Integer critical;
}
