package com.test.tasktwo.controller;

import com.test.tasktwo.dto.TransformedColorDTO;
import com.test.tasktwo.entity.Sample;
import com.test.tasktwo.exception.ColorNotFoundException;
import com.test.tasktwo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/fetch/{id}")
    public Sample getDetailsById(@PathVariable int id) {
        return sampleService.getDetailsById(id).orElseThrow(() -> new ColorNotFoundException("Color Not Found"));
    }

    @GetMapping("/fetchAll")
    public List<TransformedColorDTO> getAllSamples() {
        return sampleService.getAllSamples();
    }
}
