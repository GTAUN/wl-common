package net.gtaun.wl.common.dialog;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.common.dialog.AbstractDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public class AbstractListDialog extends net.gtaun.shoebill.common.dialog.AbstractListDialog
{
	protected AbstractListDialog(Player player, Shoebill shoebill, EventManager eventManager)
	{
		super(player, shoebill, eventManager);
	}
	
	protected AbstractListDialog(Player player, Shoebill shoebill, EventManager eventManager, AbstractDialog parentDialog)
	{
		super(player, shoebill, eventManager, parentDialog);
	}
	
	@Override
	protected void onClickCancel()
	{
		player.playSound(1084, player.getLocation());
		showParentDialog();
	}
}
