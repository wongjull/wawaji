package com.gzleidi;

/**
 * Created by wongjull on 2017/11/17.
 */

public class WawaAction {

    private String uri;

    private int id;

    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Student [uri=" + uri + ", id=" + id + "]";
    }
}
