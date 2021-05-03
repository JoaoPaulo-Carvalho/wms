package com.araujojpc.wms.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.araujojpc.wms.entities.pk.ItemMovementPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_item_movement")
public class ItemMovement implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemMovementPK id = new ItemMovementPK();

	private Double quantity;

	public ItemMovement() {
	}

	public ItemMovement(Movement movement, Item item, Double quantity) {
		super();
		id.setMovement(movement);
		id.setItem(item);
		this.quantity = quantity;
	}

	@JsonIgnore
	public Movement getMovement() {
		return id.getMovement();
	}

	public void setMovement(Movement movement) {
		id.setMovement(movement);
	}

	public Item getItem() {
		return id.getItem();
	}

	public void setItem(Item item) {
		id.setItem(item);
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMovement other = (ItemMovement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
