package hu.me.iit.jaxbAssignment.Enity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.function.Consumer;

@XmlRootElement(name = "shipments")
public class Shipments {
    List<Shipment> shipments;

    public List<Shipment> getShipments() {
        return shipments;
    }

    @XmlElement(name = "shipment")
    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public void add(Shipment shipment) {
        shipments.add(shipment);
    }

    public void forEach(Consumer<? super Shipment> var1) {
        shipments.forEach(var1);
    }

    @Override
    public String toString() {
        return "Shipments{" +
                "shipments=" + shipments +
                '}';
    }
}
