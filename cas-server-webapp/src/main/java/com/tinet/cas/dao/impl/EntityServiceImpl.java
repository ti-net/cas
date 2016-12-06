package com.tinet.cas.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tinet.cas.authentication.handler.CasAbstractJdbcHandler;
import com.tinet.cas.dao.EntityService;
import com.tinet.cas.model.Entity;

public class EntityServiceImpl extends CasAbstractJdbcHandler implements EntityService {

	@Override
	public Entity getByName(String name) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		BeanPropertyRowMapper<Entity> rowMapper = new BeanPropertyRowMapper<>(Entity.class);
		Entity entity = jdbcTemplate.queryForObject(" SELECT * FROM \"public\".\"entity\" where " + " \"entity_name\" = '"
				+ name + "' and \"status\" != 4 ", rowMapper);
		return entity;
	}
}
