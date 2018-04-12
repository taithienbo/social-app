package com.tbo.sn.repository;

import com.tbo.sn.domain.node.Hobby;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.domain.node.School;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.neo4j.ogm.session.Neo4jSession;
import org.neo4j.ogm.session.Session;

/**
 * @author tai
 * @since 3/17/18.
 */
public class PersonRepositoryImpl implements PersonRepositoryExt
{
    @Autowired
    private Session session;

    @Override
    public Iterable<Person> findPeopleWhoAttendSameSchoolAndShareSameHobbyToFollow( Long personId )
    {
        String query = "MATCH (h:Hobby)<-[:HOBBY]-(p:Person)-[:ATTENDED_SCHOOL]->(s:School) WHERE id(p) = {personId} " +
                "WITH h, p, s MATCH (h)<-[:HOBBY]-(p1)-[:ATTENDED_SCHOOL]->(s) WHERE NOT id(p) = id(p1) AND NOT (p)" +
                "-[:FOLLOWING]-(p1) RETURN" +
                " p1 ";
        Map<String, Object> params = new HashMap<>(  );
        params.put("personId", personId);
        Iterable<Person> peopleToFollow = session.query( Person.class, query, params );
        return peopleToFollow;
    }
}
