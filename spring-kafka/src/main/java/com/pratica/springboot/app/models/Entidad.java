package com.pratica.springboot.app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class Entidad{

	/*public static void main(String[] args) {
		
		

	}*/
	
	@Override
	public String toString() {
		return "Entidad [ccenint=" + ccenint + ", cdcanalp=" + cdcanalp + ", cdcarter=" + cdcarter + ", cdestref="
				+ cdestref + ", corona=" + corona + ", dgorefen=" + dgorefen + ", eempint=" + eempint + "]";
	}

	private String ccenint;

	private String cdcanalp;

	private String cdcarter;

	private String cdestref;

	private Corona corona;

	private Dgorefen dgorefen;

	private int eempint;

	public String getCcenint() {
		return ccenint;
	}

	public void setCcenint(String ccenint) {
		this.ccenint = ccenint;
	}

	public String getCdcanalp() {
		return cdcanalp;
	}

	public void setCdcanalp(String cdcanalp) {
		this.cdcanalp = cdcanalp;
	}

	public String getCdcarter() {
		return cdcarter;
	}

	public void setCdcarter(String cdcarter) {
		this.cdcarter = cdcarter;
	}

	public String getCdestref() {
		return cdestref;
	}

	public void setCdestref(String cdestref) {
		this.cdestref = cdestref;
	}

	



	public int getEempint() {
		return eempint;
	}

	public void setEempint(int eempint) {
		this.eempint = eempint;
	}

	public Corona getCorona() {
		return corona;
	}

	public void setCorona(Corona corona) {
		this.corona = corona;
	}

	public Dgorefen getDgorefen() {
		return dgorefen;
	}

	public void setDgorefen(Dgorefen dgorefen) {
		this.dgorefen = dgorefen;
	}

	public class Corona{
		
		@Override
		public String toString() {
			return "Corona [codser=" + codser + ", fecha=" + fecha + ", nueref=" + nueref + ", surefe=" + surefe + "]";
		}

		private String codser;
		
		private Date fecha;
		
		private int nueref;
		
		private String surefe;

		public String getCodser() {
			return codser;
		}

		public void setCodser(String codser) {
			this.codser = codser;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public int getNueref() {
			return nueref;
		}

		public void setNueref(int nueref) {
			this.nueref = nueref;
		}

		public String getSurefe() {
			return surefe;
		}

		public void setSurefe(String surefe) {
			this.surefe = surefe;
		}

		
		
		
	}
	
	public class Dgorefen{
		
		@Override
		public String toString() {
			return "Dgorefen [catrpbat=" + catrpbat + ", cdtrpbat=" + cdtrpbat + ", fecha2=" + fecha2 + ", idcentdg="
					+ idcentdg + ", idemprdg=" + idemprdg + ", numdgodg=" + numdgodg + ", termbtdg=" + termbtdg + "]";
		}

		private String catrpbat;
		
		private String cdtrpbat;
		
		private Date fecha2;
		
		private String idcentdg;
		
		private String idemprdg;
		
		private int numdgodg;
		
		private String termbtdg;

		public String getCatrpbat() {
			return catrpbat;
		}

		public void setCatrpbat(String catrpbat) {
			this.catrpbat = catrpbat;
		}

		public String getCdtrpbat() {
			return cdtrpbat;
		}

		public void setCdtrpbat(String cdtrpbat) {
			this.cdtrpbat = cdtrpbat;
		}

		public Date getFecha2() {
			return fecha2;
		}

		public void setFecha2(Date fecha2) {
			this.fecha2 = fecha2;
		}

		public String getIdcentdg() {
			return idcentdg;
		}

		public void setIdcentdg(String idcentdg) {
			this.idcentdg = idcentdg;
		}

		public String getIdemprdg() {
			return idemprdg;
		}

		public void setIdemprdg(String idemprdg) {
			this.idemprdg = idemprdg;
		}

		public int getNumdgodg() {
			return numdgodg;
		}

		public void setNumdgodg(int numdgodg) {
			this.numdgodg = numdgodg;
		}

		public String getTermbtdg() {
			return termbtdg;
		}

		public void setTermbtdg(String termbtdg) {
			this.termbtdg = termbtdg;
		}

		


		
	}


}



