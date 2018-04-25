package es.urjc.code.daw.library.valorations;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.code.daw.library.user.User;



@Entity
public class Valoration {
	
	public interface ValorationAtt {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	
	@Autowired
	@ManyToOne
	private User seller;
	
	@Autowired
	@ManyToOne
	@JsonView(ValorationAtt.class)
	private User buyer;
	
	@JsonView(ValorationAtt.class)
	private int valoration;
	
	@JsonView(ValorationAtt.class)
	private String description;
	
	@JsonView(ValorationAtt.class)
	private String date;
	
	
	public Valoration () {}
	
	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public int getValoration() {
		return valoration;
	}

	public void setValoration(int valoration) {
		this.valoration = valoration;
	}

	
	public Valoration(User seller, User buyer, int valoration, String description) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.valoration = valoration;
		this.description = description;
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		this.date=calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+"-"+calendar.get(Calendar.YEAR);
	}
	
	public Valoration(User seller, User buyer, int valoration, String description, String date) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.valoration = valoration;
		this.description = description;
		this.date=date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String date() {
		return date;
	}

	public void setCalendar(String date) {
		this.date = date;
	}
	
	public void createDate() {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		this.date=calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+"-"+calendar.get(Calendar.YEAR);
	}
	
	

}