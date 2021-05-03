package com.araujojpc.wms.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.araujojpc.wms.entities.Item;
import com.araujojpc.wms.entities.Movement;

@Embeddable
public class ItemMovementPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "movement_id")
	private Movement movement;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((movement == null) ? 0 : movement.hashCode());
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
		ItemMovementPK other = (ItemMovementPK) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (movement == null) {
			if (other.movement != null)
				return false;
		} else if (!movement.equals(other.movement))
			return false;
		return true;
	}
	
	

}
