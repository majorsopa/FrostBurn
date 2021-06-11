package com.evaan.frostburn.module.modules.render;

import com.evaan.frostburn.module.Module;

public class Zoom extends Module {
    private final double newFOV = 30;
    private double prevFOV;
    public Zoom() {
        super("Zoom", Category.RENDER);
    }

    @Override
    public void onEnable() {
        prevFOV = mc.options.fov;
        mc.options.fov = newFOV;
    }

    @Override
    public void onDisable() {
        mc.options.fov = prevFOV;
    }
}
