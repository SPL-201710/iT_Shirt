package co.com.itshirt.domain;

public class Artista extends Usuario {
	public Usuario createArtista (Usuario usuario){
		Usuario artista = new Usuario(usuario); 
		return artista;
	}
}
