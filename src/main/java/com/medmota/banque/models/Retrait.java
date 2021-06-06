package com.medmota.banque.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "RE")
public class Retrait extends Operation implements Serializable{

}
