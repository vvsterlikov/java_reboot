package org.example.interaction;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.xml.bind.JAXBException;

public interface Parser {
    public Object getObject(String xmlString, Class c) throws JAXBException, JsonProcessingException;

    public String saveObject(Object o) throws JsonProcessingException, JAXBException;
}
