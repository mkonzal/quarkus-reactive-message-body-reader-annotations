package org.acme.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import org.jboss.logging.Logger;

@Consumes("text/plain")
public class DoubleQuoteReader implements MessageBodyReader<String> {
    @Override
    public boolean isReadable(final Class<?> type, final Type genericType, final Annotation[] annotations,
            final MediaType mediaType) {
        if (type != String.class) {
            return false;
        }

        if (null == annotations) {
            Logger.getLogger(getClass()).info("annotations is null");
            return false;
        }

        for (final Annotation a : annotations) {
            Logger.getLogger(getClass()).info("Check annotation " + a.annotationType().getSimpleName());

            if (a.annotationType() == SubResource.class) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String readFrom(final Class<String> type, final Type genericType, final Annotation[] annotations,
            final MediaType mediaType, final MultivaluedMap<String, String> httpHeaders, final InputStream entityStream)
            throws IOException {
        return "\"" + new BufferedReader(new InputStreamReader(entityStream)).readLine() + "\"";
    }
}
