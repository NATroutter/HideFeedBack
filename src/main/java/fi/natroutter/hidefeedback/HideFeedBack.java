package fi.natroutter.hidefeedback;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class HideFeedBack implements ModInitializer {

    public static final GameRules.Key<GameRules.BooleanRule> feedBackFromPlayer = newRule("feedBackFromPlayer", false);
    public static final GameRules.Key<GameRules.BooleanRule> feedBackFromCommandBlock = newRule("feedBackFromCommandBlock", false);
    public static final GameRules.Key<GameRules.BooleanRule> feedBackFromServer = newRule("feedBackFromServer", false);

    public static final GameRules.Key<GameRules.BooleanRule> feedBackPlayer = newRule("feedBackPlayer", false);
    public static final GameRules.Key<GameRules.BooleanRule> feedBackServer = newRule("feedBackServer", false);


    private static GameRules.Key<GameRules.BooleanRule> newRule(String name, boolean defaultValue) {
        return GameRuleRegistry.register(name, GameRules.Category.CHAT, GameRuleFactory.createBooleanRule(defaultValue));
    }

    @Override
    public void onInitialize() {

    }
}
