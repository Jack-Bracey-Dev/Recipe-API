package com.jackbracey.recipeapi.Helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestHelper {

    public static RestTemplate getBasicRestTemplate(String url) {
        return new RestTemplate();
    }

    public static HttpHeaders getAcceptJsonHeader(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public static String unescapeUrl(String url) {
        return url
                .replaceAll("%5B", "[")
                .replaceAll("%5D", "]");
    }

    public static String addParamToUrl(String url, String name, String value) {
        String result = url;
        if (!url.contains("?"))
            result += "?";
        if (result.charAt(result.length()-1) != '?')
            result += "&";
        return String.format("%s%s=%s", result, name, value);
    }

    public static String addMultipleParamToUrl(String url, String name,
                                               List<?> values) {
        List<String> stringValues = values.stream()
                .map(String::valueOf)
                .toList();
        String result = url;

        for (String val : stringValues)
            result = addParamToUrl(result, name, val);

        return result;
    }

    public static String addMultipleParamsToUrl(String url,
                                                HashMap<String, Object> params) {
        String result = url;

        for (Map.Entry<String, Object> entry : params.entrySet())
            result = addParamToUrl(result, entry.getKey(), entry.getValue().toString());

        return result;
    }

    public static <T> T fromJSON(final TypeReference<T> type,
                                 final String jsonPacket) {
        T data = null;

        try {
            data = new ObjectMapper().readValue(jsonPacket, type);
        } catch (Exception e) {
            // Handle the problem
        }
        return data;
    }

}
