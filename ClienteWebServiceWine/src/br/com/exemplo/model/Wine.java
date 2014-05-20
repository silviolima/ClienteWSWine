package br.com.exemplo.model;

import java.io.Serializable;


public final class Wine implements Serializable {

	
	private Integer wineId;
	private String bottleLabel;
	private Integer vintageYear;
	private Integer bottleSize;
	private String wineType;
	private String grapeType;
	private String country;
	private String harmonization;
	private Integer alcoholContent;
		
	public Integer getWineId() {
		return wineId;
	}


	public void setId(Integer wineId) {
		this.wineId = wineId;
	}


	public String getBottleLabel() {
		return bottleLabel;
	}


	public void setBottleLabel(String bottleLabel) {
		this.bottleLabel = bottleLabel;
	}


	public Integer getVintageYear() {
		return vintageYear;
	}


	public void setVintageYear(Integer vintageYear) {
		this.vintageYear = vintageYear;
	}


	public Integer getBottleSize() {
		return bottleSize;
	}


	public void setBottleSize(Integer bottleSize) {
		this.bottleSize = bottleSize;
	}


	public String getWineType() {
		return wineType;
	}


	public void setWineType(String wineType) {
		this.wineType = wineType;
	}


	public String getGrapeType() {
		return grapeType;
	}


	public void setGrapeType(String grapeType) {
		this.grapeType = grapeType;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getHarmonization() {
		return harmonization;
	}


	public void setHarmonization(String harmonization) {
		this.harmonization = harmonization;
	}


	public Integer getAlcoholContent() {
		return alcoholContent;
	}


	public void setAlcoholContent(Integer alcoholContent) {
		this.alcoholContent = alcoholContent;
	}


	@Override
	public String toString() {
		return bottleLabel.toUpperCase() + "\n\nYear=" + vintageYear
				+ "\nSize=" + bottleSize + "\nType=" + wineType + "\nGrape=" + grapeType + "\nCountry=" +country + "\nHarmonization=" + 
				"Nada a comentar" + "\nAlcohol=" + alcoholContent +"%";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alcoholContent == null) ? 0 : alcoholContent.hashCode());
		result = prime * result
				+ ((bottleLabel == null) ? 0 : bottleLabel.hashCode());
		result = prime * result
				+ ((bottleSize == null) ? 0 : bottleSize.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((grapeType == null) ? 0 : grapeType.hashCode());
		result = prime * result
				+ ((harmonization == null) ? 0 : harmonization.hashCode());
		result = prime * result
				+ ((vintageYear == null) ? 0 : vintageYear.hashCode());
		result = prime * result + ((wineId == null) ? 0 : wineId.hashCode());
		result = prime * result
				+ ((wineType == null) ? 0 : wineType.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wine other = (Wine) obj;
		if (alcoholContent == null) {
			if (other.alcoholContent != null)
				return false;
		} else if (!alcoholContent.equals(other.alcoholContent))
			return false;
		if (bottleLabel == null) {
			if (other.bottleLabel != null)
				return false;
		} else if (!bottleLabel.equals(other.bottleLabel))
			return false;
		if (bottleSize == null) {
			if (other.bottleSize != null)
				return false;
		} else if (!bottleSize.equals(other.bottleSize))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (grapeType == null) {
			if (other.grapeType != null)
				return false;
		} else if (!grapeType.equals(other.grapeType))
			return false;
		if (harmonization == null) {
			if (other.harmonization != null)
				return false;
		} else if (!harmonization.equals(other.harmonization))
			return false;
		if (vintageYear == null) {
			if (other.vintageYear != null)
				return false;
		} else if (!vintageYear.equals(other.vintageYear))
			return false;
		if (wineId == null) {
			if (other.wineId != null)
				return false;
		} else if (!wineId.equals(other.wineId))
			return false;
		if (wineType == null) {
			if (other.wineType != null)
				return false;
		} else if (!wineType.equals(other.wineType))
			return false;
		return true;
	}
	
	
}