package org.celllife.idart.application.graph

import groovy.json.JsonSlurper
import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Node
import org.neo4j.graphdb.index.Index
import org.neo4j.graphdb.index.IndexHits
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.neo4j.graphdb.DynamicRelationshipType.withName

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-05
 * Time: 19h39
 */
@Service("graphDomainEventConsumer") class GraphDomainEventConsumerImpl implements GraphDomainEventConsumer {

    static final Logger LOGGER = LoggerFactory.getLogger(GraphDomainEventConsumerImpl)

    @Autowired GraphDatabaseService graphDatabaseService

    @Override
    void systemSaved(String message) {

        try {

            def system = new JsonSlurper().parseText(message)

            Node systemNode = createSystemNode(system.identifier.value)

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    @Override
    void userSaved(String message) {

        try {

            def user = new JsonSlurper().parseText(message)

            Node userNode = createUserNode(user.identifier.value)

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    @Override
    void userSystemSaved(String message) {

        try {

            def userSystem = new JsonSlurper().parseText(message)

            Node fromUserNode = createUserNode(userSystem.fromUser.identifier.value)

            Node toSystemNode = createSystemNode(userSystem.toSystem.identifier.value)

            fromUserNode.createRelationshipTo(toSystemNode, withName(userSystem.relationship))

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    Node createUserNode(userIdentifier) {

        Index<Node> userIndex = graphDatabaseService.index().forNodes("users")
        IndexHits<Node> users = userIndex.get("identifier", userIdentifier)

        try {
            if (users.size() != 0) {
                return users.single
            }
        } finally {
            users.close()
        }

        def userNode = graphDatabaseService.createNode()

        userNode.setProperty("identifier", userIdentifier)
        userIndex.add(userNode, "identifier", userIdentifier)

        return userNode
    }

    Node createSystemNode(systemIdentifier) {

        Index<Node> systemIndex = graphDatabaseService.index().forNodes("systems")
        IndexHits<Node> systems = systemIndex.get("identifier", systemIdentifier)

        try {
            if (systems.size() != 0) {
                return systems.single
            }
        } finally {
            systems.close()
        }

        def systemNode = graphDatabaseService.createNode()

        systemNode.setProperty("identifier", systemIdentifier)
        systemIndex.add(systemNode, "identifier", systemIdentifier)

        return systemNode
    }
}
