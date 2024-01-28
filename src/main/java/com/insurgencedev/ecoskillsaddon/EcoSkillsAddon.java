package com.insurgencedev.ecoskillsaddon;

import com.insurgencedev.ecoskillsaddon.listeners.EcoSkillsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "EcoSkillsAddon", version = "1.0.1", author = "InsurgenceDev", description = "EcoSkills Support")
public class EcoSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("EcoSkills")) {
            registerEvent(new EcoSkillsEventListener());
        }
    }
}
