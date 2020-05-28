package org.example.interaction;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLParser implements Parser {
    /* другой вариант без static
    JAXBContext context;
    public JaxbParser(Class c) throws JAXBException {
        this.context = JAXBContext.newInstance(c);
    }
    Static - быстро, но каждый раз нужно создавать контекст (скорость создания vs потребление памяти)
     */
    /*
    public static <T> T getObject(String xmlString, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c); //не нужно если не static
        Unmarshaller unmarshaller = context.createUnmarshaller();
        T Object = (T) unmarshaller.unmarshal(new StringReader(xmlString));
        return object;
        //todo: переделать на generic

    }
    */
    //private JAXBContext context;

    @Override
    public Object getObject(String xmlString, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c); //не нужно если не static
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new StringReader(xmlString));
        return object;
        //todo: переделать на generic

    }

    @Override
    public String saveObject(Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        StringWriter result = new StringWriter();
        marshaller.marshal(o, result);
        return result.toString();
    }
}
