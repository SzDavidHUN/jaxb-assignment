package hu.me.iit.jaxbAssignment.Enity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.util.UUID;

@XmlRootElement(name = "shipment")
public class Shipment {
    private UUID id;
    private String tackingNumber;
    private String senderAddress;
    private String reveiverAddress;
    private String status;

    public Shipment(String tackingNumber, String senderAddress, String reveiverAddress, String status) {
        this.id = UUID.randomUUID();
        this.tackingNumber = tackingNumber;
        this.senderAddress = senderAddress;
        this.reveiverAddress = reveiverAddress;
        this.status = status;
    }

    public Shipment() {
    }

    public UUID getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(UUID id) {
        this.id = id;
    }

    public String getTackingNumber() {
        return tackingNumber;
    }

    @XmlElement(name = "tn")
    public void setTackingNumber(String tackingNumber) {
        this.tackingNumber = tackingNumber;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    @XmlElement(name = "sender")
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReveiverAddress() {
        return reveiverAddress;
    }

    @XmlElement(name = "reveiver")
    public void setReveiverAddress(String reveiverAddress) {
        this.reveiverAddress = reveiverAddress;
    }

    public String getStatus() {
        return status;
    }

    @XmlElement(name = "status")
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return Objects.equals(tackingNumber, shipment.tackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tackingNumber);
    }

    @Override
    public String toString() {
        return "Shipment ["+id+"]"+
                "\n\tTracking Number: " + tackingNumber +
                "\n\tSender:          " + senderAddress +
                "\n\tReceiver:        " + reveiverAddress +
                "\n\tStatus:          " + status;
    }
}
