package com.example.demo1.model;

import java.time.LocalDate;
import java.util.Date;

public class Worker {
    private String name;
    private String lastname;
    private String charge;
    private int salary;
    private int diasTrabajados;
    private double sueldoDevengado;
    private double auxTransporte;
    private double totDevengado;
    private double salud;
    private double pension;
    private double totDeducciones;
    private double pagoNeto;
    private double cesantia;
    private double primaLegal;
    private double vacaciones;
    private double interesesCS;
    private double totPrestacionesSo;
    private double saludSeguridad;
    private double pensionSeguridad;
    private double atep;
    private double totSeguridad;
    private double cajaComp;
    private double sena;
    private double icbf;

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    private LocalDate entryDate;
    private double totParafiscales;

    public Worker(String name, String cargo, double sueldo, LocalDate entryDate) {
        String[] n = name.split(" ");
        if(n.length==4){
            this.name = (n[0]+" "+n[1]).toUpperCase();
            this.lastname = (n[2]+" "+n[3]).toUpperCase();
        } else if (n.length==3) {
            this.name = n[0].toUpperCase();
            this.lastname = (n[1]+" "+n[2]).toUpperCase();
        }

        this.entryDate = entryDate;
        this.charge = cargo.toUpperCase();
        this.salary =(int)sueldo;
        LocalDate date = java.time.LocalDate.now();
        this.diasTrabajados = date.getDayOfMonth();
        this.sueldoDevengado = getSueldoDevengado();
        this.auxTransporte = getAuxTransporte();
        this.totDevengado = getTotDevengado();
        this.salud = getSalud();
        this.pension = getPension();
        this.totDeducciones = getTotDeducciones();
        this.pagoNeto = getPagoNeto();
        this.cesantia = getCesantia();
        this.primaLegal = getPrimaLegal();
        this.vacaciones = getVacaciones();
        this.interesesCS = getInteresesCS();
        this.totPrestacionesSo = getTotPrestacionesSo();
        this.saludSeguridad = getSaludSeguridad();
        this.pensionSeguridad = getPensionSeguridad();
        this.atep = getAtep();
        this.totSeguridad = getTotSeguridad();
        this.cajaComp = getCajaComp();
        this.sena = getSena();
        this.icbf = getIcbf();
        this.totParafiscales = getTotParafiscales();
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCharge() {
        return charge;
    }

    public double getSalary() {
        return salary;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public double getSueldoDevengado() {
        return (getSalary() * getDiasTrabajados()) / 30;
    }

    public double getAuxTransporte() {
        double auxTransporte = 0;
        if (getSalary() < 2320000) {
            auxTransporte = 140606 * getDiasTrabajados() / 30;
        }
        return auxTransporte;
    }

    public double getTotDevengado() {
        return getSueldoDevengado() + getAuxTransporte();
    }

    public double getSalud() {
        return getSueldoDevengado() * 0.04;
    }

    public double getPension() {
        return getSueldoDevengado() * 0.04;
    }

    public double getTotDeducciones() {
        return getSalud() + getPension();
    }

    public double getPagoNeto() {
        return getTotDevengado() - getTotDeducciones();
    }

    public double getCesantia() {
        return getTotDevengado() * 0.0833;
    }

    public double getPrimaLegal() {
        return getTotDevengado() * 0.0833;
    }

    public double getVacaciones() {
        return getSalary() * 0.0417;
    }

    public double getInteresesCS() {
        return getTotDevengado() * 0.01;
    }

    public double getTotPrestacionesSo() {
        return getCesantia() + getPrimaLegal() + getVacaciones() + getInteresesCS();
    }

    public double getSaludSeguridad() {
        double saludSeguridad = 0;
        if (getSueldoDevengado() < 11600000) {
            saludSeguridad = 0;
        } else {
            saludSeguridad = getSueldoDevengado() * 0.04;
        }
        return saludSeguridad;
    }

    public double getPensionSeguridad() {
        return getSalary() * 0.12;
    }

    public double getAtep() {
        return getSalary() * 0.02436;
    }

    public double getTotSeguridad() {
        return getSaludSeguridad() + getPensionSeguridad() + getAtep();
    }

    public double getCajaComp() {
        return getSalary() * 0.04;
    }

    public double getSena() {
        return getSalary() * 0.02;
    }

    public double getIcbf() {
        return getSalary() * 0.03;
    }

    public double getTotParafiscales() {
        return getCajaComp() + getSena() + getIcbf();
    }

}