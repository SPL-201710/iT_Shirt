package co.com.itshirt.processor.enums;

public enum OptionalFeatures {
	
	ADVANCED_SEARCH 		("AdvancedSearch"),
	RATE_PRODUCTS 			("RateProducts"),
	NOTIFICATIONS 			("Notifications"),
	AUTH_FACEBOOK 			("AuthFacebook"),
	AUTH_TWITTER 			("AuthTwitter"),
	CHANGE_PASSWORD 		("ChangePassword"),
	CHANGE_ADRESS 			("ChangeAddress"),
	SHARE_ON_SOCIALNETWORK 	("ShareOnSocialNetwork"),
	FACEBOOK 				("Facebook"),
	TWITTER 				("Twitter"),
	VIP 					("Vip"),
	REPORT_RATING 			("DesignsByArtist"),
	REPORT_SALES 			("ByArtist"),
	;
	
	public static final OptionalFeatures[] VALUES = OptionalFeatures.values();
	
	private String name; //Nombre igual al definido en Feature IDE.
	
	private OptionalFeatures(final String name) {
		this.name = name;
	}
	
	public static boolean contains(String nameFeature) {
	    for (OptionalFeatures f : VALUES) {
	        if (f.getName().equals(nameFeature)) {
	            return true;
	        }
	    }
	    return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
