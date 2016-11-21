package com.tinet.cas.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tinet.cas.authentication.handler.CasAbstractJdbcHandler;
import com.tinet.cas.dao.AuthWhiteIpService;
import com.tinet.cas.model.AuthWhiteIp;

public class AuthWhiteIpServiceImpl extends CasAbstractJdbcHandler implements AuthWhiteIpService {

	@Override
	public boolean checkAuth(String ip, Integer type) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();

		BeanPropertyRowMapper<AuthWhiteIp> rowMapper = new BeanPropertyRowMapper<>(AuthWhiteIp.class);

		String resultColumns = "\"id\", \"name\", \"ip\", \"comment\", \"create_time\", \"type\"";

		// 精确ip地址
		List<AuthWhiteIp> awiList = jdbcTemplate.query(" select " + resultColumns + " from auth_white_ip where ip = '"
				+ StringEscapeUtils.escapeSql(ip) + "' and type = " + type, rowMapper);
		if (awiList != null && awiList.size() > 0) {
			return true;
		} else {
			// 验证用ip
			String valiIp = ip.replace(".", ".;");
			String[] ips = valiIp.split(";");
			StringBuilder sbd = new StringBuilder();

			// ip段例如*.*.*.*
			sbd.setLength(0);
			valiIp = sbd.append("*.*.*.*").toString();
			awiList = jdbcTemplate.query(" select " + resultColumns + " from auth_white_ip where ip = '" + valiIp
					+ "' and type = " + type, rowMapper);
			if (awiList != null && awiList.size() > 0) {
				return true;
			}

			// ip段例如172.*.*.*
			sbd.setLength(0);
			valiIp = sbd.append(ips[0]).append("*.*.*").toString();
			awiList = jdbcTemplate.query(" select " + resultColumns + " from auth_white_ip where ip = '" + valiIp
					+ "' and type = " + type, rowMapper);
			if (awiList != null && awiList.size() > 0) {
				return true;
			}

			// ip段例如172.16.*.*
			sbd.setLength(0);
			valiIp = sbd.append(ips[0]).append(ips[1]).append("*.*").toString();
			awiList = jdbcTemplate.query(" select " + resultColumns + " from auth_white_ip where ip = '" + valiIp
					+ "' and type = " + type, rowMapper);
			if (awiList != null && awiList.size() > 0) {
				return true;
			}

			// ip段例如172.16.15.*
			sbd.setLength(0);
			valiIp = sbd.append(ips[0]).append(ips[1]).append(ips[2]).append("*").toString();
			awiList = jdbcTemplate.query(" select " + resultColumns + " from auth_white_ip where ip = '" + valiIp
					+ "' and type = " + type, rowMapper);
			if (awiList != null && awiList.size() > 0) {
				return true;
			}

			// ip段例如172.16.15.50-150
			List<AuthWhiteIp> list = jdbcTemplate.query(" select " + resultColumns
					+ " from auth_white_ip where ip like '%-%' and type = " + type, rowMapper);
			if (list.size() > 0) {
				for (AuthWhiteIp awiTemp : list) {
					String[] ips1 = awiTemp.getIp().replace(".", ".;").split(";");
					sbd.setLength(0);
					valiIp = sbd.append(ips[0]).append(ips[1]).append(ips[2]).toString();
					sbd.setLength(0);
					String valiip1 = sbd.append(ips1[0]).append(ips1[1]).append(ips1[2]).toString();
					if (valiip1.equals(valiIp)) {
						ips1 = ips1[3].split("-");
						if ((Integer.parseInt(ips[3]) == Integer.parseInt(ips1[0]))
								|| (Integer.parseInt(ips[3]) == Integer.parseInt(ips1[1]))
								|| (Integer.parseInt(ips[3]) > Integer.parseInt(ips1[0]) && Integer.parseInt(ips[3]) < Integer
										.parseInt(ips1[1]))) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
