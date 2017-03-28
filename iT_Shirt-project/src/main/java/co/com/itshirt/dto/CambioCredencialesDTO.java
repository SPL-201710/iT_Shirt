package co.com.itshirt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO encapsula información para el cambio de contraseña.
 *
 */
public class CambioCredencialesDTO {
	
	@NotNull
    @Size(max=30)
	private String actualPassword;
	@NotNull
    @Size(max=30)
	private String newPassword;
	@NotNull
    @Size(max=30)
	private String passwordConfirm;
	
	public CambioCredencialesDTO() {
		super();
	}

	public String getActualPassword() {
		return actualPassword;
	}

	public void setActualPassword(String actualPassword) {
		this.actualPassword = actualPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
    
}
