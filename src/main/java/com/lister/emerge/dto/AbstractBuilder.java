package com.lister.emerge.dto;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class AbstractBuilder<T> {
    @SuppressWarnings("unchecked")
    public T build() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Field actualTypeArguments = ReflectionUtils.findField(parameterizedType.getClass(), "actualTypeArguments");
        actualTypeArguments.setAccessible(true);
        T typeArgument = null;
        try {
            Type[] typeArguments = (Type[]) actualTypeArguments.get(parameterizedType);
            typeArgument = (T) ((Class) typeArguments[0]).newInstance();
            Field[] declaredFields = this.getClass().getDeclaredFields();
            for (Field sourceField : declaredFields) {
                sourceField.setAccessible(true);
                Field destinationField = typeArgument.getClass().getDeclaredField(sourceField.getName());
                destinationField.setAccessible(true);
                destinationField.set(typeArgument, sourceField.get(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeArgument;
    }
}
