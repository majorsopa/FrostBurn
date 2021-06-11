package com.evaan.frostburn.module.modules.render;

import com.evaan.frostburn.module.Module;

public class Fullbright extends Module {
    boolean isExisting = false;
    double initalGamma;
    public Fullbright() {
        super("Fullbright", Category.RENDER);
    }

    @Override
    public void onUpdate() {
        if (mc.player != null && !isExisting) {
            isExisting = true;
            initalGamma = mc.options.gamma;
        }
        mc.options.gamma = 100; //doing this so it doesnt throw a nullpointer on loading and not work
    }

    @Override
    public void onDisable() {
        mc.options.gamma = initalGamma;
    }
}
