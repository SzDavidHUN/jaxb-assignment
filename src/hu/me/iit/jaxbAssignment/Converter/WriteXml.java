package hu.me.iit.jaxbAssignment.Converter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriteXml<T> {
    private JAXBContext jaxbContext;

    public WriteXml(Class<T> writerClass) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(writerClass);
    }

    public void write(T pojo, String filename, boolean consoleCopy) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(pojo, new File(filename));
        if (consoleCopy)
            marshaller.marshal(pojo, System.out);
        return;
    }

    public void write(T pojo, String filename) throws JAXBException {
        write(pojo, filename, false);
    }
}
