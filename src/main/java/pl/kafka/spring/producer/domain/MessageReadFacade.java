/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package pl.kafka.spring.producer.domain;

import static lombok.AccessLevel.PRIVATE;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.kafka.spring.producer.web.MessageReadRequest;
import pl.kafka.spring.event.MessageReadEvent;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MessageReadFacade {

    EventPublisher eventPublisher;

    public void sendEvent(final MessageReadRequest messageReadRequest) {
        final var eventValue = MessageReadEvent.fromMessageReadRequest(messageReadRequest);
        eventPublisher.send(eventValue);
    }
}
