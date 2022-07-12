package com.example.togonewsapllication.converters;

import androidx.room.TypeConverter;

import com.example.togonewsapllication.models.Source;
import com.google.gson.Gson;

public class SourceConverter {
    @TypeConverter
    public static Source fromString (String value){
        return new Gson().fromJson(value,Source.class);
    }
    @TypeConverter
    public static String fromSource (Source source){
        Gson gson = new Gson();
        String json = gson.toJson(source);
        return json;
    }
}
