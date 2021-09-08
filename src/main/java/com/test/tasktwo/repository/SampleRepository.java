package com.test.tasktwo.repository;

import com.test.tasktwo.entity.Sample;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends CrudRepository<Sample, Integer> {
}
