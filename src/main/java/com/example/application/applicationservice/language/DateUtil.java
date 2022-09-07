package com.example.application.applicationservice.language;

import com.vaadin.flow.component.UI;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * Get the country format value of date
     *
     * @return the country format value of date
     */
    public static String getDateAsCountryFormat(Date date) {
        return new SimpleDateFormat(MessageProvider.getMessage("language.dateUtil.getDateAsCountryFormat", UI.getCurrent().getLocale())).format(date);
    }
}
