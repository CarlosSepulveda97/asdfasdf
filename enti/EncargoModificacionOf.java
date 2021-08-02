/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ricardo.leal
 */
@Entity(name = "EncargoModificacionOf")
@Table(name = "EncargoModificacionOf")
public class EncargoModificacionOf  implements Serializable {

    private static final long serialVersionUID = 1L;
    Integer encacodigo;
    String encacodigobarra;
    Integer odflcodigo;
    Integer tenccodigo;
    Integer eprocodigo;
    Integer tconcodigo;
    String encacontenido;
    float encakgs;
    float encam3;
    float encalargo;
    float encaalto;
    float encaancho;
    Integer encaunidades;
    Integer eenccodigo;
    Integer encagrupo;
    Integer ubiccodigoactual;
    Integer nomicodigoactual;
    Integer usuacodigocontrol;
    Date encafechacontrol;
    Date encahoracontrol;
    Integer ubiccodigo;
    Integer encacodigobarraturex;
    Integer encaclasifsorter;
    Integer isinformadosorter;
 

    @Id
    public Integer getEncacodigo() {
        return encacodigo;
    }

    public String getEncacodigobarra() {
        return encacodigobarra;
    }

    public Integer getOdflcodigo() {
        return odflcodigo;
    }

    public Integer getTenccodigo() {
        return tenccodigo;
    }

    public Integer getEprocodigo() {
        return eprocodigo;
    }

    public Integer getTconcodigo() {
        return tconcodigo;
    }

    public String getEncacontenido() {
        return encacontenido;
    }

    public float getEncakgs() {
        return encakgs;
    }

    public float getEncam3() {
        return encam3;
    }

    public float getEncalargo() {
        return encalargo;
    }

    public float getEncaalto() {
        return encaalto;
    }

    public float getEncaancho() {
        return encaancho;
    }

    public Integer getEncaunidades() {
        return encaunidades;
    }

    public Integer getEenccodigo() {
        return eenccodigo;
    }

    public Integer getEncagrupo() {
        return encagrupo;
    }

    public Integer getUbiccodigoactual() {
        return ubiccodigoactual;
    }

    public Integer getNomicodigoactual() {
        return nomicodigoactual;
    }

    public Integer getUsuacodigocontrol() {
        return usuacodigocontrol;
    }

    public Date getEncafechacontrol() {
        return encafechacontrol;
    }

    public Date getEncahoracontrol() {
        return encahoracontrol;
    }

    public Integer getUbiccodigo() {
        return ubiccodigo;
    }

    public Integer getEncacodigobarraturex() {
        return encacodigobarraturex;
    }

    public Integer getEncaclasifsorter() {
        return encaclasifsorter;
    }

    public Integer getIsinformadosorter() {
        return isinformadosorter;
    }

    public void setEncacodigo(Integer encacodigo) {
        this.encacodigo = encacodigo;
    }

    public void setEncacodigobarra(String encacodigobarra) {
        this.encacodigobarra = encacodigobarra;
    }

    public void setOdflcodigo(Integer odflcodigo) {
        this.odflcodigo = odflcodigo;
    }

    public void setTenccodigo(Integer tenccodigo) {
        this.tenccodigo = tenccodigo;
    }

    public void setEprocodigo(Integer eprocodigo) {
        this.eprocodigo = eprocodigo;
    }

    public void setTconcodigo(Integer tconcodigo) {
        this.tconcodigo = tconcodigo;
    }

    public void setEncacontenido(String encacontenido) {
        this.encacontenido = encacontenido;
    }

    public void setEncakgs(float encakgs) {
        this.encakgs = encakgs;
    }

    public void setEncam3(float encam3) {
        this.encam3 = encam3;
    }

    public void setEncalargo(float encalargo) {
        this.encalargo = encalargo;
    }

    public void setEncaalto(float encaalto) {
        this.encaalto = encaalto;
    }

    public void setEncaancho(float encaancho) {
        this.encaancho = encaancho;
    }

    public void setEncaunidades(Integer encaunidades) {
        this.encaunidades = encaunidades;
    }

    public void setEenccodigo(Integer eenccodigo) {
        this.eenccodigo = eenccodigo;
    }

    public void setEncagrupo(Integer encagrupo) {
        this.encagrupo = encagrupo;
    }

    public void setUbiccodigoactual(Integer ubiccodigoactual) {
        this.ubiccodigoactual = ubiccodigoactual;
    }

    public void setNomicodigoactual(Integer nomicodigoactual) {
        this.nomicodigoactual = nomicodigoactual;
    }

    public void setUsuacodigocontrol(Integer usuacodigocontrol) {
        this.usuacodigocontrol = usuacodigocontrol;
    }

    public void setEncafechacontrol(Date encafechacontrol) {
        this.encafechacontrol = encafechacontrol;
    }

    public void setEncahoracontrol(Date encahoracontrol) {
        this.encahoracontrol = encahoracontrol;
    }

    public void setUbiccodigo(Integer ubiccodigo) {
        this.ubiccodigo = ubiccodigo;
    }

    public void setEncacodigobarraturex(Integer encacodigobarraturex) {
        this.encacodigobarraturex = encacodigobarraturex;
    }

    public void setEncaclasifsorter(Integer encaclasifsorter) {
        this.encaclasifsorter = encaclasifsorter;
    }

    public void setIsinformadosorter(Integer isinformadosorter) {
        this.isinformadosorter = isinformadosorter;
    }

}
