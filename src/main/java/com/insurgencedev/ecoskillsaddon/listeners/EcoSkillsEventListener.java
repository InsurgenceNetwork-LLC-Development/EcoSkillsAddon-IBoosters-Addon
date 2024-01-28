package com.insurgencedev.ecoskillsaddon.listeners;

import com.willfp.ecoskills.api.event.PlayerSkillXPGainEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.data.BoosterFindResult;

public final class EcoSkillsEventListener implements Listener {

    @EventHandler
    private void onGain(PlayerSkillXPGainEvent event) {
        final String TYPE = "Skills";
        final String NAMESPACE = "ECO_SKILLS";
        final double[] totalMulti = {1};

        BoosterFindResult pResult = IBoosterAPI.INSTANCE.getCache(event.getPlayer()).getBoosterDataManager().findActiveBooster(TYPE, NAMESPACE);
        if (pResult instanceof BoosterFindResult.Success boosterResult) {
            totalMulti[0] += boosterResult.getBoosterData().getMultiplier();
        }

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findGlobalBooster(TYPE, NAMESPACE, globalBooster -> {
            totalMulti[0] += globalBooster.getMultiplier();
            return null;
        }, () -> null);

        event.setGainedXP(calculateAmount(event.getGainedXP(), totalMulti[0]));
    }

    private long calculateAmount(double amount, double multi) {
        return (long) (amount * (multi < 1 ? 1 + multi : multi));
    }
}
