package com.datadynamics.bigdata.api.service.dynamo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ConsumedCapacity {

    Long CapacityUnits;

    string GlobalSecondaryIndexes;

    string LocalSecondaryIndexes;

    Long ReadCapacityUnits;

    string Table;

}
