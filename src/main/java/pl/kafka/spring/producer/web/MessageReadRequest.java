/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package pl.kafka.spring.producer.web;

import java.util.UUID;
import static lombok.AccessLevel.PRIVATE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MessageReadRequest {

    UUID userId;
    String device;
    String interactionSource;
    String interactionType;
}
