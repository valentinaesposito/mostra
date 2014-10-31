package com.github.valentinaesposito.mostra.model;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Peppe on 30/10/2014.
 */
public abstract class JsonArray<InnerType> {

    private List<InnerType> innerList;

    public JsonArray(List<InnerType> list) {
        this.innerList = list;
    }

    public boolean add(InnerType element) {
        return this.innerList.add(element);
    }

    public InnerType get(int index) {
        return this.innerList.get(index);
    }

    public int size() {
        return this.innerList.size();
    }

    public boolean isEmpty() {
        return this.isEmpty();
    }

    public String toJson() {
        Gson gson = new Gson();

        return gson.toJson(this.innerList);
    }

}
