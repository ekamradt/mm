package com.example.movemedical;

import com.example.movemedical.model.UsCity;
import com.example.movemedical.model.UsCounty;
import com.example.movemedical.model.UsState;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovemedicalApplicationTests {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Insure we can convert a loaded UsState to Json and back
    @Test
    void testNonRecursingUsState() {
        final UsState usState = buildUsState();
        try {
            String usStateJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(usState);
            final UsState usStateResult = mapper.readValue(usStateJson, UsState.class);
            assertEquals(usState.toString(), usStateResult.toString(), "UsState beans do not match.");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private UsState buildUsState() {
        final UsCity city01 = new UsCity(null, "CityName1");
        final UsCity city02 = new UsCity(null, "CityName2");

        final UsCounty usCounty01 = new UsCounty(null, "CountyName01",
                new ArrayList<UsCity>() {{
                    add(city01);
                    add(city02);
                }});
        city01.setUsCounty(usCounty01);
        city02.setUsCounty(usCounty01);

        final UsState usState = new UsState("UT", "Utah", Collections.singletonList(usCounty01))
                .setStateId(0L);

        usCounty01.setUsState(usState);
        return usState;
    }
}
