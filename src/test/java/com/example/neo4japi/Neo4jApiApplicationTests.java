package com.example.neo4japi;

import com.example.neo4japi.dao.PersonRelationRepository;
import com.example.neo4japi.dao.PersonRepository;
import com.example.neo4japi.domain.Person;
import com.example.neo4japi.domain.PersonRelation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Neo4jApiApplicationTests {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonRelationRepository personRelationRepository;
    @Test
    void testSave() {
        Person person = new Person();
        person.setName("王忠");
        person.setAge(12);
        personRepository.save(person);
    }

    @Test
    public void testQuery(){
        Iterable<Person> all = personRepository.findAll();
        for (Person person : all) {
            System.out.println(person);
        }
    }
    @Test
    public void testQueryByID(){
        Optional<Person> byId = personRepository.findById(0L);
        System.out.println(byId.get());
    }

    @Test
    public void testRelationShip(){
        Person p1= new Person();
        p1.setName("唐僧");
        p1.setAge(82);

        Person p2= new Person();
        p2.setName("孙库空");
        p2.setAge(500);

        Person p3= new Person();
        p3.setName("八戒");
        p3.setAge(50);

        // 维护关系
        PersonRelation r1 = new PersonRelation(p1, p2, "徒弟");
        PersonRelation r2 = new PersonRelation(p1, p3, "徒弟");

        personRelationRepository.save(r1);
        personRelationRepository.save(r2);
    }
    @Test
    public void testQueryShip(){
        Iterable<PersonRelation> all = personRelationRepository.findAll();
        all.forEach(personRelation -> System.out.println(personRelation));
    }

    @Test
    public void testRelationShi2p(){
        Person p1= new Person();
        p1.setName("唐僧");
        p1.setAge(82);

        Person p2= new Person();
        p2.setName("孙库空");
        p2.setAge(500);

        Person p3= new Person();
        p3.setName("八戒");
        p3.setAge(50);

        // 维护关系
        PersonRelation r1 = new PersonRelation(p1, p2, "师父");
        PersonRelation r2 = new PersonRelation(p1, p3, "徒弟");

        personRelationRepository.save(r1);
        personRelationRepository.save(r2);
    }
}
