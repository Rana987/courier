package com.example.migros.demo.converter;

import com.example.migros.demo.dto.StoresDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreConverter {


    public List<StoresDto> convertJsonToStore() {
        List<StoresDto> storeList = new ArrayList<>();
        String jsonString;
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("YourJsonFile")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
            jsonString = mapper.writeValueAsString(jsonNode);
            System.out.println(jsonString);
            storeList = Arrays.asList(mapper.readValue(jsonString, StoresDto[].class));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return storeList;
    }
    private StoreConverter() {
        //Should not be instantiated.
    }
}
