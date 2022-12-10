package com.example.neo4japi.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.io.Serializable;

/**
 * @author: 邓明维
 * @date: 2022/12/9
 * @description:
 */
@Data
@RelationshipEntity(type = "师傅")
public class PersonRelation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Person parent;
    @EndNode
    private Person child;
    @Property
    private String relation;

    public PersonRelation(Person parent, Person child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}
