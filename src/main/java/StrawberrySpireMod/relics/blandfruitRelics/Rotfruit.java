package StrawberrySpireMod.relics.blandfruitRelics;

import com.badlogic.gdx.graphics.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.relics.*;

import basemod.abstracts.*;

public class Rotfruit extends CustomRelic {

    public static final String ID = "strawberrySpire:Rotfruit";
    public static final Texture IMAGE_PATH = new Texture("relics/placeholder.png");
    private static final int STRENGTH_AMOUNT = 1;

    public Rotfruit() {
        super(ID, IMAGE_PATH, RelicTier.SPECIAL, LandingSound.FLAT);
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + STRENGTH_AMOUNT + DESCRIPTIONS[1];
    }

    public void atTurnStart() {
        flash();
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, STRENGTH_AMOUNT), STRENGTH_AMOUNT));
        AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    }

    public AbstractRelic makeCopy() {
        return new Rotfruit();
    }
}
