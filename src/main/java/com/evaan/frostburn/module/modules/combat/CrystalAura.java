package com.evaan.frostburn.module.modules.combat;

import com.evaan.frostburn.module.Module;
import com.google.common.collect.Streams;
import net.minecraft.entity.decoration.EndCrystalEntity;

import java.util.stream.Collectors;

//todo skid some ca because im too lazy to
public class CrystalAura extends Module {

    public CrystalAura() {
        super("CrystalAura", Category.COMBAT);
    }

    @Override
    public void onUpdate() {
        if (mc.player == null || mc.world == null) return;

        try {
            EndCrystalEntity entity = (EndCrystalEntity) Streams.stream(mc.world.getEntities()).filter(e -> e instanceof EndCrystalEntity && mc.player.distanceTo(e) <= 4.0).collect(Collectors.toList()).get(0);
            if (entity != null) {
                if (!entity.isAttackable()) return;
                mc.interactionManager.attackEntity(mc.player, entity);
            }

        } catch (Exception ignored) {
        }
    }
}
