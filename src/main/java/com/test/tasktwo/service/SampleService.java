package com.test.tasktwo.service;

import com.test.tasktwo.dto.TransformedColorDTO;
import com.test.tasktwo.entity.Sample;
import com.test.tasktwo.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;


    public Optional<Sample> getDetailsById(int id) {
        return sampleRepository.findById(id);
    }

    public List<TransformedColorDTO> getAllSamples() {
        List<Sample> allData = StreamSupport
                .stream(sampleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return buildTreeFromList(allData);
    }

    public List<TransformedColorDTO> buildTreeFromList(List<Sample> inputList) {
        Map<Boolean, List<Sample>> partitionedData = inputList.stream().collect(Collectors.partitioningBy(x -> x.getParentId() == 0));
        List<TransformedColorDTO> result = new ArrayList<>();
        for (Sample data : partitionedData.get(true)) {
            TransformedColorDTO n = new TransformedColorDTO(data.getName(), data.getColor());
            n.parent = data.getParentId();
            result.add(buildChildStructure(data, partitionedData.get(false), n));
        }

        return result;
    }

    private TransformedColorDTO buildChildStructure(Sample data, List<Sample> nonParentData, TransformedColorDTO n) {
        List<Sample> childData = nonParentData.stream().filter(x -> Objects.equals(x.getParentId(), data.getId())).collect(Collectors.toList());
        for (Sample child : childData) {
            TransformedColorDTO newTransformedColorDTO = new TransformedColorDTO(child.getName(), child.getColor());
            newTransformedColorDTO.parent = data.getId();
            TransformedColorDTO immediateParent = getNodeByParentId(data.getParentId(), n);
            if (immediateParent != null) {
                immediateParent.subClasses.add(newTransformedColorDTO);
            }
            buildChildStructure(child, nonParentData, n);
        }
        return n;
    }

    private TransformedColorDTO getNodeByParentId(int id, TransformedColorDTO n) {
        if (n.parent == id) {
            return n;
        }
        for (TransformedColorDTO y : n.subClasses) {
            if (y.parent == id) {
                return y;
            } else {
                return getNodeByParentId(id, y);
            }
        }
        return null;
    }
}

