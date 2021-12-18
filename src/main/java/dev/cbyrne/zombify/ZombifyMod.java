package dev.cbyrne.zombify;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZombifyMod implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Have fun curing your zombie friends!");
    }
}
