package com.tbo.sn.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.neo4j.ogm.annotation.Id;

/**
 * @author tai
 * @since 3/26/18.
 */
public class ReflectionUtil
{
    public static <T> Field getIdField(Class<T> clazz)
    {
        return getAnnotatedField( clazz, Id.class );
    }

    public static <T, A extends Annotation> Field getAnnotatedField(Class<T> clazz, Class<A> annotationType)
    {
        Class tempClass = clazz;
        while ( tempClass != null && !tempClass.equals( Object.class )) {
            for ( Field field : tempClass.getDeclaredFields())
            {
                if ( field.getAnnotation( annotationType ) != null)
                {
                    return field;
                }
            }
            tempClass = tempClass.getSuperclass();
        }

        return null;
    }
}
