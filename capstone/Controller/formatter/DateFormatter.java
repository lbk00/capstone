package com.example.capstone.Controller.formatter;

import org.hibernate.engine.jdbc.internal.Formatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return null;
    }
}
