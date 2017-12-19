package com.kossine.ims.models;

import java.time.LocalTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Entity
@Table(name = "adapterusedby")
public class AdapterUsedBy {
	@Id
	@GeneratedValue
	private long id;

	// default column name is laptop_id , so no need of @JoinColumn
	@OneToOne(fetch=FetchType.LAZY)
	private Adapter adapter;

	@Convert(converter = Jsr310JpaConverters.LocalTimeConverter.class)
	private LocalTime time;

	@Size(max = 255)
	@NotNull
	private String location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Adapter getAdapter() {
		return adapter;
	}

	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AdapterUsedBy [id=" + id + ", adapter=" + adapter + ", time=" + time + ", location=" + location + "]";
	}

}
