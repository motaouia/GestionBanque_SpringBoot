package com.mota.banque.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RE")
public class Retrait extends Operation implements Serializable{

}
