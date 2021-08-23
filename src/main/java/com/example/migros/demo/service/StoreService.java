package com.example.migros.demo.service;

import com.example.migros.demo.dto.StoresDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StoreService {

    public List<StoresDto> getAllStores() {
        List<StoresDto> storeList = new ArrayList<>();
        String jsonString;
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("stores.json")) {
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
}
