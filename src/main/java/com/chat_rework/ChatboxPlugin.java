package com.chat_rework;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "ChatboxPlugin"
)
public class ChatboxPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ChatboxConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessageReceived) {
		if (!chatMessageReceived.getMessage().isEmpty()) {
			log.info("name:" +  chatMessageReceived.getName());
			log.info("message:" + chatMessageReceived.getMessage());
			log.info("sender:" + chatMessageReceived.getSender());
			//client.addChatMessage(ChatMessageType.GAMEMESSAGE, chatMessageReceived.getName(), chatMessageReceived.getMessage(), chatMessageReceived.getSender());
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
//		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
//		{
//			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
//		}
	}

	@Provides
	ChatboxConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatboxConfig.class);
	}
}
