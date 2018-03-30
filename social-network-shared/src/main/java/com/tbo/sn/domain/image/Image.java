package com.tbo.sn.domain.image;

import com.tbo.sn.domain.Entity;

/**
 * @author tai
 * @since 3/17/18.
 */
public class Image extends Entity
{
    private byte[] content;
    private String fileName;

    public byte[] getContent()
    {
        return content;
    }

    public Image setContent( byte[] content )
    {
        this.content = content;
        return this;
    }

    public String getFileName()
    {
        return fileName;
    }

    public Image setFileName( String fileName )
    {
        this.fileName = fileName;
        return this;
    }
}
