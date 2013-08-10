package org.celllife.idart.application.graph

import groovy.json.JsonSlurper
import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Node
import org.neo4j.graphdb.index.UniqueFactory
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

            Node systemNode = getOrCreateSystemNode(system.identifier.value)

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    @Override
    void userSaved(String message) {

        try {

            def user = new JsonSlurper().parseText(message)

            Node userNode = getOrCreateUserNode(user.identifier.value)

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    @Override
    void userSystemSaved(String message) {

        try {

            def userSystem = new JsonSlurper().parseText(message)

            Node fromUserNode = getOrCreateUserNode(userSystem.fromUser.identifier.value)

            Node toSystemNode = getOrCreateSystemNode(userSystem.toSystem.identifier.value)

            fromUserNode.createRelationshipTo(toSystemNode, withName(userSystem.relationship))

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    Node getOrCreateUserNode(userIdentifier) {

        UniqueFactory<Node> factory = new UniqueFactory.UniqueNodeFactory(graphDatabaseService, "users") {
            @Override
            protected void initialize(Node created, Map<String, Object> properties) {
                created.setProperty("identifier", properties.get("identifier"));
            }
        };

        factory.getOrCreate("identifier", userIdentifier);
    }

    Node getOrCreateSystemNode(String systemIdentifier) {

        UniqueFactory<Node> factory = new UniqueFactory.UniqueNodeFactory(graphDatabaseService, "systems") {
            @Override
            protected void initialize(Node created, Map<String, Object> properties) {
                created.setProperty("identifier", properties.get("identifier"));
            }
        };

        factory.getOrCreate("identifier", systemIdentifier);
    }
}
