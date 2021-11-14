package com.study.cvstodb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParsingRepository extends CrudRepository<Library, Long> {
}
