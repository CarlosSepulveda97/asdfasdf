/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ricardo.leal
 */
@Entity
@Table(name = "ma_motivo_reclamo")

public class MotivoReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mreccodigo")
    private int mreccodigo;

    @Column(name = "tipo_pago_nombre")
    private String tipo_pago_nombre;
    @Column(name = "mrecnombre")
    private String mrecnombre;
    @Column(name = "mrecreqof")
    private int mrecreqof;
    @Column(name = "mrecusuariocrea")
    private String mrecusuariocrea;
    @Column(name = "mrecusuariomodi")
    private String mrecusuariomodi;
    @Column(name = "mrecfechacrea")
    private String mrecfechacrea;
    @Column(name = "mrecfechamodi")
    private String mrecfechamodi;
    @Column(name = "mrecversion")
    private int mrecversion;

    public int getMreccodigo() {
        return mreccodigo;
    }

    public void setMreccodigo(int mreccodigo) {
        this.mreccodigo = mreccodigo;
    }

    public String getTipo_pago_nombre() {
        return tipo_pago_nombre;
    }

    public void setTipo_pago_nombre(String tipo_pago_nombre) {
        this.tipo_pago_nombre = tipo_pago_nombre;
    }

    public String getMrecnombre() {
        return mrecnombre;
    }

    public void setMrecnombre(String mrecnombre) {
        this.mrecnombre = mrecnombre;
    }

    public int getMrecreqof() {
        return mrecreqof;
    }

    public void setMrecreqof(int mrecreqof) {
        this.mrecreqof = mrecreqof;
    }

    public String getMrecusuariocrea() {
        return mrecusuariocrea;
    }

    public void setMrecusuariocrea(String mrecusuariocrea) {
        this.mrecusuariocrea = mrecusuariocrea;
    }

    public String getMrecusuariomodi() {
        return mrecusuariomodi;
    }

    public void setMrecusuariomodi(String mrecusuariomodi) {
        this.mrecusuariomodi = mrecusuariomodi;
    }

    public String getMrecfechacrea() {
        return mrecfechacrea;
    }

    public void setMrecfechacrea(String mrecfechacrea) {
        this.mrecfechacrea = mrecfechacrea;
    }

    public String getMrecfechamodi() {
        return mrecfechamodi;
    }

    public void setMrecfechamodi(String mrecfechamodi) {
        this.mrecfechamodi = mrecfechamodi;
    }

    public int getMrecversion() {
        return mrecversion;
    }

    public void setMrecversion(int mrecversion) {
        this.mrecversion = mrecversion;
    }
    
    
    

 
}
