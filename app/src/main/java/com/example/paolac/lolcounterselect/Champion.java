package com.example.paolac.lolcounterselect;

import org.json.JSONException;
import org.json.JSONObject;

public class Champion {
    private String mName;
    private String mPortrait;

    public Champion(JSONObject json) throws JSONException {
        mName = json.optString("name");
        mPortrait = json.optString("portrait").toLowerCase();
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getPortrait() {
        return mPortrait;
    }

    public void setPortrait(String mPortrait) {
        this.mPortrait = mPortrait;
    }
}
