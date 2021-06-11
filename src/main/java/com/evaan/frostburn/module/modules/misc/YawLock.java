package com.evaan.frostburn.module.modules.misc;

import com.evaan.frostburn.module.Module;
import net.minecraft.client.util.math.MatrixStack;

public class YawLock extends Module {
    public YawLock() {
        super("YawLock", Category.MISC);
    }

    @Override
    public void onEnable() {
        if (mc.player == null) {
            disable();
            return;
        }
    }

    @Override
    public void onRender(MatrixStack matrices) {
        switch (mc.player.getHorizontalFacing()) {
            case SOUTH:
                mc.player.setYaw(0);
                break;
            case EAST:
                mc.player.setYaw(270);
                break;
            case NORTH:
                mc.player.setYaw(180);
                break;
            case WEST:
                mc.player.setYaw(90);
                break;
        }
    }
}
