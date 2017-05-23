package co.com.itshirt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("config.properties")
@ConfigurationProperties(prefix="config")
public class VariabilityConfig {

	private boolean notifications;
    private boolean authFacebook;
    private boolean advancedSearch;
    private boolean changePassword;
    private boolean changeAddress;
    private boolean vip;
    
    private boolean rateProducts;
    private boolean authTwitter;
    private boolean shareOnSocialNetwork;
    private boolean facebook;
    private boolean twitter;
    private boolean designsByArtist;
    private boolean byArtist;
    private boolean ratingVar;
    		
    /**
     * Constructor por defecto.
     */
    public VariabilityConfig() {
		super();
	}

	public boolean isNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	public boolean isAuthFacebook() {
		return authFacebook;
	}

	public void setAuthFacebook(boolean authFacebook) {
		this.authFacebook = authFacebook;
	}

	public boolean isAdvancedSearch() {
		return advancedSearch;
	}

	public void setAdvancedSearch(boolean advancedSearch) {
		this.advancedSearch = advancedSearch;
	}

	public boolean isChangePassword() {
		return changePassword;
	}

	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}

	public boolean isChangeAddress() {
		return changeAddress;
	}

	public void setChangeAddress(boolean changeAddress) {
		this.changeAddress = changeAddress;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public boolean isRateProducts() {
		return rateProducts;
	}

	public void setRateProducts(boolean rateProducts) {
		this.rateProducts = rateProducts;
	}

	public boolean isAuthTwitter() {
		return authTwitter;
	}

	public void setAuthTwitter(boolean authTwitter) {
		this.authTwitter = authTwitter;
	}

	public boolean isShareOnSocialNetwork() {
		return shareOnSocialNetwork;
	}

	public void setShareOnSocialNetwork(boolean shareOnSocialNetwork) {
		this.shareOnSocialNetwork = shareOnSocialNetwork;
	}

	public boolean isFacebook() {
		return facebook;
	}

	public void setFacebook(boolean facebook) {
		this.facebook = facebook;
	}

	public boolean isTwitter() {
		return twitter;
	}

	public void setTwitter(boolean twitter) {
		this.twitter = twitter;
	}

	public boolean isDesignsByArtist() {
		return designsByArtist;
	}

	public void setDesignsByArtist(boolean designsByArtist) {
		this.designsByArtist = designsByArtist;
	}

	public boolean isByArtist() {
		return byArtist;
	}

	public void setByArtist(boolean byArtist) {
		this.byArtist = byArtist;
	}

	public boolean isRatingVar() {
		return ratingVar;
	}

	public void setRatingVar(boolean ratingVar) {
		this.ratingVar = ratingVar;
	}
	
}