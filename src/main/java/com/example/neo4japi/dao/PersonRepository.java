package com.example.neo4japi.dao;

import com.example.neo4japi.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: 邓明维
 * @date: 2022/12/9
 * @description:
 */
@Repository
public interface PersonRepository extends Neo4jRepository<Person,Long> {
}
