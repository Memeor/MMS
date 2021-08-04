package com.memeor.mms.beans;

import java.util.Date;
import java.util.Objects;

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

@Entity(name = "organizations")
@Table(name = "organizations")
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Organization {
	
	@Id
	@SequenceGenerator(name = "mms_org_id_seq", sequenceName = "mms_org_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mms_org_id_seq")
	private Integer id;
	
	@NotBlank
	@Column(name = "name", unique= true)
	private String orgName;
	
	@NotBlank
	@Column(name = "address")
	private String address;
	
	@NotBlank
	@Column(name = "email", unique = true)
	private String email;
	
	@NotBlank
	@Column(name = "ph_number")
	private String phone_no;
	
	@NotBlank
	@Column(name = "description")
	private String description;
	
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
