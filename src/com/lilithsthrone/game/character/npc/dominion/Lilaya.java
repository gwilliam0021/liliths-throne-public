package com.lilithsthrone.game.character.npc.dominion;

import java.util.ArrayList;
import java.util.List;

import com.lilithsthrone.game.character.NameTriplet;
import com.lilithsthrone.game.character.SexualOrientation;
import com.lilithsthrone.game.character.body.Covering;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.types.PenisType;
import com.lilithsthrone.game.character.body.valueEnums.BodySize;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.Muscle;
import com.lilithsthrone.game.character.effects.StatusEffect;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.combat.Attack;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.places.dominion.lilayashome.Lab;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.LilayasHome;

/**
 * @since 0.1.0
 * @version 0.1.82
 * @author Innoxia
 */
public class Lilaya extends NPC {

	private static final long serialVersionUID = 1L;

	// Mother's name is Lyssieth

	private AbstractClothing panties = AbstractClothingType.generateClothing(ClothingType.GROIN_PANTIES, Colour.CLOTHING_BLACK, false),
			skirt = AbstractClothingType.generateClothing(ClothingType.LEG_PENCIL_SKIRT, Colour.CLOTHING_BLACK, false),
			bra = AbstractClothingType.generateClothing(ClothingType.CHEST_FULLCUP_BRA, Colour.CLOTHING_BLACK, false),
			torso = AbstractClothingType.generateClothing(ClothingType.TORSO_SHORT_SLEEVE_SHIRT, Colour.CLOTHING_WHITE, false),
			heels = AbstractClothingType.generateClothing(ClothingType.FOOT_HEELS, Colour.CLOTHING_BLACK, false),
			glasses = AbstractClothingType.generateClothing(ClothingType.EYES_GLASSES, Colour.CLOTHING_BLACK_STEEL, false);

	public Lilaya() {
		super(new NameTriplet("Lilaya"),
				"Along with your twin cousins, your aunt Lily was the only family you'd ever known." + " Although she still exists in this world, she isn't your aunt any more, and in this reality, she's a half-demon called 'Lilaya'."
						+ " Whereas your old aunt was a researcher at the city museum, Lilaya is a privately-funded researcher of the arcane."
						+ " Due to her demonic appearance and the fact that she's the daughter of the Lilin Lyssieth, people usually regard Lilaya with a mixture of fear and respect.",
				10, Gender.F_V_B_FEMALE, RacialBody.DEMON, RaceStage.PARTIAL_FULL, new CharacterInventory(10), WorldType.LILAYAS_HOUSE_GROUND_FLOOR, LilayasHome.LILAYA_HOME_LAB, true);

		this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
		
		this.setEyeCovering(new Covering(BodyCoveringType.EYE_DEMON_COMMON, Colour.EYE_YELLOW));
		this.setHairCovering(new Covering(BodyCoveringType.HAIR_DEMON, Colour.COVERING_BLACK), true);
		this.setSkinCovering(new Covering(BodyCoveringType.DEMON_COMMON, Colour.SKIN_RED), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, Main.game.getPlayer().getCovering(BodyCoveringType.HUMAN).getPrimaryColour()), true);

		this.setMuscle(Muscle.THREE_MUSCULAR.getMedianValue());
		this.setBodySize(BodySize.TWO_AVERAGE.getMedianValue());
		
		this.setVaginaVirgin(false);
		this.setAssVirgin(false);
		this.setFaceVirgin(false);
		this.setNippleVirgin(false);
		this.setBreastSize(CupSize.E.getMeasurement());

		this.equipClothingFromNowhere(panties, true, this);
		this.equipClothingFromNowhere(bra, true, this);
		this.equipClothingFromNowhere(skirt, true, this);
		this.equipClothingFromNowhere(torso, true, this);
		this.equipClothingFromNowhere(heels, true, this);
		this.equipClothingFromNowhere(glasses, true, this);
	}

	@Override
	public String getSpeechColour() {
		return "#ff66a3";
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
		if (applyEffects) {
			setPenisType(PenisType.NONE);
		}
	}
	
	@Override
	public boolean isAbleToBeImpregnated() {
		return true;
	}
	
	public static final DialogueNodeOld AUNT_END_SEX = new DialogueNodeOld("Back to work", "Lilaya really needs to get back to work.", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public int getMinutesPassed(){
			return 15;
		}
		
		@Override
		public String getLabel() {
			if(Main.game.getLilaya().hasStatusEffect(StatusEffect.CREAMPIE_VAGINA) && !Main.game.getLilaya().isVisiblyPregnant()) {
				return "Oops...";
			} else {
				return "Back to work";
			}
		}

		@Override
		public String getDescription() {
			if(Main.game.getLilaya().hasStatusEffect(StatusEffect.CREAMPIE_VAGINA) && !Main.game.getLilaya().isVisiblyPregnant()) {
				return "Lilaya looks pretty pissed, maybe you should have pulled out...";
			} else {
				return "Lilaya really needs to get back to work.";
			}
		}

		@Override
		public String getContent() {
			if(Main.game.getLilaya().hasStatusEffect(StatusEffect.CREAMPIE_VAGINA) && !Main.game.getLilaya().isVisiblyPregnant()) {
				return "<p>"
							+ "Lilaya forcefully shoves you away from her, and with a look of disbelief on her face, looks down at the [pc.cum+] dripping out from between her thighs,"
							+ " [lilaya.speech(What the fuck?! What the fuck?! I fucking told you to pull out!)]"
						+ "</p>"
						+ "<p>"
							+ "Grabbing a tissue from a nearby desk, she starts frantically trying to clean your [pc.cum] out of her creampied pussy."
							+ " Her face has gone completely scarlet, and as the reality of what you've just done sinks in, she turns on you in a furious rage,"
							+ " [lilaya.speech(What did I say?! Huh?! I fucking told you to pull out! Do you know how fucking fertile demons are?! Oh fuck... You'd better fucking hope I don't get pregnant from this!)]"
						+ "</p>"
						+ "<p>"
							+ "Continuing to shout and curse, she grabs you by the [pc.arm] and marches you over to the lab's exit."
							+ " With one last angry cry, she throws you out, before slamming the door behind you."
							+ " You start to wonder if perhaps you made a mistake, but surely she'll have calmed down in a couple of hours..."
						+ "</p>";
				
			} else {
				return "<p>"
						+ "Lilaya leans back, letting out a very satisfied sigh as she stretches her arms up high."
						+ " You see her little demonic wings and tail following suit, and as she stretches, she grinds down into your lap."
						+ " After just a few seconds, you notice that she's starting to look completely re-invigorated and full of energy."
						+ " With one last smile and a quick kiss on your cheek, she jumps up out of the chair and darts back over to her workplace."
						+ "</p>"
						+ "<p>"
						+ UtilText.parseSpeech("Aaah! Oh wow this feels amazing! Your aura's so strong!", Main.game.getLilaya())
						+ " she blurts out, energetically gathering up papers before starting to frantically write down notes about what just happened, "
						+ UtilText.parseSpeech("Demons usually draw energy from having sex, but <b>WOW</b>!"
								+ " I mean, I'm only a half-demon and your aura made me feel like <b>this</b>!"
								+ " If you end up meeting any full demons, make sure you warn them about your aura, ok?!", Main.game.getLilaya())
						+ "</p>"
						+ "<p>"
						+ "With that, Lilaya buries herself in her work, seemingly forgetting that you're still here."
						+ " You quickly sort yourself out, and, smiling at the fact that you've given Lilaya a good time, leave her to carry on with her work."
						+ "</p>";
			}
		}
		
		@Override
		public Response getResponse(int index) {
			if (index == 1) {
				if(Main.game.getLilaya().hasStatusEffect(StatusEffect.CREAMPIE_VAGINA) && !Main.game.getLilaya().isVisiblyPregnant()) {
					return new Response("Thrown out", "Maybe it's best to leave Lilaya to cool down for a while.", Lab.LAB_EXIT){
						@Override
						public void effects() {
							if(Main.game.getLilaya().hasStatusEffect(StatusEffect.CREAMPIE_VAGINA) && !Main.game.getLilaya().isVisiblyPregnant()) {
								Main.game.getDialogueFlags().waitingOnLilayaPregnancyResults = true;
							}
							Main.game.getRose().setLocation(WorldType.LILAYAS_HOUSE_GROUND_FLOOR, LilayasHome.LILAYA_HOME_LAB, false);
						}
					};
					
				} else {
					return new Response("Continue", "Leave the lab and let Lilaya carry on with her work.", Lab.LAB_EXIT){
						@Override
						public void effects() {
							if(Main.game.getLilaya().hasStatusEffect(StatusEffect.CREAMPIE_VAGINA) && !Main.game.getLilaya().isVisiblyPregnant()) {
								Main.game.getDialogueFlags().waitingOnLilayaPregnancyResults = true;
							}
							Main.game.getRose().setLocation(WorldType.LILAYAS_HOUSE_GROUND_FLOOR, LilayasHome.LILAYA_HOME_LAB, false);
						}
					};
				}
				
			} else {
				return null;
			}
		}
	};

	// Combat (you never fight Lilaya):
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
	
	@Override
	public String getLostVirginityDescriptor() {
		return "as she performed some extra \"tests\" on you";
	}
	
	
	// Dirty talk:

	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to no ongoing penetration.
	 */
	public String getDirtyTalkNoPenetration(boolean isPlayerDom){
		List<String> speech = new ArrayList<>();

		speech.add("Fuck, why do demons always have to feel so horny?! All I ever think about is fucking you or Rose!");
		speech.add("Fuck, I need this so bad! And I only fucked Rose half an hour ago as well...");
		speech.add("I wonder if you ever did this with your real aunt?");
		speech.add("Wait, you still see me as your aunt, right? I guess I can go along with that...");
		
		return speech.get(Util.random.nextInt(speech.size()));
	}
	
	/**
	 * @return A <b>non-formatted</b> String of this NPCs speech related to no ongoing penetration.
	 */
	public String getPlayerDirtyTalkNoPenetration(boolean isPlayerDom){
		List<String> speech = new ArrayList<>();
		
		speech.add("Ah yes! I've wanted to fuck you for so long Lily -I mean- Lilaya!");
		speech.add("You're so hot!");
		speech.add("I've wanted this for so long...");
		
		return speech.get(Util.random.nextInt(speech.size()));
	}

}