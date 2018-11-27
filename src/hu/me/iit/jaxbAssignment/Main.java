package hu.me.iit.jaxbAssignment;

import hu.me.iit.jaxbAssignment.Converter.ReadXml;
import hu.me.iit.jaxbAssignment.Converter.WriteXml;
import hu.me.iit.jaxbAssignment.Enity.Shipment;
import hu.me.iit.jaxbAssignment.Enity.Shipments;

import javax.xml.bind.JAXBException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws JAXBException, NoSuchFieldException {
        String defaultReadFilename = "shipment.xml";
        String defaultWriteFilename = "shipmentOut.xml";

        ReadXml<Shipments> sr = new ReadXml<>(Shipments.class);
        WriteXml<Shipments> sw = new WriteXml<>(Shipments.class);
        Scanner sc = new Scanner(System.in);
        Shipments shipments = readFile(sc, sr, defaultReadFilename);

        boolean run = true;
        while (run) {
            System.out.println("\n1.\tÚjraolvasás\n2.\tListázás\n3:\tLekérdezés\n4.\tMódosítás\n5.\tHozzáad\n6.\tTörlés\n7.\tMentés\n\n0. Kilépés\n\nVálassz: ");
            int i = sc.nextInt();
            sc.nextLine();
            switch (i) {
                case 0:
                    run = false;
                    break;
                case 1:
                    shipments = readFile(sc, sr, defaultReadFilename);
                case 2: {
                    shipments.forEach(p -> System.out.println(p));
                }
                break;
                case 3: {
                    System.out.println("Tracking Number: ");
                    String tn = sc.nextLine();
                    System.out.println("Eredmények (" + tn + "-re):");
                    shipments.forEach(p -> {
                        if (p.getTackingNumber().equals(tn)) System.out.println(p);
                    });
                }
                break;
                case 4: {
                    System.out.println("Tracking Number: ");
                    String tn = sc.nextLine();
                    System.out.println("Eredmények (" + tn + "-re):");
                    shipments.forEach(p -> {
                        String inp;
                        if (p.getTackingNumber().equals(tn)) {
                            System.out.println("Tracking Number [" + p.getTackingNumber() + "]:");
                            inp = sc.nextLine();
                            if (!inp.isEmpty())
                                p.setTackingNumber(inp);

                            System.out.println("Sender [" + p.getSenderAddress() + "]:");
                            inp = sc.nextLine();
                            if (!inp.isEmpty())
                                p.setSenderAddress(inp);

                            System.out.println("Receiver {" + p.getReveiverAddress() + "]:");
                            inp = sc.nextLine();
                            if (!inp.isEmpty())
                                p.setReveiverAddress(inp);

                            System.out.println("Status [" + p.getStatus() + "]:");
                            inp = sc.nextLine();
                            if (!inp.isEmpty())
                                p.setStatus(inp);
                        }
                    });
                }
                break;
                case 5:
                    System.out.println("Add meg a következő paramétereket, soronként egyet:\n" +
                            "TN, Feladó, Címzett, Státusz");
                    shipments.add(new Shipment(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
                    break;
                case 6: {
                    System.out.println("Tracking Number: ");
                    String tn = sc.nextLine();
                    Shipments tmp = new Shipments();
                    tmp.setShipments(new LinkedList<>());
                    shipments.forEach(p -> {
                        if (!p.getTackingNumber().equals(tn)) tmp.add(p);
                    });
                    shipments = tmp;
                }
                break;
                case 7: {
                    saveFile(shipments, sc, sw, defaultWriteFilename);
                }
                break;
                default:
                    System.out.println("Opció nem található!");
            }
        }
        sc.close();
    }

    public static Shipments readFile(Scanner sc, ReadXml<Shipments> sr, String defaultFilename) throws JAXBException {
        String filename = getFilename(sc, defaultFilename);
        System.out.println("Beolvasás..");
        Shipments shipments = sr.readShipments(filename);
        System.out.println("OK!\n");
        return shipments;
    }

    public static void saveFile(Shipments shipments, Scanner sc, WriteXml<Shipments> sw, String defaultFilename) throws JAXBException {
        String filename = getFilename(sc, defaultFilename);
        sw.write(shipments, filename);
    }

    public static String getFilename(Scanner sc, String defaultFilename) {
        System.out.println("Fájlnév [" + defaultFilename + "]:");
        String filename = sc.nextLine();
        if (filename.isEmpty())
            filename = defaultFilename;
        return filename;
    }
}
