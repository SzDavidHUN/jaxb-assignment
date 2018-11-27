package hu.me.iit.jaxbAssignment.Converter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReadXml<T> {
    private JAXBContext jaxbContext;

    public ReadXml(Class<T> readerClass) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(readerClass);
    }

    public T readShipments(String filename, boolean consoleCopy) throws JAXBException {
        File file = new File(filename);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T pojo = (T) unmarshaller.unmarshal(file);
        if (consoleCopy)
            System.out.println(pojo);
        return pojo;
    }

    public T readShipments(String filename) throws JAXBException {
        return readShipments(filename, false);
    }

}
