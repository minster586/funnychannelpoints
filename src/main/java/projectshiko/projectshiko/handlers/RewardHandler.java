package projectshiko.projectshiko.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import projectshiko.projectshiko.ProjectShiko;

import java.util.Objects;
import java.util.Random;

import static org.bukkit.Bukkit.getServer;
public class RewardHandler {
    public RewardHandler(String rewardTitle) {
        getServer().getScheduler().scheduleSyncDelayedTask(ProjectShiko.getPlugin(), () -> {
            if (Objects.equals(rewardTitle, "Aw Man")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER);
                }
            } else if (Objects.equals(rewardTitle, "Funky Booze")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Random random = new Random();
                    int chanceOutOf = 10;
                    int choice = random.nextInt(chanceOutOf);

                    int effectDuration = 1200;
                    int effectAmplifier = 20;

                    if (choice == 0) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, effectDuration, effectAmplifier));
                    } else if (choice == 1) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, effectDuration, effectAmplifier));
                    } else if (choice == 2) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, effectDuration, effectAmplifier));
                    } else if (choice == 3) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, effectDuration, effectAmplifier));
                    } else if (choice == 4) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, effectDuration, effectAmplifier));
                    } else if (choice == 5) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, effectDuration, effectAmplifier));
                    } else if (choice == 6) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, effectDuration, effectAmplifier));
                    } else if (choice == 7) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, effectDuration, effectAmplifier));
                    } else if (choice == 8) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, effectDuration, effectAmplifier));
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, effectDuration, effectAmplifier));
                    }
                }
            } else if (Objects.equals(rewardTitle, "Where Am I?")) {
                Random random = new Random();
                int chanceOutOf = 20480;
                int xLocation = random.nextInt(chanceOutOf) - 10240;
                int zLocation = random.nextInt(chanceOutOf) - 10240;
                for (Player player : Bukkit.getOnlinePlayers()){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1200, 1));
                    player.teleport(new Location(player.getWorld(), xLocation, 200, zLocation));
                }
            } else if (Objects.equals(rewardTitle, "Touch The Sky")) {
                for (Player player : Bukkit.getOnlinePlayers()){
                    player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 500, player.getLocation().getZ()));
                }
            } else if (Objects.equals(rewardTitle, "RIP Run")) {
                for (Player player : Bukkit.getOnlinePlayers()){
                    player.getInventory().clear();
                }
            }
        }, 20L);
    }
}