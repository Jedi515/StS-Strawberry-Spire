package StrawberrySpireMod.actions.unique;

import com.megacrit.cardcrawl.actions.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.*;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.*;

public class GettingOverItDrawPileAction extends AbstractGameAction {

    public static final String[] TEXT = CardCrawlGame.languagePack.getUIString("strawberrySpire:GettingOverItAction").TEXT;
    private AbstractPlayer player;
    private int numberOfCards;

    public GettingOverItDrawPileAction(int magicNumber) {
        this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_XFAST;
        this.player = AbstractDungeon.player;
        this.numberOfCards = magicNumber;
    }

    public void update() {
        if (AbstractDungeon.getCurrRoom().isBattleEnding()) {
            this.isDone = true;
            return;
        }
        if (this.duration == Settings.ACTION_DUR_XFAST) {
            if (this.player.drawPile.isEmpty()) {
                this.isDone = true;
                return;
            }
            else {
                CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
                for (AbstractCard c : this.player.drawPile.group) {
                    if (c.type == AbstractCard.CardType.STATUS) {
                        temp.addToTop(c);
                    }
                }
                temp.sortAlphabetically(true);
                temp.sortByRarityPlusStatusCardType(false);
                if (temp.isEmpty()) {
                    this.isDone = true;
                    return;
                }
                else if (this.numberOfCards == 1) {
                    AbstractDungeon.gridSelectScreen.open(temp, this.numberOfCards, true, TEXT[0]);
                }
                else {
                    AbstractDungeon.gridSelectScreen.open(temp, this.numberOfCards, true, TEXT[1] + this.numberOfCards + TEXT[2]);
                }
                tickDuration();
                return;
            }
        }
        if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
            for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
                this.player.drawPile.moveToExhaustPile(c);
            }
            AbstractDungeon.gridSelectScreen.selectedCards.clear();
            AbstractDungeon.player.hand.refreshHandLayout();
        }
        tickDuration();
    }
}
