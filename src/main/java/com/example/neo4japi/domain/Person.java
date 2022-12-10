package com.example.neo4japi.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @author: 邓明维
 * @date: 2022/12/9
 * @description:
 */
@Data
// Node关联的标签
@NodeEntity("Person")
public class Person {
    @Id
    // 主键自增
    @GeneratedValue
    private Long id;
    @Property("name")
    private String name;
    @Property("age")
    private Integer age;
}
