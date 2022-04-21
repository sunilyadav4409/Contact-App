package in.ashokit.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DETAILS")
public class Contact {

	@Column(name = "CONTACT_ID")
	@Id
	@GeneratedValue
	private Integer contactId;

	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;

	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;

	@Column(name = "CREATEDATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;

	@Column(name = "UPDATE_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updatDate;

	@Column(name = "ACTIVE_SW")
	private String activeSw;

}
