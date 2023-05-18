package com.example.demo1.model;

public class Worker {
    private String name;
    private String lastname;
    private String Cargo;
    private double sueldo;
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
    private double totParafiscales;

    public Worker(String name, String lastname, String cargo, double sueldo, int diasTrabajados) {
        this.name = name;
        this.lastname = lastname;
        this.Cargo = cargo;
        this.sueldo = sueldo;
        this.diasTrabajados = diasTrabajados;
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

    public String getCargo() {
        return Cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public double getSueldoDevengado() {
        return (getSueldo() * getDiasTrabajados()) / 30;
    }

    public double getAuxTransporte() {
        double auxTransporte = 0;
        if (getSueldo() < 2320000) {
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
        return getSueldo() * 0.0417;
    }

    public double getInteresesCS() {
        return getTotDevengado() * 0.01;
    }

    public double getTotPrestacionesSo() {
        return getCesantia() + getPrimaLegal() + getVacaciones() + getInteresesCS();
    }

    public double getSaludSeguridad() {
        return getSueldo() * 0.085;
    }

    public double getPensionSeguridad() {
        return getSueldo() * 0.12;
    }

    public double getAtep() {
        return getSueldo() * 0.02436;
    }

    public double getTotSeguridad() {
        return getSaludSeguridad() + getPensionSeguridad() + getAtep();
    }

    public double getCajaComp() {
        return getSueldo() * 0.04;
    }

    public double getSena() {
        return getSueldo() * 0.02;
    }

    public double getIcbf() {
        return getSueldo() * 0.03;
    }

    public double getTotParafiscales() {
        return getCajaComp() + getSena() + getIcbf();
    }

}