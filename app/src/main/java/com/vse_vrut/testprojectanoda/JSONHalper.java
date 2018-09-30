package com.vse_vrut.testprojectanoda;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHalper {

    private Item mItem;

    public JSONHalper() { }

    public Item parseJSON(String json){
        JSONObject obj = null;
        mItem = new Item();
        try {
            obj = new JSONObject(json);
            JSONArray m_jArry = obj.getJSONArray("informations");
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                mItem.setUserName(jo_inside.getString("userName"));
                mItem.setLocation(jo_inside.getString("location"));
                mItem.setUrl(Uri.parse(jo_inside.getString("url")));
                mItem.setLikes(jo_inside.getString("likes"));
                mItem.setInformation(jo_inside.getString("information"));
                mItem.setTimeAfterPublication(jo_inside.getString("timeAfterPublication"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mItem;
    }

    public Item getItem() {
        return mItem;
    }

    public void setItem(Item item) {
        mItem = item;
    }
}
