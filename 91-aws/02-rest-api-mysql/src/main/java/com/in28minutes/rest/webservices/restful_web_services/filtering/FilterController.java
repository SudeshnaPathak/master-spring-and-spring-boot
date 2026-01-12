package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.ser.FilterProvider;
import tools.jackson.databind.ser.std.SimpleBeanPropertyFilter;
import tools.jackson.databind.ser.std.SimpleFilterProvider;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    //Static filtering : Same Filtering for a bean across different REST APIs
    //Dynamic filtering : Customize Filtering for a bean for a specific REST API

    @GetMapping("/filtering")
    @JsonView(Views.Public.class)
    public String filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        String[] feilds = {"feild1", "feild3"};
        FilterProvider filters = getDynamicFilterProvider(feilds);
        JsonMapper jsonMapper = JsonMapper.builder().build(); //JsonMapper maps Java objects to JSON and vice versa
        return jsonMapper.writer(filters).writeValueAsString(someBean);
    }

    @GetMapping("/filtering-list")
    public String filteringList() {
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
        String[] feilds = {"feild2", "feild3"};
        FilterProvider filters = getDynamicFilterProvider(feilds);
        JsonMapper jsonMapper = JsonMapper.builder().build();
        return jsonMapper.writer(filters).writeValueAsString(someBeans);
    }

    private FilterProvider getDynamicFilterProvider(String[] feilds) {
        //Dynamic Filtering
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(feilds);
        return new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
    }
}
