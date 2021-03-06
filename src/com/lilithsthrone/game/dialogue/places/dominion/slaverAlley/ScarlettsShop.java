package com.lilithsthrone.game.dialogue.places.dominion.slaverAlley;

import com.lilithsthrone.game.character.Quest;
import com.lilithsthrone.game.character.QuestLine;
import com.lilithsthrone.game.character.attributes.AffectionLevel;
import com.lilithsthrone.game.character.attributes.CorruptionLevel;
import com.lilithsthrone.game.character.attributes.ObedienceLevel;
import com.lilithsthrone.game.character.effects.Fetish;
import com.lilithsthrone.game.character.npc.dominion.Scarlett;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.MiscDialogue;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.ListValue;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.HarpyNests;
import com.lilithsthrone.world.places.SlaverAlley;

/**
 * @since 0.1.83
 * @version 0.1.83
 * @author Innoxia
 */
public class ScarlettsShop {
	
	public static final DialogueNodeOld SCARLETTS_SHOP_EXTERIOR = new DialogueNodeOld("Scarlett's shop", ".", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
					+ "Tucked away in one corner of Slaver Alley, you see a shop that's quite unlike all the others."
					+ " Although the words 'Scarlett's Shop; open for business' are painted in fancy gold lettering above the door, the large glass windows don't show any sign of there being any slaves for sale."
					+ " While the areas in front of all of the other shops in Slaver Alley are filled with advertisement boards and platforms upon which to display their goods,"
						+ " the area in front of 'Scarlett's Shop' is noticeably barren; yet further proof that this particular store must have fallen upon hard times."
				+ "</p>"
				+ (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_E_REPORT_TO_ALEXA
					?"<p>"
						+ "You haven't gone to report to Scarlett's matriarch, Alexa, yet, and you don't really want to have to talk to Scarlett until you've done as she's asked."
						+ " Scarlett said that you can find Alexa up in the Harpy Nests, so you'll need to go there report to her before stepping foot inside this shop again."
					+ "</p>"
					:"");
		}

		@Override
		public Response getResponse(int index) {
			if (index == 1) {
				if(Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_E_REPORT_TO_ALEXA) {
					return new Response("Enter", "You should go and find Alexa before entering Scarlett's Shop again.", null);
					
				} else {
					return new Response("Enter", "Enter the shop.", SCARLETTS_SHOP);
				}

			}else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld SCARLETTS_SHOP = new DialogueNodeOld("Scarlett's shop", ".", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_D_SLAVERY) {
				return "<p>"
						+ "Pushing open the door, you find that the shop's interior is just as bare as you feared."
						+ " There isn't a single slave for sale in sight, and the only sign of life is a rather defeated-looking harpy slouched down at the shop's front desk."
					+ "</p>"
					+ "<p>"
						+ "The harpy, who you assume to be Scarlett, looks up at you as you enter the shop, and with an annoyed huff, she shouts out, "
						+ "[scarlett.speech(If you aren't here to donate any slaves, then you'd better turn around and fuck right off! I'm not in the mood to deal with any fucking morons like you today.)]"
					+ "</p>"
					+ "<p>"
						+ "Apparently this extremely rude harpy is the person that you need to deal with, and, letting out an annoyed sigh, you wonder if you should ask about Arthur now, or come back at another time."
					+ "</p>";
				
			} else {
				return "<p>"
							+ "Pushing open the door, you find that the shop's interior is just as bare as you feared."
							+ " There isn't a single slave for sale in sight, and the only sign of life is a rather defeated-looking harpy slouched down at the shop's front desk."
						+ "</p>"
						+ "<p>"
							+ "The harpy, who you assume to be Scarlett, looks up at you as you enter the shop, and with an annoyed huff, she shouts out, "
							+ "[scarlett.speech(If you aren't here to donate any slaves, then you'd better turn around and fuck right off! I'm not in the mood to deal with any fucking morons like you today.)]"
						+ "</p>"
						+ "<p>"
							+ "You're quite taken aback at Scarlett's rude words, and, deciding that it's probably best not to get involved with someone like that, you turn around and head for the exit."
						+ "</p>";
			}
		}

		@Override
		public Response getResponse(int index) {
			if (index == 1) {
				if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_D_SLAVERY) {
					return new Response("Ask for Arthur", "Ask Scarlett if she's got a slave named Arthur for sale.", SCARLETT_IS_A_BITCH);

				}else {
					return null;
				}
				
			} else if (index == 0) {
				return new Response("Leave", "Exit the shop.", SCARLETTS_SHOP_EXTERIOR);
				
			} else {
				return null;
			}

		}
	};
	
	public static final DialogueNodeOld SCARLETT_IS_A_BITCH = new DialogueNodeOld("Scarlett's shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
						+ "Letting out a defeated sigh as you wonder why everything has to be so difficult, you walk towards the front desk where Scarlett is sitting."
					+ "</p>"
					+ "<p>"
						+ "[scarlett.speech(Didn't I tell you to fuck off already?)]"
						+ " the rude harpy calls out, sitting up in her chair as you approach."
					+ "</p>"
					+ "<p>"
						+ "[pc.speech(Look, I just need to know if you've got a slave for sale going by the name of 'Arthur', ok?)]"
					+ "</p>"
					+ "<p>"
						+ "As you mention the name 'Arthur', Scarlett stands up from behind her desk, and her cheeks flush red as she starts to shout and curse,"
						+ " [scarlett.speech(If I hear that fucking name one more time, I swear I'm going to kill someone!"
						+ " Are you working with them?! Huh?! Those fucking cunts who fucked me over?! You've got five fucking seconds to start explaining!)]"
					+ "</p>"
					+ "<p>"
						+ "Despite her foul language and aggressive posturing, you find Scarlett's little outburst to be more embarrassing rather than anything else."
						+ " She clearly lacks the physical strength required in order to follow through on any of her threats, so it's more out of a desire to calm her down rather than due to feeling intimidated that you start to answer her,"
						+ " [pc.speech(Calm down, I'm not working with 'them', whoever they might be. I'm just a friend of Arthur's who's been trying to track him down."
						+ " I found out from a helpful enforcer that he was meant to have been given to you."
						+ " If you're still in possession of him, I'd like to see if I can buy his freedom, and if not, then could you [style.italics(please)] just tell me who you sold him to?)]"
					+ "</p>"
					+ "<p>"
						+ "[scarlett.speech(Huh,)]"
						+ " Scarlett huffs as she sits back down, "
						+ "[scarlett.speech(so I guess you really are as stupid as you look. Can't you see that I've got no slaves for sale? I'm fucking finished. And it's all thanks to that business with Arthur...)]"
					+ "</p>"
					+ "<p>"
						+ "Rolling your eyes at the annoying harpy's reaction, you don't get any time to respond before she continues,"
						+ " [scarlett.speech(There might be a way for both of us to profit here though."
						+ " Yeah, I know what happened to Arthur, [style.italics(and)] where he's gone, but I'm also not going to tell a fucking idiot like you anything about it."
						+ " Not without helping me out first, at least.)]"
					+ "</p>"
					+ "<p>"
						+ "Wondering just how many different people you're going to have to deal with before finally finding Arthur, you sigh,"
						+ " [pc.speech(And what is it I'd need to do?)]"
					+ "</p>"
					+ "<p>"
						+ "[scarlett.speech(Even a clueless moron like you can see that this business is a complete failure,)]"
						+ " Scarlett grumbles as she leans back in her chair, "
						+ "[scarlett.speech(and my matriarch is [style.italics(not)] going to be happy when she finds out."
						+ " If you want to find out what happened to your stupid little friend, you're going to go up to the Harpy Nests, find a matriarch called 'Alexa',"
							+ " tell her that my business is bust, and take whatever punishment she'll decide upon on my behalf.)]"
					+ "</p>"
					+ "<p>"
						+ "You realise that if you ever want to find out what happened to Arthur, you're going to have to agree to Scarlett's demands, even if you don't actually plan on taking any punishment on her behalf."
					+ "</p>";
		}

		@Override
		public Response getResponse(int index) {
			if (index == 1) {
				return new Response("Agree", "Agree to help Scarlett.", SCARLETT_IS_A_SUPER_BITCH) {
					@Override
					public void effects() {
						Main.game.getTextEndStringBuilder().append(Main.game.getPlayer().incrementQuest(QuestLine.MAIN));
					}
				};

			}else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld SCARLETT_IS_A_SUPER_BITCH = new DialogueNodeOld("Scarlett's shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
						+ "Deciding to just agree with the insufferable harpy for now, you respond,"
						+ " [pc.speech(Fine, I'll do it, but you'd better keep your end of the bargain here. When I get back, you're going to tell me exactly what's happened to Arthur, ok?)]"
					+ "</p>"
					+ "<p>"
						+ "[scarlett.speech(Just fuck off and do it already!"
						+ " Fuck, you're a real asshole to try and talk to, you know?!)]"
						+ " Scarlett shouts, looking just as infuriated as you feel right now, "
						+ "[scarlett.speech(Don't bother coming back here until you've taken Alexa's punishment, ok?"
						+ " And don't let her go easy on you, I'm gonna enjoy hearing what she did to you when you get back!)]"
					+ "</p>"
					+ "<p>"
						+ "Not wanting to waste any more time talking to her, you turn your back on Scarlett and walk out of the shop."
						+ " As the door swings shut behind you, you find yourself wondering if you've ever met anyone as annoying as that harpy is."
						+ " You seriously hope that this matriarch, 'Alexa', is nothing like Scarlett, and as you set off in the direction of the Harpy Nests, you wonder how many more hurdles you'll be presented with before finally finding Arthur..."
					+ "</p>";
		}

		@Override
		public Response getResponse(int index) {
			if (index == 0) {
				return new Response("Leave", "Exit the shop.", SCARLETTS_SHOP_EXTERIOR);
				
			} else {
				return null;
			}
		}
	};
	
	
	public static final DialogueNodeOld ALEXAS_SHOP_EXTERIOR = new DialogueNodeOld("Alexa's Pet Shop", ".", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_F_SCARLETTS_FATE) {
				return  "<p>"
							+ "Once again, you find yourself standing before Scarlett's shop, but this time, you notice that the surrounding area is a lot quieter than usual."
							+ " As you walk towards the front entrance, you pass a couple of wolf-girls as they hurry past the shop, and you can't help but overhear a snippet of their whispered conversation,"
							+ " [npcFemale.speech(...I'm telling you, it's <i>the</i> Alexa in there! Hurry up, before she sees us!)]"
						+ "</p>"
						+ "<p>"
							+ "Stepping forwards, you see that the fancy gold lettering reading 'Scarlett's shop; open for business' has been roughly crossed out in red paint, and beneath,"
								+ " in the same scarlet hue, you read the new words 'Alexa's pet shop'."
						+ "</p>"
						+ "<p>"
							+ " Curious to find out what's become of Scarlett, you wonder if you should enter the shop now, or come back later."
						+ "</p>";
				
			} else if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_G_SLAVERY) {
				return  "<p>"
							+ "Once again, you find yourself standing in the quiet area in front of Scarlett's old shop."
							+ " Stepping forwards, you see that the fancy gold lettering reading 'Scarlett's shop; open for business' has been roughly crossed out in red paint, and beneath,"
								+ " in the same scarlet hue, you read the words 'Alexa's Pet Shop'."
						+ "</p>"
						+ "<p>"
							+ "You wonder if you should enter Alexa's Pet Shop now, or come back later."
						+ "</p>";
				
			} else {
				return  "<p>"
						+ "Once again, you find yourself standing in front of Alexa's Pet Shop."
						+ " The sign that once read 'Scarlett's shop; open for business' has been totally erased, and in its place, the words 'Alexa's Pet Shop' have been written in fancy gold lettering."
						+ " The area around the beautiful harpy's shop is far busier than it ever was when Scarlett was in charge."
					+ "</p>"
					+ "<p>"
						+ "You wonder if you should enter Alexa's Pet Shop now, or come back later."
					+ "</p>";
		}
		}

		@Override
		public Response getResponse(int index) {
			if (index == 1) {
				if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_F_SCARLETTS_FATE) {
					return new Response("Enter", "Enter the shop.", ALEXAS_SHOP) {
						@Override
						public void effects() {
							Main.game.getAlexa().addSlave(Main.game.getScarlett());
							Main.game.getScarlett().setObedience(ObedienceLevel.POSITIVE_TWO_OBEDIENT.getMedianValue());
							Main.game.getScarlett().resetInventory();
							AbstractClothing collar = AbstractClothingType.generateClothing(ClothingType.NECK_SLAVE_COLLAR, Colour.CLOTHING_BLACK_STEEL, false);
							collar.setSealed(true);
							Main.game.getScarlett().equipClothingFromNowhere(collar, true, Main.game.getAlexa());
							Main.game.getScarlett().equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.BDSM_BALLGAG, Colour.CLOTHING_PINK, false), true, Main.game.getAlexa());
							Main.game.getScarlett().equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.BDSM_WRIST_RESTRAINTS, Colour.CLOTHING_PINK, false), true, Main.game.getAlexa());
						}
					};
					
				} else {
					return new Response("Enter", "Enter the shop.", ALEXAS_SHOP);
				}

			}else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld ALEXAS_SHOP = new DialogueNodeOld("Alexa's Pet Shop", ".", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_F_SCARLETTS_FATE) {
				return "<p>"
							+ "Pushing open the front door, you're greeted by the familiar, beautiful figure of Alexa sitting down behind the shop's counter."
							+ " She throws you a delighted smile as you step inside the shop,"
							+ " [alexa.speech(Ah, it's you again! Please, do come in!)]"
						+ "</p>"
						+ "<p>"
							+ "Doing as the harpy says, you walk up to the front desk, where you get right to business,"
							+ " [pc.speech(Hello Alexa. Is Scarlett still around here somewhere? I really need to talk to her.)]"
						+ "</p>"
						+ "<p>"
							+ "Alexa grins up at you, before turning her head to one side and calling out,"
							+ " [alexa.speech(Come, pet! This nice [pc.race] is asking after you!)]"
						+ "</p>"
						+ "<p>"
							+ "[scarlett.speechNoEffects(M-Mrph...)]"
						+ "</p>"
						+ "<p>"
							+ "You hear a quiet, muffled groan come from one side of the shop, and, turning to look in the direction Alexa is now facing,"
								+ " you see the submissive form of Scarlett kneeling beneath one of the many empty platforms that line the edge of the room."
							+ " Your eyes open wide as you watch her obey her matriarch;"
								+ " obediently crawling out from her refuge, you see that she's been stripped naked and forced to wear a pair of wrist restraints, a ball gag, and, most shockingly of all, a heavy steel slave collar."
						+ "</p>"
						+ "<p>"
							+ "[alexa.speech(Good pet!)]"
							+ " Alexa cries, leaning down to stroke Scarlett's plume of bright-red feathers,"
							+ " [alexa.speech(Now stay!)]"
						+ "</p>"
						+ "<p>"
							+ "Turning back towards you, the matriarch smiles,"
							+ " [alexa.speech(As you might have seen from the sign outside, I've decided to re-brand my shop."
									+ " And concerning Scarlett here, I've decided that she can pay me back for all her failures by being the first slave that I sell."
									+ " So, if you were hoping to get some information from her, you'll have to buy her first.)]"
						+ "</p>"
						+ "<p>"
							+ "You suppress a groan as you wonder just how many more hurdles you'll have to overcome before finally finding Arthur."
							+ " No matter what your views on slavery might be, it looks as though you only have one option."
							+ " You'll have to buy Scarlett, then demand that she tell you what happened to Arthur."
						+ "</p>";
					
			} else if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_G_SLAVERY) {
				return "<p>"
							+ "Pushing open the front door, you're greeted yet again by the beautiful matriarch, Alexa, sitting down behind the shop's counter."
							+ " She throws you a warm smile as you step inside the shop,"
							+ " [alexa.speech(Hello again! Are you ready to buy Scarlett yet?)]"
						+ "</p>"
						+ "<p>"
							+ "[scarlett.speech(M-Mrph...)]"
							+ " Scarlett's muffled groan drifts out from the other side of the shop as she hears Alexa talk about selling her."
						+ "</p>";
				
			} else {
				return "<p>"
						+ "Pushing open the front door, you're greeted yet again by the beautiful matriarch, Alexa, sitting down behind the shop's counter."
						+ " She throws you a warm smile as you step inside the shop,"
						+ " [alexa.speech(Hello again!)]"
					+ "</p>";
			}
		}

		@Override
		public Response getResponse(int index) {
			if (index == 1) {
				if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_F_SCARLETTS_FATE) {
					return new Response("Offer to buy", "Offer to buy Scarlett from Alexa.", ALEXAS_SHOP_SCARLETT_FOR_SALE) { 
						@Override
						public QuestLine getQuestLine() {
							return QuestLine.MAIN;
						}
						@Override
						public void effects() {
							if(Main.game.getDialogueFlags().punishedByAlexa) {
								Main.game.getDialogueFlags().scarlettPrice = 1000;
							}
						}
					};
					
				} else if (Main.game.getPlayer().getQuest(QuestLine.MAIN) == Quest.MAIN_1_G_SLAVERY) {
					if(!Main.game.getPlayer().isHasSlaverLicense()) {
						return new Response("Buy Scarlett (" + UtilText.getCurrencySymbol() + " "+Main.game.getDialogueFlags().scarlettPrice+")", "You need to obtain a slaver license from the Slavery Administration before you can buy Scarlett!", null);
						
					} else if(Main.game.getPlayer().getMoney() < Main.game.getDialogueFlags().scarlettPrice) {
						return new Response("Buy Scarlett (" + UtilText.getCurrencySymbol() + " "+Main.game.getDialogueFlags().scarlettPrice+")", "You don't have enough money to buy Scarlett.", null);
						
					} else {
						return new Response("Buy Scarlett (<span style='color:" + Colour.CURRENCY_GOLD.toWebHexString() + ";'>" + UtilText.getCurrencySymbol() + "</span> "+Main.game.getDialogueFlags().scarlettPrice+")"
								, "Buy Scarlett for "+Main.game.getDialogueFlags().scarlettPrice+" flames.", ALEXAS_SHOP_BUYING_SCARLETT) {
							@Override
							public void effects() {
								Main.game.getPlayer().incrementMoney(-Main.game.getDialogueFlags().scarlettPrice);
								
								AbstractClothing ballgag = Main.game.getScarlett().getClothingInSlot(InventorySlot.MOUTH);
								ballgag.setSealed(false);
								Main.game.getScarlett().unequipClothingIntoVoid(ballgag, true, Main.game.getAlexa());
								AbstractClothing wristRestraints = Main.game.getScarlett().getClothingInSlot(InventorySlot.WRIST);
								wristRestraints.setSealed(false);
								Main.game.getScarlett().unequipClothingIntoVoid(wristRestraints, true, Main.game.getAlexa());
								
								Main.game.getScarlett().setAffection(Main.game.getAlexa(), AffectionLevel.NEGATIVE_FIVE_LOATHE.getMedianValue());
								Main.game.getScarlett().setObedience(ObedienceLevel.NEGATIVE_FOUR_DEFIANT.getMedianValue());
								Main.game.getScarlett().setAffection(Main.game.getPlayer(), AffectionLevel.NEGATIVE_FIVE_LOATHE.getMedianValue());
								Main.game.getPlayer().addSlave(Main.game.getScarlett());
							}
						};
					}
					
				} else {
					return new Response("Slave Manager", "Enter the slave management screen.", ALEXAS_SHOP) {
						@Override
						public DialogueNodeOld getNextDialogue() {
							return MiscDialogue.getSlaveryManagementDialogue(ALEXAS_SHOP, Main.game.getAlexa());
						}
					};
				}

			} else if (index == 0 && Main.game.getPlayer().isQuestProgressGreaterThan(QuestLine.MAIN, Quest.MAIN_1_F_SCARLETTS_FATE)) {
				return new Response("Leave", "Leave Alexa's Pet Shop.", ALEXAS_SHOP_EXTERIOR);
				
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld ALEXAS_SHOP_SCARLETT_FOR_SALE = new DialogueNodeOld("Alexa's Pet Shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
						+ "[pc.speech(If that's what it takes, I'll buy Scarlett,)] you say."
					+ "</p>"
					+ "<p>"
						+ "[alexa.speech(Excellent!)] Alexa cries, leaning forwards in her chair,"
						+ (Main.game.getDialogueFlags().punishedByAlexa
							?"[alexa.speech(now, taking into consideration that you took that little punishment of mine on her behalf, I'm willing to give you a discount."
									+ " Although she does as I command, I imagine that she'd be quite disobedient for any other owner, so I'd say Scarlett's only worth about two thousand flames, but for you, I'll sell her for one thousand.)]"
							:"[alexa.speech(Although she does as I command, I imagine that she'd be quite disobedient for any other owner, so I'd say Scarlett's only worth about two thousand flames."
									+ " I'm not one for bargaining over price, so you can either pay up the two thousand, or I'll sell her to someone else.)]")
					+ "</p>"
					+ "<p>"
						+ "[pc.speech(Alright,)] you agree, not wanting Alexa to sell Scarlett to anyone else,"
						+ " [pc.speech(I'll agree to buy Scarlett for that price, so please can you save her for me?)]"
					+ "</p>"
					+ "<p>"
						+ "[alexa.speech(As you were so kind as to come up to my nest and inform me of Scarlett's failure, I'll agree to that,)]"
						+ " Alexa responds, reaching out to shake your [pc.hand],"
						+ " [alexa.speech(I'll save Scarlett for you until you get the money. Oh, and of course I'll need to see your slaver license as well.)]"
					+ "</p>"
					+ (Main.game.getPlayer().isHasSlaverLicense()
						?"<p>"
							+ "[pc.speech(Of course,)] you reply, [pc.speech(I'll have that ready for you.)]"
						+ "</p>"
						+ "<p>"
							+ "[alexa.speech(Excellent! Just let me know when you're ready to complete your purchase!)]"
						+ "</p>"
						:"<p>"
							+ "[pc.speech(Slaver license?)] you ask, [pc.speech(Where can I get one of those?)]"
						+ "</p>"
						+ "<p>"
							+ "[alexa.speech(You'll have to apply for one at the Slavery Administration building, just around the corner from here,)]"
							+ " Alexa explains,"
							+ " [alexa.speech(I'll hold Scarlett here for you until you can get one sorted out.)]"
						+ "</p>");
		}

		@Override
		public Response getResponse(int index) {
			return ALEXAS_SHOP.getResponse(index);
		}
	};
	
	public static final DialogueNodeOld ALEXAS_SHOP_BUYING_SCARLETT = new DialogueNodeOld("Alexa's Pet Shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
						+ "Walking up to Alexa's desk, you place both your slaver license and "+Main.game.getDialogueFlags().scarlettPrice+" flames down in front of her,"
						+ " [pc.speech(There you go. I'd like to buy Scarlett now please.)]"
					+ "</p>"
					+ "<p>"
						+ "After checking your license to make sure that everything's in order, Alexa counts out the coins, and, once satisfied that it's all there, she stand sup from behind her desk."
						+ " Walking over to Scarlett's hiding place, she reaches down and grabs her by the plume of feathers on top of her head."
						+ " Dragging the unfortunate harpy over to you, Alexa throws her at your feet."
					+ "</p>"
					+ "<p>"
						+ "[alexa.speech(It was a pleasure doing business with you,)]"
						+ " Alexa grins, before unfastening and removing the ballgag and wrist restraints from your new slave,"
						+ " [alexa.speech(she's all yours!)]"
					+ "</p>"
					+ "<p>"
						+ "As Alexa turns to walk back to her desk, Scarlett, still on her knees, turns and spits,"
						+ " [scarlett.speech(Fucking bitch! I'll make you pay for this! You fucking hideous skank!)]"
					+ "</p>"
					+ "<p>"
						+ "Alexa stops in her tracks, and you can almost physically feel the icy rage radiating from her body."
						+ " You'd better do something to silence Scarlett before she ends up causing a scene."
					+ "</p>";
		}

		@Override
		public Response getResponse(int index) {
			if (index == 1) {
				return new Response("Calm her down", "Gently reassure Scarlett to get her to calm down.", ALEXAS_SHOP_GENTLE) {
					@Override
					public void effects() {
						Main.game.getTextEndStringBuilder().append(Main.game.getScarlett().incrementAffection(Main.game.getPlayer(), 5));
					}
					@Override
					public QuestLine getQuestLine() {
						return QuestLine.MAIN;
					}
				};
				
			} else if (index == 2) {
				return new Response("Shout at her", "Shout at Scarlett and remind her that she's now your property.", ALEXAS_SHOP_SHOUT) {
					@Override
					public void effects() {
						Main.game.getTextEndStringBuilder().append(Main.game.getScarlett().incrementAffection(Main.game.getPlayer(), -2));
						Main.game.getTextEndStringBuilder().append(Main.game.getScarlett().incrementObedience(2));
					}
					@Override
					public QuestLine getQuestLine() {
						return QuestLine.MAIN;
					}
				};
				
			} else if (index == 3) {
				return new Response("Slap her", "Slap Scarlett and remind her that she's now your property.", ALEXAS_SHOP_SLAP,
						Util.newArrayListOfValues(new ListValue<>(Fetish.FETISH_SADIST)),
						CorruptionLevel.FOUR_LUSTFUL,
						null,
						null,
						null
						) {
					@Override
					public void effects() {
						Main.game.getTextEndStringBuilder().append(Main.game.getScarlett().incrementAffection(Main.game.getPlayer(), -5));
						Main.game.getTextEndStringBuilder().append(Main.game.getScarlett().incrementObedience(5));
					}
					@Override
					public QuestLine getQuestLine() {
						return QuestLine.MAIN;
					}
				};
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld ALEXAS_SHOP_GENTLE = new DialogueNodeOld("Alexa's Pet Shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
						+ "You lean down and place [pc.a_hand] on Scarlett's shoulder, smiling reassuringly at her as she snaps back round to look up at you."
					+ "</p>"
					+ "<p>"
						+ "[pc.speech(Calm down Scarlett,)]"
						+ " you say in the softest tone you can manage,"
						+ " [pc.speech(it's going to be ok. Just take a deep breath and try to relax.)]"
					+ "</p>"
					+ "<p>"
						+ "Her face flushes bright red, and for a moment you think that she's about to turn her anger on you, but she simply glares up into your [pc.eyes] without saying a word."
						+ " She sharply yanks her shoulder back, wriggling out of your grip as she sits back on her knees."
						+ " You decide against providing more physical reassurance, and step back, smiling down at the angry little harpy with as much warmth as you can muster."
					+ "</p>"
					+ "<p>"
						+ "[pc.speech(Thanks Scarlett,)]"
						+ " you say,"
						+ " [pc.speech(now, do you think you can finally tell me where Arthur is?)]"
					+ "</p>"
					+ "<p>"
						+ "You see a flicker of defiance deep down in her [scarlett.eyeColour] [scarlett.eyes], but, folding her [scarlett.arms] and letting out a little huff, she answers,"
						+ " [scarlett.speech(Fine... It doesn't look like I have much choice anyway, what with being a <i>slave</i>!)]"
						+ " she throws that word in Alexa's direction, scowling at her former matriarch."
					+ "</p>"
					+ "<p>"
						+ "You raise an eyebrow at Scarlett, and she lets out a sigh, before continuing,"
						+ " [scarlett.speech(So I'm guessing you know that Arthur was enslaved by the Enforcers. Well, through a random lottery, I was the 'lucky' person who ended up taking possession of him."
							+ " Not five minutes after he was delivered here, some <i>bastard incubus</i> came by and demanded that I give Arthur over to him, without any payment!)]"
					+ "</p>"
					+ "<p>"
						+ "You notice Scarlett fidgeting around as she starts getting more and more angry, and you gently ask her to calm down, before letting her continue,"
						+ " [scarlett.speech(So anyway, he produces all these documents of minor infractions I'd committed in setting this shop up, and, having to choose between being shut down or handing Arthur over, I chose the latter option.)]"
					+ "</p>"
					+ "<p>"
						+ "[pc.speech(Do you know the name of this incubus? Or where he lives?)] you ask, desperate to finally find out where Arthur is being held."
					+ "</p>"
					+ "<p>"
						+ "[scarlett.speech(His name is Zaranix,)]"
						+ " Scarlett growls, the very thought of his name making her angry,"
						+ " [scarlett.speech(he's not hard to miss; after all, how many demons do you know of that choose to stay in their male form?"
							+ " And yeah, I know where he lives. I had to verify his slaver license, and made a note of his address in Demon Home, so that I could get my revenge later..."
							+ " It's in the drawer over there.)]"
					+ "</p>"
					+ "<p>"
						+ "Scarlett points towards Alexa's desk, and, having been listening in to your conversation, Alexa pulls open the drawers until she finds the note."
						+ " Helpfully walking over and handing it to you, she then returns to sit in her chair once more."
						+ " Looking down at the piece of paper, you groan as you realise that Arthur's been right under your nose this whole time; the address is just across the street from his apartment building."
					+ "</p>"
					+ "<p>"
						+ "Your thoughts about how you're going to approach this Zaranix character are suddenly interrupted by Scarlett's impatient shuffling, and you realise that you're going to have to decide what you're going to do with her before anything else."
					+ "</p>";
		}

		@Override
		public Response getResponse(int index) {
			return getSlaveryChoiceResponse(index);
		}
	};
	
	public static final DialogueNodeOld ALEXAS_SHOP_SHOUT = new DialogueNodeOld("Alexa's Pet Shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
					+ "You step forwards, frowning down angrily at Scarlett as you start to berate her,"
					+ " [pc.speech(You insolent bitch! How <i>dare</i> you?! You're only to speak when spoken to, and if I hear <i>one more</i> insult come out of that filthy mouth of yours, you're going to be sorry!)]"
				+ "</p>"
				+ "<p>"
					+ "Her face flushes bright red, and for a moment you think that she's about to turn her anger on you, but she simply glares up into your [pc.eyes] without saying a word."
					+ " You hold her gaze, and after angrily staring at one another for a moment, Scarlett casts her eyes down to the floor and sits back on her knees."
				+ "</p>"
				+ "<p>"
					+ "[pc.speech(That's better,)]"
					+ " you say, looking down at the angry little harpy,"
					+ " [pc.speech(now, you're going to tell me where Arthur is!)]"
				+ "</p>"
				+ "<p>"
					+ "You see a flicker of defiance deep down in her [scarlett.eyeColour] [scarlett.eyes], but, folding her [scarlett.arms] and letting out a little huff, she answers,"
					+ " [scarlett.speech(Fine... It doesn't look like I have much choice anyway, what with being a <i>slave</i>!)]"
					+ " she throws that word in Alexa's direction, scowling at her former matriarch."
				+ "</p>"
				+ "<p>"
					+ "You take a sharp intake of breath, and Scarlett lets out a sigh, deciding to drop the matter as she continues,"
					+ " [scarlett.speech(So I'm guessing you know that Arthur was enslaved by the Enforcers. Well, through a random lottery, I was the 'lucky' person who ended up taking possession of him."
						+ " Not five minutes after he was delivered here, some <i>bast-</i> I mean, some <i>incubus</i> came by and demanded that I give Arthur over to him, without any payment!)]"
				+ "</p>"
				+ "<p>"
					+ "You notice Scarlett fidgeting around as she starts getting more and more angry, and you remind her that she'd better watch her tone, before letting her continue,"
					+ " [scarlett.speech(So anyway, he produces all these documents of minor infractions I'd committed in setting this shop up, and, having to choose between being shut down or handing Arthur over, I chose the latter option.)]"
				+ "</p>"
				+ "<p>"
					+ "[pc.speech(What's the name of this incubus? And where does he live?)] you ask, desperate to finally find out where Arthur is being held."
				+ "</p>"
				+ "<p>"
					+ "[scarlett.speech(His name is Zaranix,)]"
					+ " Scarlett growls, the very thought of his name making her angry,"
					+ " [scarlett.speech(he's not hard to miss; after all, how many demons do you know of that choose to stay in their male form?"
						+ " And yeah, I know where he lives. I had to verify his slaver license, and made a note of his address in Demon Home, so that I could get my revenge later..."
						+ " It's in the drawer over there.)]"
				+ "</p>"
				+ "<p>"
					+ "Scarlett points towards Alexa's desk, and, having been listening in to your conversation, the beautiful harpy pulls open the drawers until she finds the note."
					+ " Helpfully walking over and handing it to you, she then returns to sit in her chair once more."
					+ " Looking down at the piece of paper, you groan as you realise that Arthur's been right under your nose this whole time; the address is just across the street from his apartment building."
				+ "</p>"
				+ "<p>"
					+ "Your thoughts about how you're going to approach this Zaranix character are suddenly interrupted by Scarlett's impatient shuffling, and you realise that you're going to have to decide what you're going to do with her before anything else."
				+ "</p>";
		}

		@Override
		public Response getResponse(int index) {
			return getSlaveryChoiceResponse(index);
		}
	};
	
	public static final DialogueNodeOld ALEXAS_SHOP_SLAP = new DialogueNodeOld("Alexa's Pet Shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
					+ "You step forwards, before quickly leaning down to deliver a sharp slap across Scarlett's face,"
					+ " [pc.speech(You insolent bitch! How <i>dare</i> you?! You're only to speak when spoken to, and if I hear <i>one more</i> insult come out of that filthy mouth of yours, you're going to be sorry!)]"
				+ "</p>"
				+ "<p>"
					+ "She brings her hands up to her face, recoiling back from you as her mouth opens wide in shock."
					+ " For a moment you think that she's about to turn her anger on you, but she simply glares up into your [pc.eyes] without saying a word."
					+ " You hold her gaze, and after angrily staring at one another for a moment, Scarlett casts her eyes down to the floor and sits back on her knees."
				+ "</p>"
				+ "<p>"
					+ "[pc.speech(That's better,)]"
					+ " you say, looking down at the angry little harpy,"
					+ " [pc.speech(now, you're going to tell me where Arthur is!)]"
				+ "</p>"
				+ "<p>"
					+ "You see a flicker of defiance deep down in her [scarlett.eyeColour] [scarlett.eyes], but, folding her [scarlett.arms] and letting out a little huff, she answers,"
					+ " [scarlett.speech(Fine... It doesn't look like I have much choice anyway, what with being a <i>slave</i>!)]"
					+ " she throws that word in Alexa's direction, scowling at her former matriarch."
				+ "</p>"
				+ "<p>"
					+ "You take a sharp intake of breath, and Scarlett lets out a sigh, deciding to drop the matter as she continues,"
					+ " [scarlett.speech(So I'm guessing you know that Arthur was enslaved by the Enforcers. Well, through a random lottery, I was the 'lucky' person who ended up taking possession of him."
						+ " Not five minutes after he was delivered here, some <i>bast-</i> I mean, some <i>incubus</i> came by and demanded that I give Arthur over to him, without any payment!)]"
				+ "</p>"
				+ "<p>"
					+ "You notice Scarlett fidgeting around as she starts getting more and more angry, and you remind her that she'd better watch her tone, before letting her continue,"
					+ " [scarlett.speech(So anyway, he produces all these documents of minor infractions I'd committed in setting this shop up, and, having to choose between being shut down or handing Arthur over, I chose the latter option.)]"
				+ "</p>"
				+ "<p>"
					+ "[pc.speech(What's the name of this incubus? And where does he live?)] you ask, desperate to finally find out where Arthur is being held."
				+ "</p>"
				+ "<p>"
					+ "[scarlett.speech(His name is Zaranix,)]"
					+ " Scarlett growls, the very thought of his name making her angry,"
					+ " [scarlett.speech(he's not hard to miss; after all, how many demons do you know of that choose to stay in their male form?"
						+ " And yeah, I know where he lives. I had to verify his slaver license, and made a note of his address in Demon Home, so that I could get my revenge later..."
						+ " It's in the drawer over there.)]"
				+ "</p>"
				+ "<p>"
					+ "Scarlett points towards Alexa's desk, and, having been listening in to your conversation, the beautiful harpy pulls open the drawers until she finds the note."
					+ " Helpfully walking over and handing it to you, she then returns to sit in her chair once more."
					+ " Looking down at the piece of paper, you groan as you realise that Arthur's been right under your nose this whole time; the address is just across the street from his apartment building."
				+ "</p>"
				+ "<p>"
					+ "Your thoughts about how you're going to approach this Zaranix character are suddenly interrupted by Scarlett's impatient shuffling, and you realise that you're going to have to decide what you're going to do with her before anything else."
				+ "</p>";
		}

		@Override
		public Response getResponse(int index) {
			return getSlaveryChoiceResponse(index);
		}
	};
	
	private static Response getSlaveryChoiceResponse(int index) {
		if (index == 1) {
			return new Response("Keep her", "You decide to keep Scarlett as your slave.", ALEXAS_SHOP_BUYING_SCARLETT_KEEP_HER) {
				@Override
				public void effects() {
					Main.game.getScarlett().setLocation(WorldType.SLAVER_ALLEY, SlaverAlley.SLAVERY_ADMINISTRATION, true);
				}
			};

		} else if (index == 2) {
			return new Response("Free her", "You decide to grant Scarlett her freedom.", ALEXAS_SHOP_BUYING_SCARLETT_FREE_HER) {
				@Override
				public void effects() {
					
					AbstractClothing collar = Main.game.getScarlett().getClothingInSlot(InventorySlot.NECK);
					collar.setSealed(false);
					Main.game.getScarlett().unequipClothingIntoVoid(collar, true, Main.game.getAlexa());
					
					((Scarlett) Main.game.getScarlett()).getDressed();
					
					Main.game.getScarlett().setLocation(WorldType.HARPY_NEST, HarpyNests.ALEXAS_NEST, true);
					Main.game.getScarlett().setObedience(ObedienceLevel.ZERO_FREE_WILLED.getMedianValue());
					Main.game.getScarlett().setAffection(Main.game.getPlayer(), AffectionLevel.ZERO_NEUTRAL.getMedianValue());
					Main.game.getPlayer().removeSlave(Main.game.getScarlett());
				}
			};

		} else {
			return null;
		}
	}
	
	public static final DialogueNodeOld ALEXAS_SHOP_BUYING_SCARLETT_KEEP_HER = new DialogueNodeOld("Alexa's Pet Shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
						+ "Deciding that you're going to keep Scarlett, you turn towards Alexa,"
						+ " [pc.speech(Can I get Scarlett transferred somewhere? I don't have the time to escort her myself right now.)]"
					+ "</p>"
					+ "<p>"
						+ "[alexa.speech(Well, of course! All newly-bought slaves have to go through the Slavery Administration first, I was just waiting for you to finish your business with her,)]"
						+ " Alexa cheerily responds, pointing to the door,"
						+ " [alexa.speech(and it looks like their representative has arrived.)]"
					+ "</p>"
					+ "<p>"
						+ "You turn around to see Finch pushing open the shop's door, before stepping inside and holding up a little glowing crystal,"
						+ " [finch.speech(Someone called for a slave transfer?)]"
					+ "</p>"
					+ "<p>"
						+ "You greet Finch, before informing him that you've taken ownership of Scarlett."
						+ " He quickly explains what Alexa already told you; that all slave purchases need to go through Slavery Administration."
						+ " After agreeing to come by later and sort out the transfer to a more permanent location, Finch attaches a leash to Scarlett's collar and leads her out of the shop."
					+ "</p>"
					+ "<p>"
						+ "[alexa.speech(By the way,)]"
						+ " Alexa calls out from behind her desk,"
						+ " [alexa.speech(I've decided to have a bit of fun down here for a while."
							+ " The nests get so <i>tedious</i> sometimes."
							+ " I'm going to get this shop up and running properly, so if you ever need to buy or sell any slaves, you know where to come first!)]"
					+ "</p>";
		}

		@Override
		public Response getResponse(int index) {
			return ALEXAS_SHOP.getResponse(index);
		}
	};
	
	public static final DialogueNodeOld ALEXAS_SHOP_BUYING_SCARLETT_FREE_HER = new DialogueNodeOld("Alexa's Pet Shop", ".", true, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return "<p>"
						+ "Deciding that you're going to free Scarlett, you turn towards Alexa,"
						+ " [pc.speech(Do I need to fill out some kind of form to set Scarlett free? I'm not too keen on owning her...)]"
					+ "</p>"
					+ "<p>"
						+ "[alexa.speech(Hah, so it turns out you're lucky after all!)]"
						+ " Alexa calls out to Scarlett, before turning to you,"
						+ " [alexa.speech(You just have to inform the Slavery Administration of your intent to set the slave free, and, seeing as all newly-bought slaves have to go through them first, their representative should be turning up here at any moment.)]"
					+ "</p>"
					+ "<p>"
						+ "As Alexa says that, she points behind you, and you turn around to see Finch pushing open the shop's door, before stepping inside and holding up a little glowing crystal,"
						+ " [finch.speech(Someone called for a slave transfer?)]"
					+ "</p>"
					+ "<p>"
						+ "You greet Finch, before informing him that you've taken ownership of Scarlett, and intend to set her free."
						+ " He lets out a little laugh, before saying that now you've informed the Administration of your intent, all you need to do is take her collar off."
						+ " With that, he turns around and leaves the shop, heading back to his post."
					+ "</p>"
					+ "<p>"
						+ "[scarlett.speech(Y-You're really setting me free?)]"
						+ " Scarlett asks as you bend down and unclasp her collar, and as you reply in the affirmative, she mumbles,"
						+ " [scarlett.speech(T-Thank you...)]"
					+ "</p>"
					+ "<p>"
						+ "[alexa.speech(If you're not a slave anymore,)]"
						+ " Alexa calls out to Scarlett from behind her desk,"
						+ " [alexa.speech(you'd best be reporting in to Lucy back at the nest. And don't think I've forgotten about your silly little outburst earlier; I'll make sure you're punished for that.)]"
					+ "</p>"
					+ "<p>"
						+ "[scarlett.speech(Yes Alexa...)]"
						+ " Scarlett mumbles again, and before you can say anything, she dashes towards the door and runs out, heading back to Alexa's nest."
					+ "</p>"
					+ "<p>"
						+ "[alexa.speech(You may have freed her from slavery,)]"
						+ " Alexa says,"
						+ "[alexa.speech(but that just makes her part of my flock again."
							+ " Speaking of which, I've actually decided to let them get on by themselves for a while and have a bit of fun down here."
							+ " The nests get so <i>tedious</i> sometimes."
							+ " I'm going to get this shop up and running properly, so if you ever need to buy or sell any slaves, you know where to come first!)]"
					+ "</p>";
		}

		@Override
		public Response getResponse(int index) {
			return ALEXAS_SHOP.getResponse(index);
		}
	};
	
}
