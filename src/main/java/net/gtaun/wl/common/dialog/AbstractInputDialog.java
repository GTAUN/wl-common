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
		super(player, shoebill, rootEventManager, parentDialog, passwordMode);
	}

	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, String caption, String message)
	{
		super(player, shoebill, rootEventManager, caption, message);
	}

	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, AbstractDialog parentDialog, String caption, String message)
	{
		super(player, shoebill, rootEventManager, parentDialog, caption, message);
	}

	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, String caption, String message, boolean passwordMode)
	{
		super(player, shoebill, rootEventManager, caption, message, passwordMode);
	}
	
	public AbstractInputDialog(Player player, Shoebill shoebill, EventManager rootEventManager, AbstractDialog parentDialog, String caption, String message, boolean passwordMode)
	{
		super(player, shoebill, rootEventManager, parentDialog, caption, message, passwordMode);
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
