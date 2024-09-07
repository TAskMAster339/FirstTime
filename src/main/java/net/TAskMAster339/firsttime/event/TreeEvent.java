package net.TAskMAster339.firsttime.event;

import net.TAskMAster339.firsttime.FirstTime;
import net.TAskMAster339.firsttime.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid= FirstTime.MOD_ID)
public class TreeEvent {

    private static final int MAX_TREE_SIZE = 20;
    private static final int MIN_TREE_SIZE = 5;
    private static final int DAMAGE_TO_ITEM_MULTI = 10;

    @SubscribeEvent
    public static void WhenTreeBrakes(BlockEvent.BreakEvent event) {
        if (!event.getLevel().isClientSide() && event.getLevel() instanceof ServerLevel) {
            ServerLevel world = (ServerLevel) event.getLevel();
            BlockPos pos = event.getPos();
            BlockState state = event.getState();

            if (isLog(state.getBlock())) {
                ItemStack heldItem = event.getPlayer().getMainHandItem();
                boolean isAxe = isAxe(heldItem.getItem());

                if (isAxe) {
                    if (!event.getPlayer().isShiftKeyDown()) {
                        Set<BlockPos> treeBlocks = new HashSet<>();
                        int numBlocks = countConnectedLogBlocks(world, pos, treeBlocks);
                        ModEvents.addBrokenBlocksNumber(numBlocks); // count broken blocks
                        for (BlockPos blockPos : treeBlocks) {
                            BlockState blockState = world.getBlockState(blockPos);
                            if (isLog(blockState.getBlock())) {
                                world.destroyBlock(blockPos, true);
                            }
                        }
                        heldItem.hurtAndBreak(numBlocks * DAMAGE_TO_ITEM_MULTI, event.getPlayer(), (player) -> {
                            player.broadcastBreakEvent(event.getPlayer().getUsedItemHand());
                        });
                    }
                }
                else {
                    if (isPartOfTree(world, pos)) {
                        ModEvents.addBrokenBlocksNumber(1); // count broken blocks
                        event.setCanceled(true);
                        world.setBlock(pos, state, 3);
                        heldItem.hurtAndBreak(10_000_000, event.getPlayer(), (player) -> {
                            player.broadcastBreakEvent(event.getPlayer().getUsedItemHand());
                        });
                        event.getPlayer().sendSystemMessage(Component.literal("...Ломай, ломай, мы же миллионеры!!!"));
                    }
                }
            }
        }
    }
    private static boolean isPartOfTree(ServerLevel world, BlockPos pos) {
        Set<BlockPos> checkedBlocks = new HashSet<>();
        int treeSize = countConnectedLogBlocks(world, pos, checkedBlocks);
        return treeSize >= MIN_TREE_SIZE && treeSize <= MAX_TREE_SIZE;
    }
    private static int countConnectedLogBlocks(ServerLevel world, BlockPos pos, Set<BlockPos> checkedBlocks) {
        if (checkedBlocks.contains(pos)) {
            return 0;
        }
        BlockState state = world.getBlockState(pos);
        if (!isLog(state.getBlock())) {
            return 0;
        }
        checkedBlocks.add(pos);
        int count = 1;
        for (BlockPos offset : BlockPos.betweenClosed(-1, -1, -1, 1, 1, 1)) {
            BlockPos neighborPos = pos.offset(offset);
            count += countConnectedLogBlocks(world, neighborPos, checkedBlocks);
            if (count > MAX_TREE_SIZE) {
                return count;
            }
        }
        return count;
    }

    private static boolean isLog(Block block) {
        return block == Blocks.OAK_LOG ||
                block == Blocks.SPRUCE_LOG ||
                block == Blocks.BIRCH_LOG ||
                block == Blocks.JUNGLE_LOG ||
                block == Blocks.ACACIA_LOG ||
                block == Blocks.DARK_OAK_LOG;
    }
    private static boolean isAxe(Item item) {
        if (item == Items.WOODEN_AXE ||
                item == Items.STONE_AXE ||
                item == Items.IRON_AXE ||
                item == Items.GOLDEN_AXE ||
                item == Items.DIAMOND_AXE ||
                item == Items.NETHERITE_AXE ||
                item == ModItems.SAPPHIRE_MULTI_TOOL.get()){
            return true;
        }

        return item instanceof AxeItem;
    }
}
