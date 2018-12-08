package StrawberrySpireMod.relics;

import com.badlogic.gdx.graphics.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.utility.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.relics.*;

import basemod.abstracts.*;

public class BonfireDress extends CustomRelic {

    public static final String ID = "strawberrySpire:BonfireDress";
    public static final Texture IMAGE_PATH = new Texture("relics/placeholder.png");
    public static final Texture IMAGE_OUTLINE_PATH = new Texture("relics/outline/placeholder.png");
    private static final int DEXTERITY_AMOUNT = 1;
    private boolean isFirstTurn = false;
    private AbstractCard.CardType lastCardType = null;
    private boolean hasBrokenAlternation = false;

    public BonfireDress() {
        super(ID, IMAGE_PATH, IMAGE_OUTLINE_PATH, RelicTier.RARE, LandingSound.FLAT);
        this.pulse = false;
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DEXTERITY_AMOUNT + DESCRIPTIONS[1];
    }

    public void atPreBattle() {
        this.isFirstTurn = true;
        this.lastCardType = null;
        this.hasBrokenAlternation = false;
        this.pulse = true;
        beginPulse();
    }

    public void atTurnStart() {
        if (!isFirstTurn && !hasBrokenAlternation) {
            flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DexterityPower(AbstractDungeon.player, DEXTERITY_AMOUNT), DEXTERITY_AMOUNT));
        }
        this.isFirstTurn = false;
        this.lastCardType = null;
        this.hasBrokenAlternation = false;
        this.pulse = true;
        beginPulse();
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (!this.hasBrokenAlternation && this.lastCardType != null && this.lastCardType == card.type) {
            this.hasBrokenAlternation = true;
            this.pulse = false;
        }
        this.lastCardType = card.type;
    }

    public void onVictory() {
        this.pulse = false;
    }

    public AbstractRelic makeCopy() {
        return new BonfireDress();
    }
}
