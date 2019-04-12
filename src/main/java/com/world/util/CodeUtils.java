package com.world.util;

import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

public class CodeUtils {

    private CodeUtils() {
    }

    public static void copyProperties(Object source, Object target) {
        try {
            BeanUtils.copyProperties(source, target);
        } catch (BeansException bex) {
            log("Erro ao tentar copiar os atributos de " + source.toString() + " para " + target.toString(), source.getClass());
            log(bex.getMessage(), source.getClass());
        }
    }

    public static void log(String message, Object clazz) {
        Logger.getLogger(clazz.getClass().getName()).info(message);
    }
}
