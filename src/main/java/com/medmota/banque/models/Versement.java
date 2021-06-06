package com.medmota.banque.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "VR")
public class Versement extends Operation implements Serializable{

}
