package dev.zihasz.client.manager.relations;

import dev.zihasz.client.manager.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RelationManager extends Manager {
	private static final List<Relation> relations = new ArrayList<>();

	public RelationManager() {
		relations.add(new Relation(mc.session.getUsername(), mc.session.getPlayerID(), RelationType.FRIEND));
	}

	public static boolean isFriend(UUID uuid) {
		for (Relation relation : relations) {
			if (relation.getType() == RelationType.FRIEND && relation.getUuid().equals(uuid))
				return true;
		}
		return false;
	}
	public static boolean isEnemy(UUID uuid) {
		for (Relation relation : relations) {
			if (relation.getType() == RelationType.ENEMY && relation.getUuid().equals(uuid))
				return true;
		}
		return false;
	}

	public static Relation getRelation(UUID uuid) {
		for (Relation relation : relations) {
			if (relation.getType() == RelationType.FRIEND && relation.getUuid().equals(uuid))
				return relation;
		}
		return null;
	}
}
