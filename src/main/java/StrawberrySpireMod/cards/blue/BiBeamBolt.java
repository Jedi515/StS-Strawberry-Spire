package StrawberrySpireMod.cards.blue;

import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.*;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.monsters.*;

import StrawberrySpireMod.cards.*;
import StrawberrySpireMod.powers.*;

public class BiBeamBolt extends AbstractStrawberrySpireCard {

    public static final String ID = "strawberrySpire:BiBeamBolt";
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = CARD_STRINGS.NAME;
    public static final String UPGRADE_NAME = CARD_STRINGS.EXTENDED_DESCRIPTION[0];
    public static final String IMAGE_PATH = "StrawberrySpireModResources/cards/blue/biBeamBolt.png";
    private static final int COST = 2;
    public static final String DESCRIPTION = CARD_STRINGS.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = CARD_STRINGS.UPGRADE_DESCRIPTION;
    private static final int MAGIC_NUMBER = 1;
    private static final int UPGRADE_PLUS_MAGIC_NUMBER = 1;

    public BiBeamBolt() {
        super(ID, NAME, IMAGE_PATH, COST, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCard.CardColor.BLUE, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = MAGIC_NUMBER;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p, new BiBeamBoltPower(p, this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new BiBeamBolt();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.name = UPGRADE_NAME;
            initializeTitle();
            this.rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();

            this.upgradeMagicNumber(UPGRADE_PLUS_MAGIC_NUMBER);
        }
    }
}