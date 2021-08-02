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
@Entity(name = "mv_nomina")
@Table(name = "mv_nomina")
public class Nomina implements Serializable {

    @Id 
    private Double nomicodigo;
    private Integer usuacodigoresp;
    private Integer servcodigo;
    private Date nomifechacreacion;
    private Date nomihoracreacion;
    private Integer enomcodigo;
    private Integer usuacodigocrea;
    private Date nomifecharecep;
    private Date nomihorarecep;
    private Integer usuacodigorecep;
    private Integer usuacodigodesp;
    private Integer nomitotalofs;
    private Integer nomitotalencargos;
    private float nomitotalkgs;
    private float nomitotalm3;
    private float nomibcomisionablen;
    private float nomibcomisionabler;
    private Integer emprcodigo;
    private Integer agencodigoorigen;
    private Integer agencodigodestino;
    private Integer ubifcodigo;
    private Integer tnomcodigo;
    private Integer rendcodigo;
    private Integer maqucodigo;
    private Integer triprutpiloto;
    private Integer triprutcopiloto;
    private Integer triprutauxiliar;
    private Date nomifechadesp;
    private Date nomifechahoramodi;
    private Date nomihoradespacho;
    private Integer triprutpiloto2;
    private Integer triprutcopiloto2;
    private Integer triprutauxiliar2;
    private Integer triprutpiloto3;
    private Integer triprutcopiloto3;
    private Integer triprutauxiliar3;
    private Integer tsercodigo;
    private Integer ubifdespacho;
    private static final long serialVersionUID = 1L;

    public Double getNomicodigo() {
        return nomicodigo;
    }

    public Integer getUsuacodigoresp() {
        return usuacodigoresp;
    }

    public Integer getServcodigo() {
        return servcodigo;
    }

    public Date getNomifechacreacion() {
        return nomifechacreacion;
    }

    public Date getNomihoracreacion() {
        return nomihoracreacion;
    }

    public Integer getEnomcodigo() {
        return enomcodigo;
    }

    public Integer getUsuacodigocrea() {
        return usuacodigocrea;
    }

    public Date getNomifecharecep() {
        return nomifecharecep;
    }

    public Date getNomihorarecep() {
        return nomihorarecep;
    }

    public Integer getUsuacodigorecep() {
        return usuacodigorecep;
    }

    public Integer getUsuacodigodesp() {
        return usuacodigodesp;
    }

    public Integer getNomitotalofs() {
        return nomitotalofs;
    }

    public Integer getNomitotalencargos() {
        return nomitotalencargos;
    }

    public float getNomitotalkgs() {
        return nomitotalkgs;
    }

    public float getNomitotalm3() {
        return nomitotalm3;
    }

    public float getNomibcomisionablen() {
        return nomibcomisionablen;
    }

    public float getNomibcomisionabler() {
        return nomibcomisionabler;
    }

    public Integer getEmprcodigo() {
        return emprcodigo;
    }

    public Integer getAgencodigoorigen() {
        return agencodigoorigen;
    }

    public Integer getAgencodigodestino() {
        return agencodigodestino;
    }

    public Integer getUbifcodigo() {
        return ubifcodigo;
    }

    public Integer getTnomcodigo() {
        return tnomcodigo;
    }

    public Integer getRendcodigo() {
        return rendcodigo;
    }

    public Integer getMaqucodigo() {
        return maqucodigo;
    }

    public Integer getTriprutpiloto() {
        return triprutpiloto;
    }

    public Integer getTriprutcopiloto() {
        return triprutcopiloto;
    }

    public Integer getTriprutauxiliar() {
        return triprutauxiliar;
    }

    public Date getNomifechadesp() {
        return nomifechadesp;
    }

    public Date getNomifechahoramodi() {
        return nomifechahoramodi;
    }

    public Date getNomihoradespacho() {
        return nomihoradespacho;
    }

    public Integer getTriprutpiloto2() {
        return triprutpiloto2;
    }

    public Integer getTriprutcopiloto2() {
        return triprutcopiloto2;
    }

    public Integer getTriprutauxiliar2() {
        return triprutauxiliar2;
    }

    public Integer getTriprutpiloto3() {
        return triprutpiloto3;
    }

    public Integer getTriprutcopiloto3() {
        return triprutcopiloto3;
    }

    public Integer getTriprutauxiliar3() {
        return triprutauxiliar3;
    }

    public Integer getTsercodigo() {
        return tsercodigo;
    }

    public Integer getUbifdespacho() {
        return ubifdespacho;
    }

    public void setNomicodigo(Double nomicodigo) {
        this.nomicodigo = nomicodigo;
    }

    public void setUsuacodigoresp(Integer usuacodigoresp) {
        this.usuacodigoresp = usuacodigoresp;
    }

    public void setServcodigo(Integer servcodigo) {
        this.servcodigo = servcodigo;
    }

    public void setNomifechacreacion(Date nomifechacreacion) {
        this.nomifechacreacion = nomifechacreacion;
    }

    public void setNomihoracreacion(Date nomihoracreacion) {
        this.nomihoracreacion = nomihoracreacion;
    }

    public void setEnomcodigo(Integer enomcodigo) {
        this.enomcodigo = enomcodigo;
    }

    public void setUsuacodigocrea(Integer usuacodigocrea) {
        this.usuacodigocrea = usuacodigocrea;
    }

    public void setNomifecharecep(Date nomifecharecep) {
        this.nomifecharecep = nomifecharecep;
    }

    public void setNomihorarecep(Date nomihorarecep) {
        this.nomihorarecep = nomihorarecep;
    }

    public void setUsuacodigorecep(Integer usuacodigorecep) {
        this.usuacodigorecep = usuacodigorecep;
    }

    public void setUsuacodigodesp(Integer usuacodigodesp) {
        this.usuacodigodesp = usuacodigodesp;
    }

    public void setNomitotalofs(Integer nomitotalofs) {
        this.nomitotalofs = nomitotalofs;
    }

    public void setNomitotalencargos(Integer nomitotalencargos) {
        this.nomitotalencargos = nomitotalencargos;
    }

    public void setNomitotalkgs(float nomitotalkgs) {
        this.nomitotalkgs = nomitotalkgs;
    }

    public void setNomitotalm3(float nomitotalm3) {
        this.nomitotalm3 = nomitotalm3;
    }

    public void setNomibcomisionablen(float nomibcomisionablen) {
        this.nomibcomisionablen = nomibcomisionablen;
    }

    public void setNomibcomisionabler(float nomibcomisionabler) {
        this.nomibcomisionabler = nomibcomisionabler;
    }

    public void setEmprcodigo(Integer emprcodigo) {
        this.emprcodigo = emprcodigo;
    }

    public void setAgencodigoorigen(Integer agencodigoorigen) {
        this.agencodigoorigen = agencodigoorigen;
    }

    public void setAgencodigodestino(Integer agencodigodestino) {
        this.agencodigodestino = agencodigodestino;
    }

    public void setUbifcodigo(Integer ubifcodigo) {
        this.ubifcodigo = ubifcodigo;
    }

    public void setTnomcodigo(Integer tnomcodigo) {
        this.tnomcodigo = tnomcodigo;
    }

    public void setRendcodigo(Integer rendcodigo) {
        this.rendcodigo = rendcodigo;
    }

    public void setMaqucodigo(Integer maqucodigo) {
        this.maqucodigo = maqucodigo;
    }

    public void setTriprutpiloto(Integer triprutpiloto) {
        this.triprutpiloto = triprutpiloto;
    }

    public void setTriprutcopiloto(Integer triprutcopiloto) {
        this.triprutcopiloto = triprutcopiloto;
    }

    public void setTriprutauxiliar(Integer triprutauxiliar) {
        this.triprutauxiliar = triprutauxiliar;
    }

    public void setNomifechadesp(Date nomifechadesp) {
        this.nomifechadesp = nomifechadesp;
    }

    public void setNomifechahoramodi(Date nomifechahoramodi) {
        this.nomifechahoramodi = nomifechahoramodi;
    }

    public void setNomihoradespacho(Date nomihoradespacho) {
        this.nomihoradespacho = nomihoradespacho;
    }

    public void setTriprutpiloto2(Integer triprutpiloto2) {
        this.triprutpiloto2 = triprutpiloto2;
    }

    public void setTriprutcopiloto2(Integer triprutcopiloto2) {
        this.triprutcopiloto2 = triprutcopiloto2;
    }

    public void setTriprutauxiliar2(Integer triprutauxiliar2) {
        this.triprutauxiliar2 = triprutauxiliar2;
    }

    public void setTriprutpiloto3(Integer triprutpiloto3) {
        this.triprutpiloto3 = triprutpiloto3;
    }

    public void setTriprutcopiloto3(Integer triprutcopiloto3) {
        this.triprutcopiloto3 = triprutcopiloto3;
    }

    public void setTriprutauxiliar3(Integer triprutauxiliar3) {
        this.triprutauxiliar3 = triprutauxiliar3;
    }

    public void setTsercodigo(Integer tsercodigo) {
        this.tsercodigo = tsercodigo;
    }

    public void setUbifdespacho(Integer ubifdespacho) {
        this.ubifdespacho = ubifdespacho;
    }
 
}
