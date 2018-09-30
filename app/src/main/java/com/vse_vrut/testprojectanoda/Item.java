package com.vse_vrut.testprojectanoda;

import android.net.Uri;

import java.net.URI;
import java.net.URL;

public class Item {

    private String userName;
    private String location;
    private Uri url;
    private String likes;
    private String information;
    private String timeAfterPublication;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Uri getUrl() {
        return url;
    }

    public void setUrl(Uri url) {
        this.url = url;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getTimeAfterPublication() {
        return timeAfterPublication;
    }

    public void setTimeAfterPublication(String timeAfterPublication) {
        this.timeAfterPublication = timeAfterPublication;
    }
}
