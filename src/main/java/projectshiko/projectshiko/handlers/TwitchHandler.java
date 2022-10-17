package projectshiko.projectshiko.handlers;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.pubsub.events.RewardRedeemedEvent;
import org.bukkit.plugin.java.JavaPlugin;
import projectshiko.projectshiko.ProjectShiko;

public class TwitchHandler {
    public TwitchHandler() {
        TwitchClient twitchClient = TwitchClientBuilder.builder()
                .withEnablePubSub(true)
                .build();
        twitchClient.getPubSub().listenForChannelPointsRedemptionEvents(new OAuth2Credential("twitch", ""), "");
        twitchClient.getEventManager().onEvent(RewardRedeemedEvent.class, this::onRewardRedeemed);
    }

    public void onRewardRedeemed(RewardRedeemedEvent event){
        String rewardTitle = event.getRedemption().getReward().getTitle();
        new RewardHandler(rewardTitle);
    }
}