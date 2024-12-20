/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package pl.kafka.spring.event;

import static java.util.Objects.requireNonNull;
import java.util.UUID;
import lombok.Value;
import pl.kafka.spring.producer.domain.InternalEvent;
import pl.kafka.spring.producer.web.MessageReadRequest;

@Value
public class MessageReadEvent implements InternalEvent {
    UUID eventId;
    UUID userId;
    String device;
    String interactionSource;
    String interactionType;

    public static MessageReadEvent fromMessageReadRequest(final MessageReadRequest request) {
        requireNonNull(request.getUserId());

        return new MessageReadEvent(UUID.randomUUID(),
                request.getUserId(),
                request.getDevice(),
                request.getInteractionSource(),
                request.getInteractionType());
    }

    @Override
    public String getKey() {
        return userId.toString();
    }
}
