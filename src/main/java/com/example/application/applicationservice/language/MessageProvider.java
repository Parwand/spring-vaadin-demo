package com.example.application.applicationservice.language;

import com.vaadin.flow.component.UI;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Scope("singleton")
public class MessageProvider {

    public static String getMessage(String key) {
        return getMessage(key, UI.getCurrent().getLocale());
    }

    public static String getMessage(String key, Locale locale) {

        try {
            ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
            bean.setBasename("i18n/messages");
            bean.setDefaultEncoding("UTF-8");
            return bean.getMessage(key, null, locale);
        }
        catch (Exception e) {
            return "Unresolved key: " + key;
        }

    }
}

