package org.celllife.idart.framework.atomikos

import com.atomikos.icatch.jta.TransactionManagerImp
import com.atomikos.icatch.jta.UserTransactionImp
import com.atomikos.logging.Logger
import com.atomikos.logging.LoggerFactory
import org.hibernate.service.jta.platform.internal.AbstractJtaPlatform

import javax.transaction.TransactionManager
import javax.transaction.UserTransaction

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-05
 * Time: 20h51
 */
class AtomikosJtaPlatform extends AbstractJtaPlatform {

    private static final Logger LOGGER = LoggerFactory.createLogger(AtomikosJtaPlatform.class);

    @Override
    protected TransactionManager locateTransactionManager() {
        return TransactionManagerImp.getTransactionManager ()
    }

    @Override
    protected UserTransaction locateUserTransaction() {
        return new UserTransactionImp()
    }
}
