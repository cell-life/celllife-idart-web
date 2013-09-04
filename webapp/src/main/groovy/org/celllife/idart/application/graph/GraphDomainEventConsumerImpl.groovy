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

    void systemEvent(String message) {

        try {

            def event = new JsonSlurper().parseText(message)

            Node systemNode = getOrCreateSystemNode(event.system.id.value)

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    void userEvent(String message) {

        try {

            def event = new JsonSlurper().parseText(message)

            Node userNode = getOrCreateUserNode(event.user.id.value)

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    void userSystemEvent(String message) {

        try {

            def event = new JsonSlurper().parseText(message)

            Node fromUserNode = getOrCreateUserNode(event.userSystem.fromUser.id.value)

            Node toSystemNode = getOrCreateSystemNode(event.userSystem.toSystem.id.value)

            fromUserNode.createRelationshipTo(toSystemNode, withName(event.userSystem.relationship))

        } catch (Throwable throwable) {
            LOGGER.error(throwable.message, throwable)
        }
    }

    @Override
    void handleAdministrationMethodEvent(String message) {
        println message
    }

    @Override
    void handleDefaultDosageInstructionEvent(String message) {
        println message
    }

    @Override
    void handleDispensationEvent(String message) {
        println message
    }

    @Override
    void handleEncounterEvent(String message) {
        println message
    }

    @Override
    void handleEntrySiteEvent(String message) {
        println message
    }

    @Override
    void handleFacilityEvent(String message) {
        println message
    }

    @Override
    void handleFormEvent(String message) {
        println message
    }

    @Override
    void handleIndicationEvent(String message) {
        println message
    }

    @Override
    void handleLegalOrganisationEvent(String message) {
        println message
    }

    @Override
    void handleLifeEventEvent(String message) {
        println message
    }

    @Override
    void handleMedicationEvent(String message) {
        println message
    }

    @Override
    void handleOrganisationEvent(String message) {
        println message
    }

    @Override
    void handlePartEvent(String message) {
        println message
    }

    @Override
    void handlePatientEvent(String message) {
        println message
    }

    @Override
    void handlePersonEvent(String message) {
        println message
    }

    @Override
    void handlePractitionerEvent(String message) {
        println message
    }

    @Override
    void handlePrescribedMedicationEvent(String message) {
        println message
    }

    @Override
    void handlePrescriptionEvent(String message) {
        println message
    }

    @Override
    void handleRouteOfAdministrationEvent(String message) {
        println message
    }

    @Override
    void handleSubstitutionEvent(String message) {
        println message
    }

    @Override
    void handleSubstitutionReasonEvent(String message) {
        println message
    }

    @Override
    void handleSystemEvent(String message) {
        println message
    }

    @Override
    void handleSystemFacilityEvent(String message) {
        println message
    }

    @Override
    void handleUnitOfMeasureEvent(String message) {
        println message
    }

    @Override
    void handleUnitOfMeasureTypeEvent(String message) {
        println message
    }

    @Override
    void handleUserEvent(String message) {
        println message
    }

    @Override
    void handleUserSystemEvent(String message) {
        println message
    }

    Node getOrCreateUserNode(userId) {

        UniqueFactory<Node> factory = new UniqueFactory.UniqueNodeFactory(graphDatabaseService, "users") {
            @Override
            protected void initialize(Node created, Map<String, Object> properties) {
                created.setProperty("id", properties.get("id"));
            }
        };

        factory.getOrCreate("id", userId);
    }

    Node getOrCreateSystemNode(String systemId) {

        UniqueFactory<Node> factory = new UniqueFactory.UniqueNodeFactory(graphDatabaseService, "systems") {
            @Override
            protected void initialize(Node created, Map<String, Object> properties) {
                created.setProperty("id", properties.get("id"));
            }
        };

        factory.getOrCreate("id", systemId);
    }
}
