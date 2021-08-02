/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *   @author ricardo.leal
 */
  @Entity
  @Table(name = "mv_seg_reclamo")
  @XmlRootElement
public class ReclamoDetalleSeguimientoCabeceraResponse implements Serializable {

      @Id
      @Column(name = "reclcodigo")
    private Integer reclcodigo;
      @Column(name = "reclfolio")
    private Integer reclfolio;
      @Column(name = "odflcodigo")
    private Integer odflcodigo;
      @Column(name = "reclfechacrea")
    private Date reclfechacrea;
      @Column(name = "mreccodigo")
    private Integer mreccodigo;
      @Column(name = "mrecnombre")
    private String mrecnombre;
      @Column(name = "reclmonto")
    private Double reclmonto;
      @Column(name = "ereccodigo")
    private Integer ereccodigo;
      @Column(name = "erecnombre")
    private String erecnombre;
      @Column(name = "ciudcodigoorigen")
    private Integer ciudcodigoorigen;
      @Column(name = "ciudnombreorigen")
    private String ciudnombreorigen;
      @Column(name = "tentcodigo")
    private Integer tentcodigo;
      @Column(name = "tentdescripcion")
    private String tentdescripcion;
      @Column(name = "tpagcodigo")
    private Integer tpagcodigo;
      @Column(name = "tpagnombre")
    private String tpagnombre;
      @Column(name = "odfltotalkgs")
    private double odfltotalkgs;
      @Column(name = "odfltotalflete")
    private double odfltotalflete;
      @Column(name = "reminombres")
    private String reminombres;
      @Column(name = "remiapellidop")
    private String remiapellidop;
      @Column(name = "remiapellidom")
    private String remiapellidom;
      @Column(name = "destnombres")
    private String destnombres;
      @Column(name = "destapellidop")
    private String destapellidop;
      @Column(name = "destapellidom")
    private String destapellidom;
      @Column(name = "ciudcodigodestino")
    private Integer ciudcodigodestino;
      @Column(name = "ciudnombredestino")
    private String ciudnombredestino;
      @Column(name = "ccornumero")
    private Integer ccornumero;
      @Column(name = "ccordv")
    private String ccordv;
      @Column(name = "tsercodigo")
    private Integer tsercodigo;
      @Column(name = "tsernombre")
    private String tsernombre;
      @Column(name = "odfltotalencargos")
    private Integer odfltotalencargos;
      @Column(name = "odflmontovalordec")
    private double odflmontovalordec;
      @Column(name = "rclmreclamante")
    private Integer rclmreclamante;
      @Column(name = "rclmtiporeclamante")
    private Integer rclmtiporeclamante;
      @Column(name = "rclmrut")
    private Integer rclmrut;
      @Column(name = "rclmdv")
    private String rclmdv;
      @Column(name = "rclmrazonsocial")
    private String rclmrazonsocial;
      @Column(name = "rclmdireccion")
    private String rclmdireccion;
      @Column(name = "comucodigo")
    private Integer comucodigo;
      @Column(name = "comunombre")
    private String comunombre;
      @Column(name = "rclmtelefono")
    private String rclmtelefono;
      @Column(name = "ciudcodigoreclamo")
    private Integer ciudcodigoreclamo;
      @Column(name = "ciudnombrereclamo")
    private String ciudnombrereclamo;
      @Column(name = "rclmemail")
    private String rclmemail;
    @OneToMany()
    List<ReclamoDetalleSeguimientoResponse> ReclamoSeguimientoDetalleResponseList;   

    public Integer getReclcodigo() {
        return reclcodigo;
    }

    public Integer getReclfolio() {
        return reclfolio;
    }

    public Integer getOdflcodigo() {
        return odflcodigo;
    }

    public Date getReclfechacrea() {
        return reclfechacrea;
    }

    public Integer getMreccodigo() {
        return mreccodigo;
    }

    public String getMrecnombre() {
        return mrecnombre;
    }

    public Double getReclmonto() {
        return reclmonto;
    }

    public Integer getEreccodigo() {
        return ereccodigo;
    }

    public String getErecnombre() {
        return erecnombre;
    }

    public Integer getCiudcodigoorigen() {
        return ciudcodigoorigen;
    }

    public String getCiudnombreorigen() {
        return ciudnombreorigen;
    }

    public Integer getTentcodigo() {
        return tentcodigo;
    }

    public String getTentdescripcion() {
        return tentdescripcion;
    }

    public Integer getTpagcodigo() {
        return tpagcodigo;
    }

    public String getTpagnombre() {
        return tpagnombre;
    }

    public double getOdfltotalkgs() {
        return odfltotalkgs;
    }

    public double getOdfltotalflete() {
        return odfltotalflete;
    }

    public String getReminombres() {
        return reminombres;
    }

    public String getRemiapellidop() {
        return remiapellidop;
    }

    public String getRemiapellidom() {
        return remiapellidom;
    }

    public String getDestnombres() {
        return destnombres;
    }

    public String getDestapellidop() {
        return destapellidop;
    }

    public String getDestapellidom() {
        return destapellidom;
    }

    public Integer getCiudcodigodestino() {
        return ciudcodigodestino;
    }

    public String getCiudnombredestino() {
        return ciudnombredestino;
    }

    public Integer getCcornumero() {
        return ccornumero;
    }

    public String getCcordv() {
        return ccordv;
    }

    public Integer getTsercodigo() {
        return tsercodigo;
    }

    public String getTsernombre() {
        return tsernombre;
    }

    public Integer getOdfltotalencargos() {
        return odfltotalencargos;
    }

    public double getOdflmontovalordec() {
        return odflmontovalordec;
    }

    public Integer getRclmreclamante() {
        return rclmreclamante;
    }

    public Integer getRclmtiporeclamante() {
        return rclmtiporeclamante;
    }

    public Integer getRclmrut() {
        return rclmrut;
    }

    public String getRclmdv() {
        return rclmdv;
    }

    public String getRclmrazonsocial() {
        return rclmrazonsocial;
    }

    public String getRclmdireccion() {
        return rclmdireccion;
    }

    public Integer getComucodigo() {
        return comucodigo;
    }

    public String getComunombre() {
        return comunombre;
    }

    public String getRclmtelefono() {
        return rclmtelefono;
    }

    public Integer getCiudcodigoreclamo() {
        return ciudcodigoreclamo;
    }

    public String getCiudnombrereclamo() {
        return ciudnombrereclamo;
    }

    public String getRclmemail() {
        return rclmemail;
    }

    public List<ReclamoDetalleSeguimientoResponse> getReclamoSeguimientoDetalleResponseList() {
        return ReclamoSeguimientoDetalleResponseList;
    }

    public void setReclcodigo(Integer reclcodigo) {
        this.reclcodigo = reclcodigo;
    }

    public void setReclfolio(Integer reclfolio) {
        this.reclfolio = reclfolio;
    }

    public void setOdflcodigo(Integer odflcodigo) {
        this.odflcodigo = odflcodigo;
    }

    public void setReclfechacrea(Date reclfechacrea) {
        this.reclfechacrea = reclfechacrea;
    }

    public void setMreccodigo(Integer mreccodigo) {
        this.mreccodigo = mreccodigo;
    }

    public void setMrecnombre(String mrecnombre) {
        this.mrecnombre = mrecnombre;
    }

    public void setReclmonto(Double reclmonto) {
        this.reclmonto = reclmonto;
    }

    public void setEreccodigo(Integer ereccodigo) {
        this.ereccodigo = ereccodigo;
    }

    public void setErecnombre(String erecnombre) {
        this.erecnombre = erecnombre;
    }

    public void setCiudcodigoorigen(Integer ciudcodigoorigen) {
        this.ciudcodigoorigen = ciudcodigoorigen;
    }

    public void setCiudnombreorigen(String ciudnombreorigen) {
        this.ciudnombreorigen = ciudnombreorigen;
    }

    public void setTentcodigo(Integer tentcodigo) {
        this.tentcodigo = tentcodigo;
    }

    public void setTentdescripcion(String tentdescripcion) {
        this.tentdescripcion = tentdescripcion;
    }

    public void setTpagcodigo(Integer tpagcodigo) {
        this.tpagcodigo = tpagcodigo;
    }

    public void setTpagnombre(String tpagnombre) {
        this.tpagnombre = tpagnombre;
    }

    public void setOdfltotalkgs(double odfltotalkgs) {
        this.odfltotalkgs = odfltotalkgs;
    }

    public void setOdfltotalflete(double odfltotalflete) {
        this.odfltotalflete = odfltotalflete;
    }

    public void setReminombres(String reminombres) {
        this.reminombres = reminombres;
    }

    public void setRemiapellidop(String remiapellidop) {
        this.remiapellidop = remiapellidop;
    }

    public void setRemiapellidom(String remiapellidom) {
        this.remiapellidom = remiapellidom;
    }

    public void setDestnombres(String destnombres) {
        this.destnombres = destnombres;
    }

    public void setDestapellidop(String destapellidop) {
        this.destapellidop = destapellidop;
    }

    public void setDestapellidom(String destapellidom) {
        this.destapellidom = destapellidom;
    }

    public void setCiudcodigodestino(Integer ciudcodigodestino) {
        this.ciudcodigodestino = ciudcodigodestino;
    }

    public void setCiudnombredestino(String ciudnombredestino) {
        this.ciudnombredestino = ciudnombredestino;
    }

    public void setCcornumero(Integer ccornumero) {
        this.ccornumero = ccornumero;
    }

    public void setCcordv(String ccordv) {
        this.ccordv = ccordv;
    }

    public void setTsercodigo(Integer tsercodigo) {
        this.tsercodigo = tsercodigo;
    }

    public void setTsernombre(String tsernombre) {
        this.tsernombre = tsernombre;
    }

    public void setOdfltotalencargos(Integer odfltotalencargos) {
        this.odfltotalencargos = odfltotalencargos;
    }

    public void setOdflmontovalordec(double odflmontovalordec) {
        this.odflmontovalordec = odflmontovalordec;
    }

    public void setRclmreclamante(Integer rclmreclamante) {
        this.rclmreclamante = rclmreclamante;
    }

    public void setRclmtiporeclamante(Integer rclmtiporeclamante) {
        this.rclmtiporeclamante = rclmtiporeclamante;
    }

    public void setRclmrut(Integer rclmrut) {
        this.rclmrut = rclmrut;
    }

    public void setRclmdv(String rclmdv) {
        this.rclmdv = rclmdv;
    }

    public void setRclmrazonsocial(String rclmrazonsocial) {
        this.rclmrazonsocial = rclmrazonsocial;
    }

    public void setRclmdireccion(String rclmdireccion) {
        this.rclmdireccion = rclmdireccion;
    }

    public void setComucodigo(Integer comucodigo) {
        this.comucodigo = comucodigo;
    }

    public void setComunombre(String comunombre) {
        this.comunombre = comunombre;
    }

    public void setRclmtelefono(String rclmtelefono) {
        this.rclmtelefono = rclmtelefono;
    }

    public void setCiudcodigoreclamo(Integer ciudcodigoreclamo) {
        this.ciudcodigoreclamo = ciudcodigoreclamo;
    }

    public void setCiudnombrereclamo(String ciudnombrereclamo) {
        this.ciudnombrereclamo = ciudnombrereclamo;
    }

    public void setRclmemail(String rclmemail) {
        this.rclmemail = rclmemail;
    }

    public void setReclamoSeguimientoDetalleResponseList(List<ReclamoDetalleSeguimientoResponse> ReclamoSeguimientoDetalleResponseList) {
        this.ReclamoSeguimientoDetalleResponseList = ReclamoSeguimientoDetalleResponseList;
    }

    @Override
    public String toString() {
        return "ReclamoDetalleSeguimientoCabeceraResponse{" + "reclcodigo=" + reclcodigo + ", reclfolio=" + reclfolio + ", odflcodigo=" + odflcodigo + ", reclfechacrea=" + reclfechacrea + ", mreccodigo=" + mreccodigo + ", mrecnombre=" + mrecnombre + ", reclmonto=" + reclmonto + ", ereccodigo=" + ereccodigo + ", erecnombre=" + erecnombre + ", ciudcodigoorigen=" + ciudcodigoorigen + ", ciudnombreorigen=" + ciudnombreorigen + ", tentcodigo=" + tentcodigo + ", tentdescripcion=" + tentdescripcion + ", tpagcodigo=" + tpagcodigo + ", tpagnombre=" + tpagnombre + ", odfltotalkgs=" + odfltotalkgs + ", odfltotalflete=" + odfltotalflete + ", reminombres=" + reminombres + ", remiapellidop=" + remiapellidop + ", remiapellidom=" + remiapellidom + ", destnombres=" + destnombres + ", destapellidop=" + destapellidop + ", destapellidom=" + destapellidom + ", ciudcodigodestino=" + ciudcodigodestino + ", ciudnombredestino=" + ciudnombredestino + ", ccornumero=" + ccornumero + ", ccordv=" + ccordv + ", tsercodigo=" + tsercodigo + ", tsernombre=" + tsernombre + ", odfltotalencargos=" + odfltotalencargos + ", odflmontovalordec=" + odflmontovalordec + ", rclmreclamante=" + rclmreclamante + ", rclmtiporeclamante=" + rclmtiporeclamante + ", rclmrut=" + rclmrut + ", rclmdv=" + rclmdv + ", rclmrazonsocial=" + rclmrazonsocial + ", rclmdireccion=" + rclmdireccion + ", comucodigo=" + comucodigo + ", comunombre=" + comunombre + ", rclmtelefono=" + rclmtelefono + ", ciudcodigoreclamo=" + ciudcodigoreclamo + ", ciudnombrereclamo=" + ciudnombrereclamo + ", rclmemail=" + rclmemail + ", ReclamoSeguimientoDetalleResponseList=" + ReclamoSeguimientoDetalleResponseList.toString() + '}';
    }
   
}
