/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "trailer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trailer.findAll", query = "SELECT t FROM Trailer t")
    , @NamedQuery(name = "Trailer.findByIdTrailer", query = "SELECT t FROM Trailer t WHERE t.idTrailer = :idTrailer")})
public class Trailer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTrailer")
    private Integer idTrailer;
    @Lob
    @Size(max = 65535)
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "IdPelicula", referencedColumnName = "IdPelicula")
    @ManyToOne
    private Pelicula idPelicula;

    public Trailer() {
    }

    public Trailer(Integer idTrailer) {
        this.idTrailer = idTrailer;
    }

    public Integer getIdTrailer() {
        return idTrailer;
    }

    public void setIdTrailer(Integer idTrailer) {
        this.idTrailer = idTrailer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrailer != null ? idTrailer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trailer)) {
            return false;
        }
        Trailer other = (Trailer) object;
        if ((this.idTrailer == null && other.idTrailer != null) || (this.idTrailer != null && !this.idTrailer.equals(other.idTrailer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Trailer[ idTrailer=" + idTrailer + " ]";
    }
    
}
