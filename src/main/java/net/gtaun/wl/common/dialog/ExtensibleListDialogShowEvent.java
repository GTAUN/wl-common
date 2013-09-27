package net.gtaun.wl.common.dialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.common.dialog.AbstractDialog;
import net.gtaun.shoebill.common.dialog.AbstractListDialog.DialogListItem;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.Event;
import net.gtaun.util.event.EventManager;

public abstract class ExtensibleListDialogShowEvent extends Event
{
	protected final List<DialogListItem> dialogItems;
	
	protected final Player player;
	protected final Shoebill shoebill;
	protected final EventManager eventManager;
	protected final AbstractDialog parentDialog;
	
	
	public ExtensibleListDialogShowEvent(Player player, Shoebill shoebill, EventManager eventManager, AbstractDialog parentDialog)
	{
		this.dialogItems = new ArrayList<>();
		
		this.player = player;
		this.shoebill = shoebill;
		this.eventManager = eventManager;
		this.parentDialog = parentDialog;
	}

	public List<DialogListItem> getDialogItems()
	{
		return Collections.unmodifiableList(dialogItems);
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
	
	public AbstractDialog getParentDialog()
	{
		return parentDialog;
	}
	
	public void addItem(DialogListItem item)
	{
		dialogItems.add(item);
	}
	
	public AbstractListDialog generateDialog(String caption)
	{
		return generateDialog(caption, null, null);
	}
	
	public AbstractListDialog generateDialog(final String captionStr, final String ok, final String cancel)
	{
		return new AbstractListDialog(player, shoebill, eventManager, parentDialog)
		{
			{
				this.caption = captionStr;
				if (ok != null) this.buttonOk = ok;
				if (cancel != null) this.buttonCancel = cancel;
				
				dialogListItems.addAll(dialogItems);
			}
		};
	}
	
	public AbstractPageListDialog generatePagedDialog(String caption)
	{
		return generatePagedDialog(caption, null, null);
	}
	
	public AbstractPageListDialog generatePagedDialog(final String captionStr, final String ok, final String cancel)
	{
		return new AbstractPageListDialog(player, shoebill, eventManager, parentDialog)
		{
			{
				this.caption = captionStr;
				if (ok != null) this.buttonOk = ok;
				if (cancel != null) this.buttonCancel = cancel;
				
				dialogListItems.addAll(dialogItems);
			}
		};
	}
}
