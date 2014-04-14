package net.gtaun.wl.common.dialog;

import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.Event;
import net.gtaun.util.event.EventManager;

public abstract class ListDialogExtendEvent extends Event
{
	protected final Player player;
	protected final EventManager eventManager;
	protected final WlPageListDialog dialog;
	
	
	public ListDialogExtendEvent(Player player, EventManager eventManager, WlPageListDialog dialog)
	{
		this.player = player;
		this.eventManager = eventManager;
		this.dialog = dialog;
	}

	public Player getPlayer()
	{
		return player;
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
