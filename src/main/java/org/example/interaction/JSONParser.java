package org.example.interaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

public class JSONParser {
    public static String getObject(Object payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(); //deprecated
        mapper.setAnnotationIntrospector(introspector);
        return mapper.writeValueAsString(payload);

    }

    public static Object saveObject(String payload, Class clazz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(); //deprecated
        mapper.setAnnotationIntrospector(introspector);
        return mapper.readValue(payload, clazz);


    }
    //todo: устранить дублирование кода, продумать Static, либо класс с состоянием и без дублирования
    //сразу возвращать тип через generic
    //менять реализацию извне в runtime (задать как свойство). Реализации должны наследовать интерфейс или от одного предка
}
