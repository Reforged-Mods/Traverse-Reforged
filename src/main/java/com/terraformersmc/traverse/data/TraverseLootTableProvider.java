package com.terraformersmc.traverse.data;

import net.minecraft.data.DataOutput;
import net.minecraft.data.server.loottable.LootTableProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableReporter;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TraverseLootTableProvider extends LootTableProvider {
    public TraverseLootTableProvider(DataOutput root) {
        super(root, Set.of(), List.of(
			new LootTableProvider.LootTypeGenerator(TraverseBlockLootTableProvider::new, LootContextTypes.BLOCK)
		));
    }

    @Override
    protected void validate(Map<Identifier, LootTable> map, LootTableReporter validationtracker) {
    }
}
