package com.mini.common.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 解决long类型转json时 丢失精度问题, 序列换成json时,将所有的long变成string, <br>
 * 因为js中得数字类型不能包含所有的java long值
 * @author czk
 * @date 2018-01-29
 */
@Configuration
public class LongToStringMapper extends ObjectMapper {

	private static final long serialVersionUID = 5449243781669160107L;

	public LongToStringMapper() {
		this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
	}
}