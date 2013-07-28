package net.gtaun.wl.common.dialog;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.common.dialog.AbstractDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public abstract class AbstractPageListDialog extends net.gtaun.shoebill.common.dialog.AbstractPageListDialog
{
	public AbstractPageListDialog(Player player, Shoebill shoebill, EventManager eventManager)
	{
		super(player, shoebill, eventManager);
	}
	
	public AbstractPageListDialog(Player player, Shoebill shoebill, EventManager eventManager, AbstractDialog parentDialog)
	{
		super(player, shoebill, eventManager, parentDialog);
	}

	@Override
	public void onPageUpdate()
	{
		player.playSound(1083, player.getLocation());
	}
	
	@Override
	protected void onClickCancel()
	{
		player.playSound(1084, player.getLocation());
		showParentDialog();
	}
}
