package org.celllife.idart.framework.persistence

import org.hibernate.HibernateException
import org.hibernate.engine.spi.SessionImplementor
import org.hibernate.internal.util.compare.EqualsHelper
import org.hibernate.usertype.ParameterizedType
import org.hibernate.usertype.UserType
import org.jasypt.encryption.pbe.PBEStringEncryptor
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor
import org.jasypt.exceptions.EncryptionInitializationException
import org.jasypt.hibernate4.encryptor.HibernatePBEEncryptorRegistry
import org.jasypt.hibernate4.type.ParameterNaming

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Types

/**
 * Base class for <b>Hibernate 3</b> <tt>UserType</tt>s to store
 * values as encrypted strings.
 *
 * @author Daniel Fern&aacute;ndez
 * @author Iv&aacute;n Garc&iacute;a S&aacute;inz-Aja
 * @since 1.2
 */
class EncryptedClobType implements UserType, ParameterizedType {

    static final int sqlType = Types.CLOB
    static final int[] sqlTypes = [ sqlType ]

    private boolean initialized = false
    private boolean useEncryptorName = false

    private String encryptorName = null
    private String algorithm = null
    private String providerName = null
    private String password = null
    private Integer keyObtentionIterations = null
    private String stringOutputType = null

    protected PBEStringEncryptor encryptor = null

    /**
     * Converts given String to its Object form.
     *
     * @param string the string value
     * @return the object form of the passed String
     */
    protected Object convertToObject(final String string) {
        return string
    }

    /**
     * Converts given Object to its String form.
     *
     * @param object the object value
     * @return the string form of the passes Object
     */
    protected String convertToString(final Object object) {
        return object == null ? null : object.toString()
    }

    public final int[] sqlTypes() {
        return sqlTypes.clone()
    }


    public Class returnedClass() {
        return String.class
    }


    public final boolean equals(final Object x, final Object y)
    throws HibernateException {
        return EqualsHelper.equals(x, y)
    }


    public final Object deepCopy(final Object value)
    throws HibernateException {
        return value
    }


    public final Object assemble(final Serializable cached, final Object owner)
    throws HibernateException {
        if (cached == null) {
            return null
        }
        return deepCopy(cached)
    }


    public final Serializable disassemble(final Object value)
    throws HibernateException {
        if (value == null) {
            return null
        }
        return (Serializable) deepCopy(value)
    }


    public final boolean isMutable() {
        return false
    }


    public final int hashCode(final Object x)
    throws HibernateException {
        return x.hashCode()
    }

    public final Object replace(final Object original, final Object target, final Object owner)
    throws HibernateException {
        return original
    }


    public final Object nullSafeGet(final ResultSet rs, final String[] names, SessionImplementor session, final Object owner)
    throws HibernateException, SQLException {
        checkInitialization()
        final String message = rs.getString(names[0])
        return rs.wasNull() ? null : convertToObject(this.encryptor.decrypt(message))
    }


    public final void nullSafeSet(final PreparedStatement st, final Object value, final int index, SessionImplementor session)
    throws HibernateException, SQLException {
        checkInitialization()
        if (value == null) {
            st.setNull(index, sqlType)
        } else {
            st.setString(index, this.encryptor.encrypt(convertToString(value)))
        }
    }


    public synchronized void setParameterValues(final Properties parameters) {

        final String paramEncryptorName = parameters.getProperty(ParameterNaming.ENCRYPTOR_NAME)
        final String paramAlgorithm = parameters.getProperty(ParameterNaming.ALGORITHM)
        final String paramProviderName = parameters.getProperty(ParameterNaming.PROVIDER_NAME)
        final String paramPassword = parameters.getProperty(ParameterNaming.PASSWORD)
        final String paramKeyObtentionIterations = parameters.getProperty(ParameterNaming.KEY_OBTENTION_ITERATIONS)
        final String paramStringOutputType = parameters.getProperty(ParameterNaming.STRING_OUTPUT_TYPE)

        this.useEncryptorName = false
        if (paramEncryptorName != null) {

            if ((paramAlgorithm != null) ||
                    (paramPassword != null) ||
                    (paramKeyObtentionIterations != null)) {

                throw new EncryptionInitializationException(
                        "If \"" + ParameterNaming.ENCRYPTOR_NAME +
                                "\" is specified, none of \"" +
                                ParameterNaming.ALGORITHM + "\", \"" +
                                ParameterNaming.PASSWORD + "\" or \"" +
                                ParameterNaming.KEY_OBTENTION_ITERATIONS + "\" " +
                                "can be specified")

            }
            this.encryptorName = paramEncryptorName
            this.useEncryptorName = true

        } else if ((paramPassword != null)) {

            this.password = paramPassword

            if (paramAlgorithm != null) {
                this.algorithm = paramAlgorithm
            }

            if (paramProviderName != null) {
                this.providerName = paramProviderName
            }

            if (paramKeyObtentionIterations != null) {

                try {
                    this.keyObtentionIterations = Integer.parseInt(paramKeyObtentionIterations)
                } catch (NumberFormatException e) {
                    throw new EncryptionInitializationException(
                            "Value specified for \"" +
                                    ParameterNaming.KEY_OBTENTION_ITERATIONS +
                                    "\" is not a valid integer")
                }

            }

            if (paramStringOutputType != null) {
                this.stringOutputType = paramStringOutputType
            }

        } else {

            throw new EncryptionInitializationException(
                    "If \"" + ParameterNaming.ENCRYPTOR_NAME +
                            "\" is not specified, then \"" +
                            ParameterNaming.PASSWORD + "\" (and optionally \"" +
                            ParameterNaming.ALGORITHM + "\" and \"" +
                            ParameterNaming.KEY_OBTENTION_ITERATIONS + "\") " +
                            "must be specified")

        }
    }


    protected synchronized final void checkInitialization() {

        if (!this.initialized) {

            if (this.useEncryptorName) {

                final HibernatePBEEncryptorRegistry registry = HibernatePBEEncryptorRegistry.getInstance()
                final PBEStringEncryptor pbeEncryptor = registry.getPBEStringEncryptor(this.encryptorName)
                if (pbeEncryptor == null) {
                    throw new EncryptionInitializationException(
                            "No string encryptor registered for hibernate " +
                                    "with name \"" + this.encryptorName + "\"")
                }
                this.encryptor = pbeEncryptor

            } else {

                final StandardPBEStringEncryptor newEncryptor =
                    new StandardPBEStringEncryptor()

                newEncryptor.setPassword(this.password)

                if (this.algorithm != null) {
                    newEncryptor.setAlgorithm(this.algorithm)
                }

                if (this.providerName != null) {
                    newEncryptor.setProviderName(this.providerName)
                }

                if (this.keyObtentionIterations != null) {
                    newEncryptor.setKeyObtentionIterations(this.keyObtentionIterations)
                }

                if (this.stringOutputType != null) {
                    newEncryptor.setStringOutputType(this.stringOutputType)
                }

                newEncryptor.initialize()

                this.encryptor = newEncryptor

            }

            this.initialized = true
        }
    }
}