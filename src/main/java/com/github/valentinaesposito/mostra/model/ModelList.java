package com.github.valentinaesposito.mostra.model;

import java.util.List;

/**
 * Created by Peppe on 30/10/2014.
 */
public class ModelList<Child extends Model> extends JsonArray<Child> {

    public ModelList(List<Child> list) {
        super(list);
    }

}
