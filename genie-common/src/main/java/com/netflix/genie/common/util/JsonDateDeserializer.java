/*
 *
 *  Copyright 2014 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.genie.common.util;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * Used to deserialize dates from strings in Json payloads.
 *
 * @author tgianos
 */
public class JsonDateDeserializer extends JsonDeserializer<Date> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Date deserialize(final JsonParser parser,
                            final DeserializationContext context) throws IOException {
        try {
            final String date = parser.getText();
            return JsonDateSerializer.FORMAT.parse(date);
        } catch (final ParseException e) {
            throw new IOException(e);
        }
    }
}