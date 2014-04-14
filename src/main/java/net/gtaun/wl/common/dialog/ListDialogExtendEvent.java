package net.gtaun.wl.common.dialog;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.Event;
import net.gtaun.util.event.EventManager;

public abstract class ListDialogExtendEvent extends Event
{
	protected final Player player;
	protected final Shoebill shoebill;
	protected final EventManager eventManager;
	protected final WlPageListDialog dialog;
	
	
	public ListDialogExtendEvent(Player player, Shoebill shoebill, EventManager eventManager, WlPageListDialog dialog)
	{
		this.player = player;
		this.shoebill = shoebill;
		this.eventManager = eventManager;
		this.dialog = dialog;
	}

	public Player getPlayer()
	{
		return player;
	}
	
	public Shoebill getShoebill()
	{
		return shoebill;
	}
	
	public EventManager getEventManager()
	{
		return eventManager;
	}
	
	public WlPageListDialog getDialog()
	{
		return dialog;
	}
}
