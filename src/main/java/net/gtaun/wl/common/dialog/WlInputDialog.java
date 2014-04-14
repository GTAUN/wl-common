/**
 * WL Common Library
 * Copyright (C) 2013 MK124
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.gtaun.wl.common.dialog;

import net.gtaun.shoebill.common.dialog.DialogTextSupplier;
import net.gtaun.shoebill.common.dialog.InputDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public class WlInputDialog extends InputDialog
{
	protected String append;
	
	
	public WlInputDialog(Player player, EventManager rootEventManager)
	{
		super(player, rootEventManager);
		init();
	}

	public WlInputDialog(Player player, EventManager rootEventManager, boolean passwordMode)
	{
		super(player, rootEventManager, passwordMode);
		init();
	}

	public WlInputDialog(Player player, EventManager rootEventManager, String caption, String message)
	{
		super(player, rootEventManager, caption, message);
		init();
	}
	
	public WlInputDialog(Player player, EventManager rootEventManager, String caption, String message, boolean passwordMode)
	{
		super(player, rootEventManager, caption, message, passwordMode);
		init();
	}

	public WlInputDialog(Player player, EventManager rootEventManager, DialogTextSupplier captionSupplier, DialogTextSupplier messageSupplier)
	{
		super(player, rootEventManager, captionSupplier, messageSupplier);
		init();
	}
	
	public WlInputDialog(Player player, EventManager rootEventManager, DialogTextSupplier captionSupplier, DialogTextSupplier messageSupplier, boolean passwordMode)
	{
		super(player, rootEventManager, captionSupplier, messageSupplier, passwordMode);
		init();
	}
	
	private void init()
	{
		setClickCancelHandler((d) ->
		{
			player.playSound(1084, player.getLocation());
			showParentDialog();		
		});
	}
	
	protected void show(String text)
	{
		if (append != null) super.show(text + "\n\n" + append);
		else super.show(text);
	}
}
