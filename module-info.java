module rumahTangga {
    requires java.sql;
    requires spring.beans;
    requires spring.context;
    requires java.xml.crypto;
    requires org.slf4j;

    opens rumahTangga;
    opens rumahTangga.entities;
    opens rumahTangga.repositories;
    opens rumahTangga.services;
    opens rumahTangga.views;
    opens rumahTangga.config;
}