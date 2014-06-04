package pl.website.bcsn.boltandban;

import org.bukkit.Location;

public class BanningThread implements Runnable {
	

	@Override
	public void run() {
		
		
		Location loc = BoltAndBan.server.getPlayerExact(BoltAndBan.victimName).getLocation();
		
		Location boltLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
		loc.getWorld().strikeLightning(boltLoc);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			BoltAndBan.server.getLogger()
					.severe("Exception in BoltAndBan banning thread:");
			e.printStackTrace();
		}

		BoltAndBan.server.dispatchCommand(BoltAndBan.server.getConsoleSender(), "ban " + BoltAndBan.victimName);
		BoltAndBan.server.getLogger().fine(
				"Player " + BoltAndBan.victimName + " was banned succesfully!");
	}

}
