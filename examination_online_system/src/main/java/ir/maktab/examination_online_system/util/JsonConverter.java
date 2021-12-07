package ir.maktab.examination_online_system.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.util.impl.GsonByteArrayToBase64;
import ir.maktab.examination_online_system.util.impl.GsonLocalDateTime;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.List;

public class JsonConverter {

    private final Gson gson;

    public JsonConverter() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT, Modifier.VOLATILE)
                .registerTypeHierarchyAdapter(byte[].class, new GsonByteArrayToBase64())
                .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTime());
        gson = gsonBuilder.create();
    }

    public String convertToJson(List<Questions> questions) {

        JsonArray jarray = gson.toJsonTree(questions).getAsJsonArray();
        System.out.println(jarray);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("questions", jarray);
        return jsonObject.get("questions").toString();

    }

}