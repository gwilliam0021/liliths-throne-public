package com.lilithsthrone.game.character.npc.generic;

import com.lilithsthrone.game.character.NameTriplet;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.combat.Attack;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.Jungle;

/**
 * @since 0.1.79
 * @version 0.1.79
 * @author Innoxia
 */
public class GenericAndrogynousNPC extends NPC {

	private static final long serialVersionUID = 1L;

	public GenericAndrogynousNPC() {
		super(new NameTriplet("Androgynous"), "Generic androgynous.",
				1, Gender.N_P_V_HERMAPHRODITE, RacialBody.HUMAN, RaceStage.HUMAN,
				new CharacterInventory(0), WorldType.JUNGLE, Jungle.JUNGLE_CLUB, true); //TODO move to null tile
		
		this.setFemininity(50);
	}
	
	@Override
	public void changeFurryLevel(){
	}
	
	@Override
	public DialogueNodeOld getEncounterDialogue() {
		return null;
	}

	@Override
	public void endSex(boolean applyEffects) {
	}
	
	@Override
	public String getCombatDescription() {
		return null;
	}
	@Override
	public String getAttackDescription(Attack attackType, boolean isHit) {
		return null;
	}
	@Override
	public Response endCombat(boolean applyEffects, boolean victory) {
		return null;
	}
	@Override
	public Attack attackType() {
		return null;
	}
	@Override
	public int getExperienceFromVictory() {
		return 0;
	}

}