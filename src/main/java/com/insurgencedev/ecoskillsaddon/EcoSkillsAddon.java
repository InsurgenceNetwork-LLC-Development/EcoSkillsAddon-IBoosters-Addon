package com.insurgencedev.ecoskillsaddon;

import com.insurgencedev.ecoskillsaddon.listeners.EcoSkillsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "EcoSkillsAddon", version = "1.0.0", author = "InsurgenceDev", description = "EcoSkills Support")
public class EcoSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        registerEvent(new EcoSkillsEventListener());
    }
}
