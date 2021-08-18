package dev.zihasz.client.manager.relations;

import com.mojang.authlib.GameProfile;

import java.util.UUID;

public class Relation {

	/**
	 * The name of the relation.
	 */
	private final String name;
	private final UUID uuid;
	private final RelationType type;

	public Relation(String name, UUID uuid, RelationType type) {
		this.name = name;
		this.uuid = uuid;
		this.type = type;
	}
	public Relation(String name, String uuid, RelationType type) {
		this(name, UUID.fromString(uuid), type);
	}
	public Relation(GameProfile profile, RelationType type) {
		this(profile.getName(), profile.getId(), type);
	}

	public String getName() {
		return name;
	}
	public UUID getUuid() {
		return uuid;
	}
	public RelationType getType() {
		return type;
	}

}
