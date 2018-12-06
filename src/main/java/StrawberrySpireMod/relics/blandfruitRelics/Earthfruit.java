package StrawberrySpireMod.relics.blandfruitRelics;

import com.badlogic.gdx.graphics.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.relics.*;

import StrawberrySpireMod.powers.*;

import basemod.abstracts.*;

public class Earthfruit extends CustomRelic {

    public static final String ID = "strawberrySpire:Earthfruit";
    public static final Texture IMAGE_PATH = new Texture("relics/placeholder.png");
    private static final int REDUCE_DAMAGE_AMOUNT = 1;

    public Earthfruit() {
        super(ID, IMAGE_PATH, RelicTier.SPECIAL, LandingSound.FLAT);
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + REDUCE_DAMAGE_AMOUNT + DESCRIPTIONS[1];
    }

    public void atBattleStart() {
        flash();
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BarkskinPower(AbstractDungeon.player, REDUCE_DAMAGE_AMOUNT), REDUCE_DAMAGE_AMOUNT));
        AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    }

    public AbstractRelic makeCopy() {
        return new Earthfruit();
    }
}
