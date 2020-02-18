package handlers.effecthandlers;

import org.l2j.gameserver.engine.skill.api.SkillEffectFactory;
import org.l2j.gameserver.model.StatsSet;
import org.l2j.gameserver.model.actor.Creature;
import org.l2j.gameserver.model.effects.AbstractEffect;
import org.l2j.gameserver.model.effects.EffectType;
import org.l2j.gameserver.model.items.instance.Item;
import org.l2j.gameserver.engine.skill.api.Skill;
import org.l2j.gameserver.model.stats.Stat;
import org.l2j.gameserver.network.SystemMessageId;
import org.l2j.gameserver.network.serverpackets.SystemMessage;

import static java.util.Objects.isNull;
import static org.l2j.gameserver.network.serverpackets.SystemMessage.getSystemMessage;
import static org.l2j.gameserver.util.GameUtils.isDoor;

/**
 * Mana Heal Percent effect implementation.
 * @author UnAfraid
 * @author JoeAlisson
 */
public final class ManaHealPercent extends AbstractEffect {
    private final double power;

    private ManaHealPercent(StatsSet params)
    {
        power = params.getDouble("power", 0);
    }

    @Override
    public EffectType getEffectType()
    {
        return EffectType.MANAHEAL_PERCENT;
    }

    @Override
    public boolean isInstant()
    {
        return true;
    }

    @Override
    public void instant(Creature effector, Creature effected, Skill skill, Item item) {
        if (isNull(effected) || effected.isDead() || isDoor(effected) || effected.isMpBlocked()) {
            return;
        }

        double amount;
        final double power = this.power;
        final boolean full = (power == 100.0);

        amount = full ? effected.getMaxMp() : (effected.getMaxMp() * power) / 100.0;
        if ((item != null) && (item.isPotion() || item.isElixir())) {
            amount += effected.getStats().getValue(Stat.ADDITIONAL_POTION_MP, 0);
        }
        // Prevents overheal
        amount = Math.min(amount, effected.getMaxRecoverableMp() - effected.getCurrentMp());
        if (amount != 0) {
            effected.setCurrentMp(amount + effected.getCurrentMp(), false);
            effected.broadcastStatusUpdate(effector);
        }

        SystemMessage sm;
        if (effector.getObjectId() != effected.getObjectId()) {
            sm = getSystemMessage(SystemMessageId.S2_MP_HAS_BEEN_RESTORED_BY_C1).addString(effector.getName());
        } else {
            sm = getSystemMessage(SystemMessageId.S1_MP_HAS_BEEN_RESTORED);
        }
        effected.sendPacket(sm.addInt((int) amount));
    }

    public static class Factory implements SkillEffectFactory {

        @Override
        public AbstractEffect create(StatsSet data) {
            return new ManaHealPercent(data);
        }

        @Override
        public String effectName() {
            return "ManaHealPercent";
        }
    }
}
