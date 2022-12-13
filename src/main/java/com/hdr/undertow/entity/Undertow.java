package com.hdr.undertow.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Undertow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDateTime time;
	
	@Column
    private int count;
	
	@Builder
	public Undertow(Long id, LocalDateTime time, int count) {
		this.id = id;
        this.time = time;
        this.count = count;
	}

}
