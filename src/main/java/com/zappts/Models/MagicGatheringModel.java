package com.zappts.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import javax.persistence.Table;



@Entity
@Table(name="tb_magic")
public class MagicGatheringModel implements Serializable {
	
		private static final long serialVersionUID = 1L;
	
	
		@Id
	    @GeneratedValue
		private Long id;
		
		@NotEmpty
		private String name;
		
		@NotEmpty
		private String edition;
		
		@NotEmpty
		private String foil;
		
		@NotEmpty
		private Double value;
		
		@NotEmpty
		private Integer cardsCaractere;
				
		private String language;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEdition() {
			return edition;
		}

		public void setEdition(String edition) {
			this.edition = edition;
		}

		public String getFoil() {
			return foil;
		}

		public void setFoil(String foil) {
			this.foil = foil;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}

		public Integer getCardsCaractere() {
			return cardsCaractere;
		}

		public void setCardsCaractere(Integer cardsCaractere) {
			this.cardsCaractere = cardsCaractere;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}	
		
		
}


