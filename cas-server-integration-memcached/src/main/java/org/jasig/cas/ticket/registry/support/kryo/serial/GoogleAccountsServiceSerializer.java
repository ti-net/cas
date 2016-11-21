/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.ticket.registry.support.kryo.serial;

import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.esotericsoftware.kryo.Kryo;
import org.jasig.cas.support.saml.authentication.principal.GoogleAccountsService;
import org.jasig.cas.ticket.registry.support.kryo.FieldHelper;

/**
 * Serializer for {@link GoogleAccountsService}.
 *
 * @author Marvin S. Addison
 */
public final class GoogleAccountsServiceSerializer extends AbstractWebApplicationServiceSerializer<GoogleAccountsService> {

    private static final Constructor CONSTRUCTOR;

    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    private final String alternateUsername;

    static {
        try {
            CONSTRUCTOR = GoogleAccountsService.class.getDeclaredConstructor(
                    String.class,
                    String.class,
                    String.class,
                    String.class,
                    String.class,
                    PrivateKey.class,
                    PublicKey.class,
                    String.class);
            CONSTRUCTOR.setAccessible(true);
        } catch (final NoSuchMethodException e) {
            throw new IllegalStateException("Expected constructor signature not found.", e);
        }
    }

    public GoogleAccountsServiceSerializer(
            final Kryo kryo,
            final FieldHelper helper,
            final PublicKey publicKey,
            final PrivateKey privateKey,
            final String alternateUsername) {

        super(kryo, helper);
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.alternateUsername = alternateUsername;
    }

    public void write(final ByteBuffer buffer, final GoogleAccountsService service) {
        super.write(buffer, service);
        kryo.writeObject(buffer, fieldHelper.getFieldValue(service, "requestId"));
        kryo.writeObject(buffer, fieldHelper.getFieldValue(service, "relayState"));
    }

    protected GoogleAccountsService createService(
            final ByteBuffer buffer,
            final String id,
            final String originalUrl,
            final String artifactId) {

        final String requestId = kryo.readObject(buffer, String.class);
        final String relayState = kryo.readObject(buffer, String.class);
        try {
            final GoogleAccountsService service = (GoogleAccountsService) CONSTRUCTOR.newInstance(
                    id,
                    originalUrl,
                    artifactId,
                    relayState,
                    requestId,
                    privateKey,
                    publicKey,
                    alternateUsername);
            return service;
        } catch (final Exception e) {
            throw new IllegalStateException("Error creating SamlService", e);
        }
    }
}
