package com.insurgencedev.ecoskillsaddon;

import com.insurgencedev.ecoskillsaddon.listeners.EcoSkillsEventListener;
import org.bukkit.Bukkit;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "EcoSkillsAddon", version = "1.0.1", author = "InsurgenceDev", description = "EcoSkills Support")
public class EcoSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Bukkit.getPluginManager().isPluginEnabled("EcoSkills")) {
            registerEvent(new EcoSkillsEventListener());
        }
    }
}
