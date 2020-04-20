package com.synechron.insurancecompany.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.synechron.insurancecompany.exceptions.CustomException;

public class DateDeSerializer extends StdDeserializer<Date> {

	private static final long serialVersionUID = 1L;

	public DateDeSerializer() {
        super(Date.class);
    }

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) {
		String value = "";
		try {
			value = p.readValueAs(String.class);
            return new SimpleDateFormat("yyyy-MM-dd").parse(value);
        } catch ( Exception e) {
//        	System.out.println(e.getMessage());
            throw new CustomException("Invalid date "+value+". Valid format is YYYY-MM-DD");
        }
	}

}
