package com.muntanji.date.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.HijrahEra;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;

@RestController
public class DateController {

    @GetMapping(path = "/g2h/{year}/{month}/{day}/{format}")
    public String convertGregorianToHijri(@PathVariable int year, @PathVariable int month,
                                          @PathVariable int day, @PathVariable String format) {
        LocalDate.of(year, month, day);
        HijrahDate islamyDate = HijrahChronology.INSTANCE.date(LocalDate.of(year, month, day));
        return islamyDate.format(getDateTimeFormatter(format));
    }

    @GetMapping(path = "/h2g/{year}/{month}/{day}/{format}")
    public String convertHijriToGregorian(@PathVariable int year, @PathVariable int month,
                                          @PathVariable int day, @PathVariable String format) {
        LocalDate.of(year, month, day);
        final HijrahDate hijrahDate = HijrahChronology.INSTANCE.date(HijrahEra.AH, year, month, day);
        return IsoChronology.INSTANCE.date(hijrahDate).format(getDateTimeFormatter(format));
    }

    private DateTimeFormatter getDateTimeFormatter(String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter;
    }
}
