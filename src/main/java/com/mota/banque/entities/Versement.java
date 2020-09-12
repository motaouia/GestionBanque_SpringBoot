package com.mota.banque.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VE")
public class Versement extends Operation implements Serializable{

}
