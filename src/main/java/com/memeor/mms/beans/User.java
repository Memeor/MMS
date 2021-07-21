package com.memeor.mms.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "mms_user")
@Table(name = "mms_user")
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
	
	@Id
	@SequenceGenerator(name = "mms_user_id_seq", sequenceName = "mms_user_id_seq", allocationSize=1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator="mms_user_id_seq")
	private Integer id;

	@NotBlank
	@Column(unique=true)
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Column(name = "email_address", unique=true)
	private String emailAddress;
	private Boolean verified;
	private String verificationToken;

	@Column(name = "created_ts", updatable = false, columnDefinition= "TIMESTAMP WITH TIME ZONE")
	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTS;

	@Column(name = "updated_ts", updatable = false, columnDefinition= "TIMESTAMP WITH TIME ZONE")
	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTS;

	@PrePersist
	protected void onCreate() {
		this.createdTS = new Date();
	}
	
	@PreUpdate
    protected void onUpdate() {
        this.updatedTS = new Date();
    }
	
}
