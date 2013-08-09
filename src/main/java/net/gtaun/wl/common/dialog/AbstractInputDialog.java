package net.gtaun.wl.common.dialog;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.common.dialog.AbstractDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public class AbstractInputDialog extends net.gtaun.shoebill.common.dialog.AbstractInputDialog
{
	protected String append;
	
	
	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager)
	{
		super(player, shoebill, rootEventManager);
	}

	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, AbstractDialog parentDialog)
	{
		super(player, shoebill, rootEventManager, parentDialog);
	}

	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, boolean passwordMode)
	{
		super(player, shoebill, rootEventManager, passwordMode);
	}
	
	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, AbstractDialog parentDialog, boolean passwordMode)
	{
		super(player, shoebill, rootEventManager, passwordMode, parentDialog);
	}

	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, String caption, String message)
	{
		super(player, shoebill, rootEventManager, caption, message);
	}

	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, AbstractDialog parentDialog, String caption, String message)
	{
		super(player, shoebill, rootEventManager, caption, message, parentDialog);
	}

	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, String caption, String message, boolean passwordMode)
	{
		super(player, shoebill, rootEventManager, caption, message, passwordMode);
	}
	
	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, AbstractDialog parentDialog, String caption, String message, boolean passwordMode)
	{
		super(player, shoebill, rootEventManager, caption, message, passwordMode, parentDialog);
	}
	
	protected void show(String text)
	{
		if (append != null) super.show(this.message + "\n\n" + append);
		else super.show(text);
	}
	
	@Override
	protected void onClickCancel()
	{
		player.playSound(1084, player.getLocation());
		showParentDialog();
	}
}
