package StrawberrySpireMod.relics.blandfruitRelics;

import com.badlogic.gdx.graphics.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.relics.*;

import basemod.abstracts.*;

public class Starfruit extends CustomRelic { // The Future Max HP benefits are patched.

    public static final String ID = "strawberrySpire:Starfruit";
    public static final Texture IMAGE_PATH = new Texture("relics/placeholder.png");
    public static final Texture IMAGE_OUTLINE_PATH = new Texture("relics/outline/placeholder.png");
    private static final int MAX_HP_AMOUNT = 8;
    private static final int FUTURE_MAX_HP_PERCENT_INCREASE_AMOUNT = 50;

    public Starfruit() {
        super(ID, IMAGE_PATH, IMAGE_OUTLINE_PATH, RelicTier.SPECIAL, LandingSound.FLAT);
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + MAX_HP_AMOUNT + DESCRIPTIONS[1] + FUTURE_MAX_HP_PERCENT_INCREASE_AMOUNT + DESCRIPTIONS[2];
    }

    public void onEquip() {
        flash();
        AbstractDungeon.player.increaseMaxHp(MAX_HP_AMOUNT, true);
    }

    public AbstractRelic makeCopy() {
        return new Starfruit();
    }
}
