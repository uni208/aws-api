package com.datadynamics.bigdata.api.service.s3.model.http;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ListAllMyBucketsResult")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ListAllMyBucketsResult {

    @XmlElement(name = "Buckets")
    private List<Bucket> buckets;

    @XmlElement(name = "Owner")
    private Owner owner;

}
