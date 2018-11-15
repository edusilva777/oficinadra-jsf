/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByProid", query = "SELECT p FROM Produto p WHERE p.proid = :proid")
    , @NamedQuery(name = "Produto.findByPronome", query = "SELECT p FROM Produto p WHERE p.pronome = :pronome")
    , @NamedQuery(name = "Produto.findByProdescricao", query = "SELECT p FROM Produto p WHERE p.prodescricao = :prodescricao")
    , @NamedQuery(name = "Produto.findByPropreco", query = "SELECT p FROM Produto p WHERE p.propreco = :propreco")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proid")
    private Integer proid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "pronome")
    private String pronome;
    @Size(max = 120)
    @Column(name = "prodescricao")
    private String prodescricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "propreco")
    private BigDecimal propreco;
    @JoinColumn(name = "procatid", referencedColumnName = "catid")
    @ManyToOne
    private Categoria procatid;

    public Produto() {
    }

    public Produto(Integer proid) {
        this.proid = proid;
    }

    public Produto(Integer proid, String pronome, BigDecimal propreco) {
        this.proid = proid;
        this.pronome = pronome;
        this.propreco = propreco;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getPronome() {
        return pronome;
    }

    public void setPronome(String pronome) {
        this.pronome = pronome;
    }

    public String getProdescricao() {
        return prodescricao;
    }

    public void setProdescricao(String prodescricao) {
        this.prodescricao = prodescricao;
    }

    public BigDecimal getPropreco() {
        return propreco;
    }

    public void setPropreco(BigDecimal propreco) {
        this.propreco = propreco;
    }

    public Categoria getProcatid() {
        return procatid;
    }

    public void setProcatid(Categoria procatid) {
        this.procatid = procatid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proid != null ? proid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.proid == null && other.proid != null) || (this.proid != null && !this.proid.equals(other.proid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Produto[ proid=" + proid + " ]";
    }
    
}
