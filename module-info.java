module PBO.MID.Kelompok.GMGroup {
    requires spring.context;
    requires spring.beans;
    requires java.sql;
    requires org.slf4j;

    opens rumahTangga;
    opens rumahTangga.entities;
    opens rumahTangga.config;
    opens rumahTangga.views;
    opens rumahTangga.services;
    opens rumahTangga.repositories;

}