package net.gtaun.wl.common.dialog;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.common.dialog.AbstractDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public abstract class AbstractMsgboxDialog extends net.gtaun.shoebill.common.dialog.AbstractMsgboxDialog
{
	protected AbstractMsgboxDialog(Player player, Shoebill shoebill, EventManager rootEventManager)
	{
		super(player, shoebill, rootEventManager);
	}
	
	protected AbstractMsgboxDialog(Player player, Shoebill shoebill, EventManager rootEventManager, AbstractDialog dialog)
	{
		super(player, shoebill, rootEventManager, dialog);
	}
	
	@Override
	protected void onClickCancel()
	{
		player.playSound(1084, player.getLocation());
		showParentDialog();
	}
}
