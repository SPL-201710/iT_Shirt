package co.com.itshirt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orde_detalleorden")
public class Personalizacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deto_id")
	private Long idDetalle;
	
	@Column(name = "deto_talla")
	private String talla;
	
	@Column(name = "deto_color")
	private String color;
	
	@Column(name = "deto_textoconfigurado")
	private String texto;
	
	@Column(name = "deto_preciocamiseta")
	private Long preciocamiseta;
	
	@Column(name = "deto_precioestampa")
	private Long precioestampa;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orde_id")
    private OrdenCompra orden;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "esti_id")
    private EstiloCamiseta estilo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "esta_id")
    private Estampa estampa;
}
