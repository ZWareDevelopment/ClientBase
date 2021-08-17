package dev.zihasz.client.manager.relations;

import dev.zihasz.client.manager.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RelationManager extends Manager {
	private final List<Relation> relations = new ArrayList<>();

	/**
	 * Creates an instance of RelationManager.
	 */
	public RelationManager() {
		relations.add(new Relation(mc.session.getUsername(), mc.session.getPlayerID(), RelationType.FRIEND));
	}

	/**
	 * Adds a relation to the instance's relation list.
	 * @param relation The relation to add.
	 * @return The relation.
	 */
	public Relation addRelation(Relation relation) {
		relations.add(relation);
		return relation;
	}

	/**
	 * Creates a new friend relation and adds it to the instance's relation list.
	 * @param name The name of the relation.
	 * @param uuid The UUID of the friend.
	 * @return The created relation.
	 */
	public Relation addFriend(String name, UUID uuid) {
		return addRelation(new Relation(name, uuid, RelationType.FRIEND));
	}

	/**
	 * Creates a new enemy relation and adds it to the instance's relation list.
	 * @param name The name of the relation.
	 * @param uuid The UUID of the enemy.
	 * @return The created relation.
	 */
	public Relation addEnemy(String name, UUID uuid) {
		return addRelation(new Relation(name, uuid, RelationType.ENEMY));
	}

	/**
	 * Checks if a person is a friend or not. (UUID based)
	 * @param uuid The UUID of the person to check.
	 * @return If the persons a friend or not.
	 */
	public boolean isFriend(UUID uuid) {
		for (Relation relation : relations) {
			if (relation.getType() == RelationType.FRIEND && relation.getUuid().equals(uuid))
				return true;
		}
		return false;
	}

	/**
	 * Checks if a person is an enemy or not. (UUID based)
	 * @param uuid The UUID of the person to check.
	 * @return If the persons an enemy or not.
	 */
	public boolean isEnemy(UUID uuid) {
		for (Relation relation : relations) {
			if (relation.getType() == RelationType.ENEMY && relation.getUuid().equals(uuid))
				return true;
		}
		return false;
	}

	/**
	 * Gets a relation from the instance's list.
	 * @param uuid The UUID of the person.
	 * @return The persons relation or null if not in the list.
	 */
	public Relation getRelation(UUID uuid) {
		for (Relation relation : relations) {
			if (relation.getType() == RelationType.FRIEND && relation.getUuid().equals(uuid))
				return relation;
		}
		return null;
	}
}
