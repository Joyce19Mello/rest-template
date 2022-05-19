package com.api.cats.rest.template.service;

import com.api.cats.rest.template.dto.TheCatDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class TheCatService {

    private final RestTemplate restTemplate;

    @Value("${host.api.thecat}")
    private String hostApiCat;


    public TheCatService() {
        restTemplate = new RestTemplateBuilder(rt -> rt.getInterceptors().add((request, body, execution) -> {
            request.getHeaders()
                    .add("x-api-key", "d40cdc46-df68-4dac-882d-41353c4d4838");
            return execution.execute(request, body);
        })).build();
    }

    public Optional<List<TheCatDTO>> getCats() {
        String url = hostApiCat + "breeds";
        var result = Arrays.asList(Objects.requireNonNull(this.restTemplate.getForObject(url, TheCatDTO[].class)));
        return Optional.of(result);
    }
}
