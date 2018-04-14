package com.tbo.sn.support;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Primarily used for de-serializing json representation of a {@link Page}. The {@link PageImpl} does not work with
 * Jackson because it does not have a default constructor.
 * Using the {@link PageImpl} causes error:
 * org.springframework.http.converter.HttpMessageConversionException: Type
 * definition error: [simple type, class org.springframework.data.domain.PageImpl]; nested exception is
 * com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of
 * org.springframework.data.domain.PageImpl` (no Creators, like default construct, exist): cannot deserialize from
 * Object value (no delegate- or property-based Creator)
 *
 * @author tai
 * @since 4/25/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageProxy<T>
{
    private static final long serialVersionUID = 1L;

    private List<T> content;
    private int totalPages;
    private long totalElements;
    private boolean hasNext;
    private boolean isLast;


    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public List<T> getContent()
    {
        return content;
    }

    public PageProxy<T> setContent( List<T> content )
    {
        this.content = content;
        return this;
    }

    public int getTotalPages()
    {
        return totalPages;
    }

    public PageProxy<T> setTotalPages( int totalPages )
    {
        this.totalPages = totalPages;
        return this;
    }

    public long getTotalElements()
    {
        return totalElements;
    }

    public PageProxy<T> setTotalElements( long totalElements )
    {
        this.totalElements = totalElements;
        return this;
    }

    public boolean isHasNext()
    {
        return hasNext;
    }

    public PageProxy<T> setHasNext( boolean hasNext )
    {
        this.hasNext = hasNext;
        return this;
    }

    public boolean isLast()
    {
        return isLast;
    }

    public PageProxy<T> setLast( boolean last )
    {
        isLast = last;
        return this;
    }
}
