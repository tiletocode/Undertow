package com.hdr.undertow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hdr.undertow.entity.Undertow;

@Repository
public interface UndertowRepository extends JpaRepository<Undertow, Long>{
	@Transactional
	Undertow findTop1ByOrderByIdDesc();
}
